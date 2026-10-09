package com.example.diseaseinformationhealthassistantmobileapplication.ui.screens

import android.content.Intent
import android.speech.tts.TextToSpeech
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Contrast
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.MedicalServices
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.Science
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.SmartToy
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diseaseinformationhealthassistantmobileapplication.data.DiseaseImageMapper
import com.example.diseaseinformationhealthassistantmobileapplication.data.DiseaseRepository
import com.example.diseaseinformationhealthassistantmobileapplication.data.FavoriteRepository
import com.example.diseaseinformationhealthassistantmobileapplication.data.HistoryRepository
import com.example.diseaseinformationhealthassistantmobileapplication.ui.theme.ErrorColor
import com.example.diseaseinformationhealthassistantmobileapplication.ui.theme.TealPrimary
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiseaseDetailScreen(
    diseaseId: String,
    language: String,
    onBack: () -> Unit,
    onAiAssistantClick: () -> Unit = {}
) {
    val disease = DiseaseRepository.getDiseaseById(diseaseId, language)
    val context = LocalContext.current

    // Add to history when screen opens
    LaunchedEffect(diseaseId) {
        HistoryRepository.addHistory(diseaseId)
    }

    var tts by remember { mutableStateOf<TextToSpeech?>(null) }
    var isDarkBackground by remember { mutableStateOf(false) }
    var fontSizeBase by remember { mutableStateOf(16f) }
    var selectedTab by remember { mutableStateOf(0) }
    var isFavorite by remember { mutableStateOf(FavoriteRepository.isFavorite(diseaseId)) }
    var showSourcesDialog by remember { mutableStateOf(false) }

    DisposableEffect(context) {
        val textToSpeech = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                val loc = when (language) {
                    "en" -> Locale.ENGLISH
                    else -> Locale.ENGLISH
                }
                tts?.language = loc
            }
        }
        tts = textToSpeech
        onDispose {
            textToSpeech.stop()
            textToSpeech.shutdown()
        }
    }

    // Dialog listing trusted online references for this disease.
    if (showSourcesDialog) {
        val diseaseName = disease?.name.orEmpty()
        AlertDialog(
            onDismissRequest = { showSourcesDialog = false },
            title = {
                Text(
                    sectionTitle(
                        "Learn More Online",
                        "Dabalaan Baradhu (Online)",
                        "ተጨማሪ ይወቁ (በመስመር ላይ)",
                        language
                    )
                )
            },
            text = {
                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    Text(
                        sectionTitle(
                            "Open a trusted medical reference about this disease:",
                            "Wabii fayyaa amansiisaa dhibee kanaa bani:",
                            "ስለዚህ በሽታ የታመነ የህክምና ምንጭ ይክፈቱ፦",
                            language
                        ),
                        fontSize = 13.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    if (diseaseName.isNotBlank()) {
                        SourceOption("$diseaseName · MedlinePlus") {
                            OnlineLinks.open(context, OnlineLinks.medlinePlusSearch(diseaseName))
                        }
                        SourceOption("$diseaseName · WHO") {
                            OnlineLinks.open(context, OnlineLinks.whoSearch(diseaseName))
                        }
                        HorizontalDivider(modifier = Modifier.padding(vertical = 6.dp))
                    }
                    OnlineLinks.trustedSources.forEach { source ->
                        SourceOption(source.name) {
                            OnlineLinks.open(context, source.homepage)
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showSourcesDialog = false }) {
                    Text(sectionTitle("Close", "Cufi", "ዝጋ", language))
                }
            }
        )
    }

    val backgroundColor = if (isDarkBackground) Color.Black else MaterialTheme.colorScheme.background
    val textColor = if (isDarkBackground) Color.White else MaterialTheme.colorScheme.onBackground
    val titleSize = (fontSizeBase + 4).sp
    val bodySize = fontSizeBase.sp
    val smallSize = (fontSizeBase - 2).sp

    // Tabs matching UI.png disease detail screen
    val tabs = listOf(
        sectionTitle("Overview", "Bal'ina", "አጠቃላይ", language),
        sectionTitle("Symptoms", "Mallattoolee", "ምልክቶች", language),
        sectionTitle("Causes", "Sababoota", "መንስኤዎች", language),
        sectionTitle("Food", "Nyaata", "ምግብ", language),
        sectionTitle("Treatment", "Daawwii", "መድሃኒት", language)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        disease?.name ?: when (language) {
                            "en" -> "Details"
                            "om" -> "Bal'ina"
                            else -> "ዝርዝሮች"
                        }
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    // Favorite toggle in the top bar
                    IconButton(onClick = {
                        if (isFavorite) {
                            FavoriteRepository.removeFavorite(diseaseId)
                        } else {
                            FavoriteRepository.addFavorite(diseaseId)
                        }
                        isFavorite = !isFavorite
                    }) {
                        Icon(
                            imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                            contentDescription = "Favorite",
                            tint = if (isFavorite) ErrorColor else MaterialTheme.colorScheme.onSurface
                        )
                    }
                    if (disease != null) {
                        IconButton(onClick = {
                            val textToRead = "${disease.name}. ${disease.definition}. Symptoms include: ${disease.symptoms.joinToString(", ")}. Causes: ${disease.causes.joinToString(", ")}."
                            tts?.speak(textToRead, TextToSpeech.QUEUE_FLUSH, null, "TTS_ID")
                        }) {
                            Icon(Icons.AutoMirrored.Filled.VolumeUp, contentDescription = "Read Aloud")
                        }
                        IconButton(onClick = {
                            val shareText = "${disease.name}\n\n${disease.definition}\n\nSymptoms: ${disease.symptoms.joinToString(", ")}"
                            val sendIntent = Intent(Intent.ACTION_SEND).apply {
                                putExtra(Intent.EXTRA_TEXT, shareText)
                                type = "text/plain"
                            }
                            val shareIntent = Intent.createChooser(sendIntent, null)
                            context.startActivity(shareIntent)
                        }) {
                            Icon(Icons.Default.Share, contentDescription = "Share")
                        }
                    }
                }
            )
        }
    ) { padding ->
        val currentDisease = disease
        if (currentDisease == null) {
            Box(modifier = Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.Center) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = when (language) {
                            "en" -> "No disease found"
                            "om" -> "Dhibichi hin argamne"
                            else -> "በሽታ አልተገኘም"
                        },
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = when (language) {
                            "en" -> "Try checking the disease name or go back to the list"
                            "om" -> "Barbaadduu dhiibichi nama jijjiiramaa ykn gara liikan barsiiso"
                            else -> "በሽታውን ፈልግ ወይም ወደ ማጠቃለያ ውጤት ማለፍ ትሞሃለህ"
                        },
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = onBack,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer
                        )
                    ) {
                        Text(
                            text = when (language) {
                                "en" -> "Go Back"
                                "om" -> "Gara Uumamaa Mask’a"
                                else -> "ገጥሽ ወደ ቀድመው"
                            }
                        )
                    }
                }
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(backgroundColor)
                    .padding(padding)
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                // Formatting Controls
                Row(
                    modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { isDarkBackground = !isDarkBackground }) {
                        Icon(Icons.Default.Contrast, contentDescription = "Toggle Background Color", tint = textColor)
                    }
                    IconButton(onClick = { if (fontSizeBase > 10f) fontSizeBase -= 2f }) {
                        Icon(Icons.Default.Remove, contentDescription = "Decrease Font Size", tint = textColor)
                    }
                    Text("Aa", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = textColor)
                    IconButton(onClick = { if (fontSizeBase < 30f) fontSizeBase += 2f }) {
                        Icon(Icons.Default.Add, contentDescription = "Increase Font Size", tint = textColor)
                    }
                }

                // Disease Photo Header Card matching UI.png
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f))
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = DiseaseImageMapper.getDiseaseImageResId(currentDisease.id)),
                            contentDescription = currentDisease.name,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(160.dp)
                                .clip(RoundedCornerShape(12.dp)),
                            contentScale = ContentScale.Fit
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = currentDisease.name,
                            fontSize = (fontSizeBase + 6).sp,
                            fontWeight = FontWeight.Bold,
                            color = textColor
                        )
                        Text(
                            text = currentDisease.category,
                            fontSize = smallSize,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }

                // Status chips matching UI.png (e.g. "Chronic" / "Common")
                Row(
                    modifier = Modifier.padding(bottom = 12.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    DetailChip(text = currentDisease.category)
                    DetailChip(
                        text = sectionTitle("Common", "Barreeessa", "የተለመደ", language)
                    )
                }

                // Tab row matching UI.png (Overview | Symptoms | Causes | Food | Treatment)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surface)
                ) {
                    tabs.forEachIndexed { index, label ->
                        val isSelected = selectedTab == index
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .clickable { selectedTab = index }
                                .padding(vertical = 12.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = label,
                                fontSize = 12.sp,
                                maxLines = 1,
                                color = if (isSelected) TealPrimary else MaterialTheme.colorScheme.onSurfaceVariant,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(0.7f)
                                    .height(3.dp)
                                    .background(
                                        color = if (isSelected) TealPrimary else Color.Transparent,
                                        shape = RoundedCornerShape(2.dp)
                                    )
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                when (selectedTab) {
                    // ---- Overview ----
                    0 -> {
                        DetailPanelCard(
                            title = sectionTitle(
                                "What is ${currentDisease.name}?",
                                "Maani ${currentDisease.name} dha?",
                                "${currentDisease.name} ምንድን ነው?",
                                language
                            ),
                            icon = Icons.Default.Info,
                            titleSize = titleSize,
                            textColor = textColor
                        ) {
                            Text(
                                text = currentDisease.definition,
                                fontSize = bodySize,
                                color = textColor
                            )
                        }

                        val diseaseTypes = currentDisease.types
                        if (!diseaseTypes.isNullOrEmpty()) {
                            var expanded by remember { mutableStateOf(false) }
                            Column(modifier = Modifier.padding(vertical = 8.dp)) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable { expanded = !expanded }
                                        .padding(vertical = 8.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = sectionTitle("See Types of this Disease", "Gosoota Dhibee Kanaa Ilaali", "የዚህን በሽታ አይነቶች ይመልከቱ", language),
                                        fontSize = titleSize,
                                        color = MaterialTheme.colorScheme.primary,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Icon(
                                        imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                        contentDescription = "Toggle Types",
                                        tint = MaterialTheme.colorScheme.primary
                                    )
                                }
                                if (expanded) {
                                    diseaseTypes.forEach { type ->
                                        Column(modifier = Modifier.padding(start = 8.dp, top = 4.dp, bottom = 4.dp)) {
                                            Text(text = "• ${type.name}", fontWeight = FontWeight.Bold, fontSize = bodySize, color = textColor)
                                            Text(text = type.description, fontSize = smallSize, color = textColor, modifier = Modifier.padding(start = 12.dp, top = 2.dp))
                                        }
                                    }
                                }
                            }
                        }
                    }

                    // ---- Symptoms ----
                    1 -> {
                        DetailPanelCard(
                            title = sectionTitle("Common Symptoms", "Mallattoolee Barreeessaa", "የተለመዱ ምልክቶች", language),
                            icon = Icons.AutoMirrored.Filled.List,
                            titleSize = titleSize,
                            textColor = textColor
                        ) {
                            currentDisease.symptoms.forEach { symptom ->
                                Text(
                                    text = "• $symptom",
                                    fontSize = bodySize,
                                    color = textColor,
                                    modifier = Modifier.padding(top = 4.dp)
                                )
                            }
                        }
                    }

                    // ---- Causes ----
                    2 -> {
                        DetailPanelCard(
                            title = sectionTitle("Causes", "Sababoota", "መንስኤዎች", language),
                            icon = Icons.Default.Science,
                            titleSize = titleSize,
                            textColor = textColor
                        ) {
                            currentDisease.causes.forEach { cause ->
                                Text(
                                    text = "• $cause",
                                    fontSize = bodySize,
                                    color = textColor,
                                    modifier = Modifier.padding(top = 4.dp)
                                )
                            }
                        }
                    }

                    // ---- Food ----
                    3 -> {
                        val foodAdviceText = currentDisease.foodGuidance
                        DetailPanelCard(
                            title = sectionTitle("Food Guidance & Healthy Diet", "Gorsa Nyaataa", "የምግብ መመሪያ", language),
                            icon = Icons.Default.Restaurant,
                            titleSize = titleSize,
                            textColor = textColor
                        ) {
                            if (!foodAdviceText.isNullOrEmpty()) {
                                Image(
                                    painter = painterResource(id = DiseaseImageMapper.getFoodImageResId(currentDisease.id)),
                                    contentDescription = "Food Guide Image for ${currentDisease.name}",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(140.dp)
                                        .clip(RoundedCornerShape(12.dp)),
                                    contentScale = ContentScale.Fit
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                                Text(text = foodAdviceText, fontSize = bodySize, color = textColor)
                            } else {
                                Text(
                                    text = sectionTitle("No food guidance available.", "Gorsa nyaataa hin jiru.", "የምግብ መመሪያ አልተገኘም።", language),
                                    fontSize = bodySize,
                                    color = textColor
                                )
                            }
                        }
                    }

                    // ---- Treatment ----
                    else -> {
                        val diseaseMedicines = currentDisease.medicines
                        if (!diseaseMedicines.isNullOrEmpty()) {
                            DetailPanelCard(
                                title = sectionTitle("Medicines", "Qoricha", "መድሃኒቶች", language),
                                icon = Icons.Default.MedicalServices,
                                titleSize = titleSize,
                                textColor = textColor
                            ) {
                                diseaseMedicines.forEach { medicine ->
                                    Text(
                                        text = "• $medicine",
                                        fontSize = bodySize,
                                        color = textColor,
                                        modifier = Modifier.padding(top = 4.dp)
                                    )
                                }
                                val medicineGuide = currentDisease.medicineGuide
                                if (!medicineGuide.isNullOrEmpty()) {
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = sectionTitle("How to take these medicines", "Yeroo qorichaa ta'ee", "ይህን መድሃኒት እንዴት መውሰድ ነው", language),
                                        fontSize = smallSize,
                                        fontWeight = FontWeight.Bold,
                                        color = textColor
                                    )
                                    Text(
                                        text = medicineGuide,
                                        fontSize = smallSize,
                                        color = textColor,
                                        modifier = Modifier.padding(start = 12.dp, top = 2.dp)
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(12.dp))
                        }

                        DetailPanelCard(
                            title = sectionTitle("Prevention", "Ittisa", "መከላከል", language),
                            icon = Icons.Default.Info,
                            titleSize = titleSize,
                            textColor = textColor
                        ) {
                            currentDisease.prevention.forEach { item ->
                                Text(
                                    text = "• $item",
                                    fontSize = bodySize,
                                    color = textColor,
                                    modifier = Modifier.padding(top = 4.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        DetailPanelCard(
                            title = sectionTitle("Safety Practices", "Of-eeggannoo", "የጥንቃቄ ተግባራት", language),
                            icon = Icons.Default.Info,
                            titleSize = titleSize,
                            textColor = textColor
                        ) {
                            currentDisease.safetyPractices.forEach { item ->
                                Text(
                                    text = "• $item",
                                    fontSize = bodySize,
                                    color = textColor,
                                    modifier = Modifier.padding(top = 4.dp)
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Ask AI Assistant button matching UI.png
                Button(
                    onClick = onAiAssistantClick,
                    modifier = Modifier.fillMaxWidth().height(52.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = TealPrimary)
                ) {
                    Icon(
                        imageVector = Icons.Default.SmartToy,
                        contentDescription = null,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = sectionTitle("Ask AI Assistant", "Gargaaraa AI Gaafadhu", "የአይኤ ረዳት ጠይቅ", language),
                        fontSize = titleSize,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Learn More Button - opens a picker of trusted medical references
                Button(
                    onClick = { showSourcesDialog = true },
                    modifier = Modifier.fillMaxWidth().height(56.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.tertiary
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.OpenInNew,
                        contentDescription = "Learn More Online",
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = sectionTitle("Learn More (Online Reference)", "Dabalaan Baradhu (Online)", "ተጨማሪ ይወቁ (በመስመር ላይ)", language),
                        fontSize = titleSize
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

private fun sectionTitle(en: String, om: String, am: String, language: String): String =
    when (language) {
        "en" -> en
        "om" -> om
        else -> am
    }

/** A single tappable online reference row inside the "Learn More" dialog. */
@Composable
private fun SourceOption(text: String, onClick: () -> Unit) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 12.dp),
        color = TealPrimary,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    )
}

/** Outlined pill chip matching the UI.png detail screen ("Chronic", "Common"). */
@Composable
private fun DetailChip(text: String) {
    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = TealPrimary,
                shape = RoundedCornerShape(16.dp)
            )
            .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(16.dp))
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        Text(
            text = text,
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium,
            color = TealPrimary
        )
    }
}

/** Card with a colored icon header, used for the detail screen tab panels. */
@Composable
private fun DetailPanelCard(
    title: String,
    icon: ImageVector,
    titleSize: TextUnit,
    textColor: Color,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f)
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(22.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = title,
                    fontSize = titleSize,
                    fontWeight = FontWeight.Bold,
                    color = textColor
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            content()
        }
    }
}

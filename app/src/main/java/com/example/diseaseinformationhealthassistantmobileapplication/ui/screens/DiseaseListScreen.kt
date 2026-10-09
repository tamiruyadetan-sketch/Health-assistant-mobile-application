package com.example.diseaseinformationhealthassistantmobileapplication.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import android.widget.Toast
import androidx.compose.ui.unit.dp
import com.example.diseaseinformationhealthassistantmobileapplication.data.Disease
import com.example.diseaseinformationhealthassistantmobileapplication.data.DiseaseRepository
import com.example.diseaseinformationhealthassistantmobileapplication.voice.rememberSpeechRecognizer
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.example.diseaseinformationhealthassistantmobileapplication.data.DiseaseImageMapper
import androidx.compose.material.icons.automirrored.filled.ArrowForward

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiseaseListScreen(
    language: String,
    onDiseaseClick: (String) -> Unit,
    onLanguageToggle: () -> Unit,
    onEmergencyClick: () -> Unit,
    onAiAssistantClick: () -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }
    val context = LocalContext.current

    // Voice assistant: search by voice when the user cannot type.
    val startVoiceSearch = rememberSpeechRecognizer(
        language = language,
        onResult = { text -> searchQuery = text },
        onError = { message -> Toast.makeText(context, message, Toast.LENGTH_SHORT).show() }
    )
    val diseases = DiseaseRepository.getDiseases(language)
    val filteredDiseases = diseases.filter {
        it.name.contains(searchQuery, ignoreCase = true) || 
        it.category.contains(searchQuery, ignoreCase = true)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        when (language) {
                            "en" -> "Health Assistant"
                            "om" -> "Gargaara Fayyaa"
                            else -> "የጤና ረዳት"
                        }
                    )
                },
                actions = {
                    Button(onClick = onLanguageToggle) {
                        Text(
                            when (language) {
                                "en" -> "Oromoo"
                                "om" -> "አማርኛ"
                                else -> "English"
                            }
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                FloatingActionButton(onClick = onAiAssistantClick, containerColor = MaterialTheme.colorScheme.tertiaryContainer) {
                    Icon(Icons.Default.Info, contentDescription = "AI Assistant")
                }
                FloatingActionButton(onClick = onEmergencyClick, containerColor = MaterialTheme.colorScheme.errorContainer) {
                    Icon(Icons.Default.Warning, contentDescription = "Emergency")
                }
            }
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(
                        when (language) {
                            "en" -> "Search disease..."
                            "om" -> "Dhibee barbaadi..."
                            else -> "በሽታ ፈልግ..."
                        }
                    )
                },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                trailingIcon = {
                    IconButton(onClick = { startVoiceSearch() }) {
                        Icon(
                            Icons.Default.Mic,
                            contentDescription = when (language) {
                                "en" -> "Search by voice"
                                "om" -> "Afaanii barbaadi"
                                else -> "በድምጽ ፈልግ"
                            }
                        )
                    }
                }
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(filteredDiseases) { disease ->
                    DiseaseItem(disease = disease, onClick = { onDiseaseClick(disease.id) })
                }
            }
        }
    }
}

@Composable
fun DiseaseItem(disease: Disease, onClick: () -> Unit) {
    val imageResId = DiseaseImageMapper.getDiseaseImageResId(disease.id)
    val learnMoreText = when (disease.language) {
        "en" -> "Learn More"
        "om" -> "Dabalaan Baradhu"
        else -> "ተጨማሪ ይወቁ"
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
            ) {
                // Disease photo / image
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = disease.name,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .padding(2.dp),
                    contentScale = ContentScale.Fit
                )
                
                Spacer(modifier = Modifier.width(14.dp))
                
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = disease.name,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = disease.category,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = disease.definition,
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
            Spacer(modifier = Modifier.height(8.dp))

            // Learn More Button
            Button(
                onClick = onClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(42.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            ) {
                Text(
                    text = learnMoreText,
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.width(6.dp))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}

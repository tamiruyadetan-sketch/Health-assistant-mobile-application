package com.example.diseaseinformationhealthassistantmobileapplication.ui.screens

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diseaseinformationhealthassistantmobileapplication.data.UserRepository
import com.example.diseaseinformationhealthassistantmobileapplication.ui.theme.TealLight
import com.example.diseaseinformationhealthassistantmobileapplication.ui.theme.TealPrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    language: String,
    darkMode: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    blackBackground: Boolean,
    onBackgroundChange: (Boolean) -> Unit,
    onLanguageChange: (String) -> Unit,
    onBack: () -> Unit,
    onFavoritesClick: () -> Unit,
    onAboutClick: () -> Unit,
    onProfileClick: () -> Unit,
    onPrivacyClick: () -> Unit,
    onMedicalSourcesClick: () -> Unit,
    onDisclaimerClick: () -> Unit
) {
    var showLanguageDialog by remember { mutableStateOf(false) }
    var notifications by remember { mutableStateOf(true) }

    val context = LocalContext.current
    val profile = UserRepository.profile

    if (showLanguageDialog) {
        LanguageSelectionDialog(
            currentLanguage = language,
            onLanguageSelected = { newLang ->
                onLanguageChange(newLang)
                showLanguageDialog = false
            },
            onDismiss = { showLanguageDialog = false }
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Settings", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // ---- Profile card (guest or registered user) ----
            item {
                val photoBitmap = remember(profile?.photoUri) {
                    profile?.photoUri?.let { loadDownsampledBitmap(context, Uri.parse(it)) }
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(onClick = onProfileClick),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(56.dp)
                                .clip(CircleShape)
                                .background(TealLight, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            if (photoBitmap != null) {
                                Image(
                                    bitmap = photoBitmap,
                                    contentDescription = "Profile photo",
                                    modifier = Modifier.fillMaxSize().clip(CircleShape),
                                    contentScale = ContentScale.Crop
                                )
                            } else {
                                Icon(
                                    imageVector = Icons.Default.Person,
                                    contentDescription = null,
                                    tint = TealPrimary,
                                    modifier = Modifier.size(32.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = profile?.displayName ?: "Guest User",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = profile?.email
                                    ?: "Tap to register and add your photo",
                                fontSize = 13.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
            }

            // ---- Background color choice (black or white) ----
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.FormatColorFill,
                                contentDescription = null,
                                tint = TealPrimary,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                text = "Background",
                                modifier = Modifier.weight(1f),
                                fontSize = 15.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                            BackgroundChip(
                                label = "White",
                                selected = !blackBackground,
                                onClick = { onBackgroundChange(false) }
                            )
                            BackgroundChip(
                                label = "Black",
                                selected = blackBackground,
                                onClick = { onBackgroundChange(true) }
                            )
                        }
                    }
                }
            }

            // ---- Settings items ----
            val itemsList = listOf(
                Triple(Icons.Default.Language, "Language") { showLanguageDialog = true },
                Triple(Icons.Default.Notifications, "Notifications") { notifications = !notifications },
                Triple(Icons.Default.DarkMode, "Dark Mode") { onDarkModeChange(!darkMode) },
                Triple(Icons.Default.Favorite, "My Favorites") { onFavoritesClick() },
                Triple(Icons.Default.Info, "About App") { onAboutClick() },
                Triple(Icons.Default.Lock, "Privacy") { onPrivacyClick() },
                Triple(Icons.Default.MedicalServices, "Medical Sources") { onMedicalSourcesClick() },
                Triple(Icons.Default.Warning, "Health Disclaimer") { onDisclaimerClick() }
            )

            itemsList.forEach { (icon, title, action) ->
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(onClick = action),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = icon,
                                contentDescription = null,
                                tint = TealPrimary,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                text = title,
                                modifier = Modifier.weight(1f),
                                fontSize = 15.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            if (title == "Dark Mode") {
                                Switch(
                                    checked = darkMode,
                                    onCheckedChange = onDarkModeChange,
                                    colors = SwitchDefaults.colors(checkedThumbColor = TealPrimary)
                                )
                            } else if (title == "Notifications") {
                                Switch(
                                    checked = notifications,
                                    onCheckedChange = { notifications = it },
                                    colors = SwitchDefaults.colors(checkedThumbColor = TealPrimary)
                                )
                            } else if (title == "Language") {
                                Text(
                                    text = when (language) {
                                        "en" -> "English"
                                        "om" -> "Afaan Oromoo"
                                        else -> "Amharic"
                                    },
                                    fontSize = 13.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            } else {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BackgroundChip(
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(20.dp),
        color = if (selected) TealPrimary else MaterialTheme.colorScheme.surfaceVariant,
        contentColor = if (selected) MaterialTheme.colorScheme.onPrimary
        else MaterialTheme.colorScheme.onSurfaceVariant
    ) {
        Text(
            text = label,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp),
            fontSize = 14.sp,
            fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium
        )
    }
}

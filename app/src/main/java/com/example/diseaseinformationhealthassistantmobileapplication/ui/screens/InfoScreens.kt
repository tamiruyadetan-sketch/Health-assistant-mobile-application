package com.example.diseaseinformationhealthassistantmobileapplication.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diseaseinformationhealthassistantmobileapplication.ui.theme.TealPrimary

data class InfoSection(val title: String, val body: List<String>)

// ---------------------------------------------------------------------------
// Shared scaffold for the static information screens.
// ---------------------------------------------------------------------------
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun InfoScreenScaffold(
    title: String,
    sections: List<InfoSection>,
    footer: String? = null,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(title, fontWeight = FontWeight.Bold) },
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
            items(sections.size) { index ->
                val section = sections[index]
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            section.title,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        section.body.forEachIndexed { i, line ->
                            if (i > 0) Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                line,
                                fontSize = 14.sp,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }
            }

            footer?.let {
                item {
                    Text(
                        it,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

// ---------------------------------------------------------------------------
// Privacy Policy
// ---------------------------------------------------------------------------
@Composable
fun PrivacyPolicyScreen(onBack: () -> Unit) {
    val sections = listOf(
        InfoSection(
            title = "Your privacy matters",
            body = listOf(
                "This app is designed to work offline and to keep your information on your own device. We do not run advertising, we do not track you across other apps, and we do not sell your data."
            )
        ),
        InfoSection(
            title = "Information stored on your device",
            body = listOf(
                "• Your profile: the name, email address, and profile photo you choose to provide when you register.",
                "• Your favorites and the history of diseases you have opened.",
                "• Your preferences: language, dark mode, and background color.",
                "All of the above is saved in the app's private storage on this device only. It is removed when you sign out or uninstall the app."
            )
        ),
        InfoSection(
            title = "Permissions we use and why",
            body = listOf(
                "• Microphone: used only when you tap the voice-search or voice-assessment button, so you can search by speaking instead of typing.",
                "• Internet: used only when you open an online reference (\"Learn More\") or use the optional AI Health Assistant.",
                "The app does not request location, contacts, camera, or storage permissions. When you pick a profile photo, Android's system photo picker returns only the single image you select."
            )
        ),
        InfoSection(
            title = "When information leaves your device",
            body = listOf(
                "• Voice input may be transcribed by your device's speech recognition service (for example, Google). That service is provided by your phone or its vendor, not by this app.",
                "• If you use the AI Health Assistant, the text of your question may be sent to the configured AI provider so it can generate a reply.",
                "• Opening an online reference sends the disease name to the website you chose, in the same way any web search works.",
                "In every one of these cases you take the action yourself, and nothing is sent otherwise."
            )
        ),
        InfoSection(
            title = "Children's privacy",
            body = listOf(
                "This app is intended for general health education and does not knowingly collect personal information from children. Because all data stays on the device, parents and guardians remain in full control."
            )
        ),
        InfoSection(
            title = "Your control over your data",
            body = listOf(
                "• Open your profile and choose \"Sign out\" to erase your registration details and photo.",
                "• Clearing the app's data in Android Settings removes everything the app has stored.",
                "• You never need an account to use the disease library, search, favorites, or emergency information."
            )
        )
    )
    InfoScreenScaffold(
        title = "Privacy",
        sections = sections,
        footer = "This privacy summary describes how the app itself handles data. It is provided for transparency and is not legal advice.",
        onBack = onBack
    )
}

// ---------------------------------------------------------------------------
// Health Disclaimer
// ---------------------------------------------------------------------------
@Composable
fun HealthDisclaimerScreen(onBack: () -> Unit) {
    val sections = listOf(
        InfoSection(
            title = "Educational information only",
            body = listOf(
                "The content in this app is provided for general health education and awareness. It is not medical advice, diagnosis, or treatment, and it does not replace a consultation with a qualified healthcare professional.",
                "Using this app does not create a doctor–patient relationship between you and the app or its developers."
            )
        ),
        InfoSection(
            title = "Do not delay care",
            body = listOf(
                "Never ignore or delay seeking professional medical advice because of something you read here. If your symptoms are severe, worsening, or worrying, contact a healthcare professional promptly.",
                "Do not start, stop, or change any medicine based on this app. Medicine names shown are common examples; only a qualified professional can prescribe safely for you."
            )
        ),
        InfoSection(
            title = "In an emergency",
            body = listOf(
                "If you think you are having a medical emergency — such as a heart attack, stroke, severe difficulty breathing, or heavy bleeding — call your local emergency number immediately (for example, 991 or 911 in Ethiopia) or go to the nearest emergency department."
            )
        ),
        InfoSection(
            title = "Accuracy and completeness",
            body = listOf(
                "Health knowledge changes over time. While we aim to keep the information accurate and up to date, we cannot guarantee that every detail is complete, current, or suitable for your individual situation.",
                "Information is general and may not account for your age, medical history, pregnancy, allergies, or other medicines you take."
            )
        ),
        InfoSection(
            title = "AI Health Assistant",
            body = listOf(
                "The AI assistant provides general information and can make mistakes. Treat its responses as a starting point for learning, not as professional advice, and verify anything important with a qualified professional."
            )
        )
    )
    InfoScreenScaffold(
        title = "Health Disclaimer",
        sections = sections,
        footer = "By using this app you acknowledge that you are responsible for your own health decisions and that you will consult a qualified healthcare professional when needed.",
        onBack = onBack
    )
}

// ---------------------------------------------------------------------------
// Medical Sources
// ---------------------------------------------------------------------------
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MedicalSourcesScreen(onBack: () -> Unit) {
    val context = LocalContext.current

    val sections = listOf(
        InfoSection(
            title = "Where this information comes from",
            body = listOf(
                "The disease definitions, symptoms, causes, prevention tips, and food guidance in this app are compiled and adapted from widely trusted public health and medical references, then summarized in plain language and translated into English, Afaan Oromoo, and Amharic.",
                "The sources below are general public health references. Always confirm important decisions with a qualified healthcare professional."
            )
        ),
        InfoSection(
            title = "General references",
            body = listOf(
                "• World Health Organization (WHO) — global health topic and fact sheets.",
                "• MedlinePlus (U.S. National Library of Medicine) — patient-friendly health information.",
                "• Centers for Disease Control and Prevention (CDC) — prevention and disease control guidance.",
                "• Mayo Clinic — conditions, symptoms, and treatments.",
                "• NHS Health A-Z (UK) — conditions, treatments, and medicines.",
                "• National and regional health ministries, including the Ethiopian Federal Ministry of Health, for local guidance and emergency numbers."
            )
        ),
        InfoSection(
            title = "Important note on adaptation",
            body = listOf(
                "Content has been summarized and adapted for educational use. It may not reproduce a source word for word, and it is not endorsed by the organizations listed above.",
                "Medical guidance can differ between countries. Follow the advice of your local health authority and healthcare professional."
            )
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Medical Sources", fontWeight = FontWeight.Bold) },
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
            items(sections.size) { index ->
                val section = sections[index]
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            section.title,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        section.body.forEachIndexed { i, line ->
                            if (i > 0) Spacer(modifier = Modifier.height(6.dp))
                            Text(line, fontSize = 14.sp, color = MaterialTheme.colorScheme.onSurface)
                        }
                    }
                }
            }

            // Tappable list of the actual sources
            items(OnlineLinks.trustedSources.size) { index ->
                val source = OnlineLinks.trustedSources[index]
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { OnlineLinks.open(context, source.homepage) },
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                source.name,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 15.sp,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                source.description,
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        Icon(
                            imageVector = Icons.Default.OpenInNew,
                            contentDescription = "Open in browser",
                            tint = TealPrimary,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }

            item {
                Text(
                    "These links open in your device's browser.",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

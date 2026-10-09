package com.example.diseaseinformationhealthassistantmobileapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.diseaseinformationhealthassistantmobileapplication.R

private data class AboutSection(val title: String, val lines: List<String>)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen() {
    val sections = listOf(
        AboutSection(
            title = "About this App",
            lines = listOf(
                "Disease Information Health Assistant is a free educational health app that gives you reliable, easy-to-understand information about common diseases and health conditions.",
                "It brings together disease definitions, symptoms, causes, prevention tips, safety practices, and healthy food guidance in one place, so you can learn about your health anytime and anywhere — even without an internet connection."
            )
        ),
        AboutSection(
            title = "Why this App is Important",
            lines = listOf(
                "• Early awareness: Learn the warning signs of diseases so you can seek help early.",
                "• Prevention: Practical prevention and safety tips help you and your family stay healthy.",
                "• Health literacy: Clear explanations help you understand medical terms and make better decisions.",
                "• Emergency help: Quick access to emergency contacts and a guided emergency assessment when seconds matter.",
                "• Accessible for everyone: Voice search, read-aloud, and three languages make information usable by people with different abilities."
            )
        ),
        AboutSection(
            title = "Key Features",
            lines = listOf(
                "• Disease library with categories such as Infectious, Chronic, Heart, Eye, Ear, Respiratory, Neurology, and more.",
                "• Search by typing OR by voice using the microphone icon.",
                "• Detailed disease pages: Definition, Types, Symptoms, Causes, Prevention, Safety Practices, and Food Guidance.",
                "• Read-aloud (text to speech) and share disease information with others.",
                "• AI Health Assistant for quick health questions.",
                "• Emergency screen with contacts and a voice-enabled emergency assessment.",
                "• Favorites to save important diseases and History to revisit what you read.",
                "• Available in English, Afaan Oromoo, and Amharic (tap the language button on the Home screen)."
            )
        ),
        AboutSection(
            title = "How to Use this App",
            lines = listOf(
                "1. Open the app and wait for the splash animation to finish.",
                "2. On the Home screen, browse the disease list or type in the search bar.",
                "3. Can't type? Tap the microphone icon and say the disease name to search by voice.",
                "4. Tap any disease card to open its details, then read the sections or tap the speaker to listen.",
                "5. Tap the heart icon to add a disease to Favorites; everything you read is saved in History.",
                "6. Tap the red warning button (bottom right) for Emergency contacts and the emergency assessment.",
                "7. Tap the info button (bottom right) to open the AI Health Assistant.",
                "8. Use the language button in the top bar to switch between English, Afaan Oromoo, and Amharic.",
                "9. Open the About and Settings tabs from the bottom navigation bar at any time."
            )
        ),
        AboutSection(
            title = "Medical Disclaimer",
            lines = listOf(
                "Disclaimer: This app provides educational information and does not replace professional medical advice.",
                "Always consult a qualified healthcare professional for any health concern. In an emergency, call your local emergency number immediately."
            )
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("About") })
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.mipmap.ic_launcher),
                        contentDescription = "App Icon",
                        modifier = Modifier
                            .size(96.dp)
                            .clip(RoundedCornerShape(20.dp))
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        "Disease Information Health Assistant",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        "Version 1.0",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            items(sections.size) { index ->
                AboutCard(section = sections[index])
            }

            item {
                Text(
                    "Developed to support health education and awareness.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
private fun AboutCard(section: AboutSection) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                section.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(8.dp))
            section.lines.forEachIndexed { i, line ->
                if (i > 0) Spacer(modifier = Modifier.height(6.dp))
                Text(
                    line,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

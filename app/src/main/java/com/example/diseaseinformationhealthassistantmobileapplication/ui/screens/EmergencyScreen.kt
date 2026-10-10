package com.example.diseaseinformationhealthassistantmobileapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Assessment
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmergencyScreen(
    language: String,
    onBack: () -> Unit,
    onStartAssessment: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        when (language) {
                            "en" -> "Emergency Contacts"
                            "om" -> "Bilbila Ariifachisaa"
                            else -> "የአስቸኳይ እርዳታ ስልክ ቁጥሮች"
                        }
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            StartAssessmentCard(language = language, onStartAssessment = onStartAssessment)

            EmergencyItem(
                when (language) {
                    "en" -> "Ambulance"
                    "om" -> "Waamicha Ariifachisaa"
                    else -> "አም뷸ንስ"
                }, "991"
            )
            EmergencyItem(
                when (language) {
                    "en" -> "Police"
                    "om" -> "Poolisii"
                    else -> "ፖሊስ"
                }, "992"
            )
            EmergencyItem(
                when (language) {
                    "en" -> "Red Cross"
                    "om" -> "Fannoo Diimaa"
                    else -> "ቀይ መስቀል"
                }, "907"
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            Text(
                text = when (language) {
                    "en" -> "In case of a life-threatening emergency, please call your local emergency services immediately."
                    "om" -> "Yoo balaan jireenya irratti hammaatu mudate, hatattamaan bilbila ariifachisaa naannoo keessanii bilbilaa."
                    else -> "በሕይወት አደጋ ውስጥ ከገጠማችሁ፣ በአስቸኳይ የአካባቢዎን የአስቸኳይ እርዳታ አገልጋዮች ወዲያውኑ ደውሉ።"
                },
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}

@Composable
fun StartAssessmentCard(language: String, onStartAssessment: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Icon(
                Icons.Default.Assessment,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = when (language) {
                    "en" -> "AI Health Assessment"
                    "om" -> "Madaallii Fayyaa AI"
                    else -> "የአይ አይ የጤና ግምገማ"
                },
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Text(
                text = when (language) {
                    "en" -> "Answer a few questions about your symptoms so the AI can assess your condition and tell you what to do."
                    "om" -> "Gaaffii xiqqoo dhukkubbii keessanii walqunnamsuun batsaluu, AI-n haala keessani madaalluun waan gochuu barreessisiif."
                    else -> "ስምምነቶችዎን ስለሚያጋጠሙ ጥያቄዎችን በመልስ አይ አይ ሁኔታዎን እንዲገምግም እና ምን ማድረግ እንዳለብዎት እንዲያስተያየት።"
                },
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = onStartAssessment, modifier = Modifier.fillMaxWidth()) {
                Text(
                    when (language) {
                        "en" -> "Start AI assessment"
                        "om" -> "Madaallii AI jalqabi"
                        else -> "የአይ አይ ግምገማ ይጀምሩ"
                    }
                )
            }
        }
    }
}

@Composable
fun EmergencyItem(label: String, number: String) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.errorContainer)
    ) {
        Row(
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = label, style = MaterialTheme.typography.titleMedium)
                Text(text = number, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
            }
            Icon(Icons.Default.Phone, contentDescription = null, modifier = Modifier.size(32.dp))
        }
    }
}

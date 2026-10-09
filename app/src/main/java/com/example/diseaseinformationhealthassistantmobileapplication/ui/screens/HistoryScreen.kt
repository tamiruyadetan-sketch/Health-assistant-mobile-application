package com.example.diseaseinformationhealthassistantmobileapplication.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.diseaseinformationhealthassistantmobileapplication.data.DiseaseRepository
import com.example.diseaseinformationhealthassistantmobileapplication.data.HistoryRepository
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen(
    language: String,
    onDiseaseClick: (String) -> Unit
) {
    val historyItems = HistoryRepository.getHistory()

    Scaffold(
        topBar = {
            TopAppBar(title = { 
                Text(when (language) {
                    "en" -> "History"
                    "om" -> "Seenaa"
                    else -> "ታሪክ"
                }) 
            })
        }
    ) { padding ->
        if (historyItems.isEmpty()) {
            Column(
                modifier = Modifier.padding(padding).fillMaxSize().padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = when(language) {
                        "en" -> "Your history will appear here."
                        "om" -> "Seenaan kee asitti ni mul'ata."
                        else -> "ታሪክዎ እዚህ ይታያል።"
                    },
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier.padding(padding).fillMaxSize(),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(historyItems) { item ->
                    // Attempt to resolve disease name based on language
                    val localizedId = "${item.id}_${language}"
                    val disease = DiseaseRepository.getDiseaseById(localizedId, language) 
                        ?: DiseaseRepository.getDiseaseById("${item.id}_en", "en")
                        
                    val name = disease?.name ?: item.id.capitalize(Locale.ROOT)
                    val dateStr = SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.getDefault()).format(Date(item.timestamp))

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .clickable { onDiseaseClick(localizedId) },
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(text = name, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(text = dateStr, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                    }
                }
            }
        }
    }
}

package com.example.diseaseinformationhealthassistantmobileapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AiAssistantScreen(language: String, onBack: () -> Unit) {
    var chatInput by remember { mutableStateOf("") }
    val greeting = when (language) {
        "en" -> "Hello! I'm your Health Assistant. How can I help you today?"
        "om" -> "Akkam! Ani Gargaaraa Fayyaa kee dha. Asumaatti maal gargaaruu danda'a?"
        else -> "ሰላም! እኔ የጤና ረዳትዎ ነኝ። ዛሬ እንዴት ልርዳዎት?"
    }
    val chatMessages = remember {
        mutableStateListOf<Pair<String, Boolean>>().apply { add(greeting to false) }
    } // Message, isUser

    val suggestions = when (language) {
        "en" -> listOf("What are the symptoms of malaria?", "Healthy foods", "What is diabetes?", "Prevention tips")
        "om" -> listOf("Mallattooleen busaa mataa minni?", "Nyaata haatiin", "Diabetii maani?", "Ittisa")
        else -> listOf("የመለናይድ ምልክቶች ምንድን ናቸው?", "ጤና የሚጠብቀው ምግብ", "ሳናይብሬስ ምንድን ነው?", "የመከላከል ተግባራት")
    }

    fun sendChatMessage(text: String) {
        if (text.isBlank()) return
        chatMessages.add(text to true)
        // Mock response
        val response = when (language) {
            "en" -> "I am a demo AI. Please consult a doctor for real medical advice."
            "om" -> "Ani AI yaaliiti. Gorsa fayyaa dhugaatiif doktoora mariisisi."
            else -> "ኔ የሙከራ አይ አይ ነኝ። ለተደንገሞ የሕክምና ምክር እባክህ ሐኪም ጠይቅ።"
        }
        chatMessages.add(response to false)
        chatInput = ""
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        when (language) {
                            "en" -> "AI Health Assistant"
                            "om" -> "Gargaara Fayyaa AI"
                            else -> "የአይኤ የጤና ረዳት"
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
            Text(
                text = when (language) {
                    "en" -> "Ask general health questions. Note: AI can make mistakes."
                    "om" -> "Gaaffii fayyaa walii-galaa gaafadhu. Hubachiisa: AI-n dogoggoruu danda'a."
                    else -> "አጠቃላይ የጤና ጥያቄዎችን ይጠይቁ። ማስታወሻ፡ አይ አይ ስህተት መጠየቅ ይችላል።"
                },
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.secondary
            )
            
            LazyColumn(modifier = Modifier.weight(1f).padding(vertical = 8.dp)) {
                items(chatMessages) { (message, isUser) ->
                    ChatBubble(message, isUser)
                }
            }
            
            // Suggestion chips matching UI.png
            Column(
                modifier = Modifier.padding(bottom = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                suggestions.chunked(2).forEach { rowSuggestions ->
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        rowSuggestions.forEach { suggestion ->
                            AssistChip(
                                onClick = { sendChatMessage(suggestion) },
                                label = { Text(text = suggestion, fontSize = 12.sp) }
                            )
                        }
                    }
                }
            }

            // Message input with pill shape and circular send button matching UI.png
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = chatInput,
                    onValueChange = { chatInput = it },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(24.dp),
                    singleLine = true,
                    placeholder = {
                        Text(
                            when (language) {
                                "en" -> "Type your message..."
                                "om" -> "Ergaa kee barreessi..."
                                else -> "መልእክትዎን ይጻፉ..."
                            }
                        )
                    },
                    leadingIcon = {
                        Icon(Icons.Default.AttachFile, contentDescription = "Attach")
                    }
                )
                Button(
                    onClick = { sendChatMessage(chatInput) },
                    shape = CircleShape,
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(Icons.AutoMirrored.Filled.Send, contentDescription = "Send")
                }
            }
        }
    }
}

@Composable
fun ChatBubble(message: String, isUser: Boolean) {
    val alignment = if (isUser) androidx.compose.ui.Alignment.End else androidx.compose.ui.Alignment.Start
    val color = if (isUser) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.secondaryContainer
    
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = alignment) {
        Surface(
            shape = MaterialTheme.shapes.medium,
            color = color,
            modifier = Modifier.padding(vertical = 4.dp).widthIn(max = 280.dp)
        ) {
            Text(text = message, modifier = Modifier.padding(8.dp))
        }
    }
}

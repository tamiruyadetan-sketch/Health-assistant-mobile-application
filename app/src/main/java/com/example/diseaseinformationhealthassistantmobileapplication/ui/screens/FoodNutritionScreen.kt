package com.example.diseaseinformationhealthassistantmobileapplication.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diseaseinformationhealthassistantmobileapplication.ui.theme.SuccessColor
import com.example.diseaseinformationhealthassistantmobileapplication.ui.theme.ErrorColor
import com.example.diseaseinformationhealthassistantmobileapplication.ui.theme.TealPrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodNutritionScreen(
    diseaseName: String,
    language: String,
    onBack: () -> Unit,
    onLanguageClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(diseaseName, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    OutlinedButton(
                        onClick = onLanguageClick,
                        modifier = Modifier.padding(end = 8.dp),
                        shape = RoundedCornerShape(20.dp),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = when (language) {
                                "en" -> "English ▾"
                                "om" -> "Oromoo ▾"
                                else -> "አማርኛ ▾"
                            },
                            fontSize = 13.sp
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Food & Nutrition",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onBackground
            )

            // Recommended Foods Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = SuccessColor.copy(alpha = 0.08f))
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = null,
                            tint = SuccessColor,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Recommended Foods",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = SuccessColor
                        )
                    }

                    val recommended = listOf(
                        "Vegetables (leafy greens, broccoli)",
                        "Whole grains (brown rice, oats)",
                        "Lean protein (chicken, fish, beans)",
                        "Healthy fats (avocado, nuts)",
                        "Fruits (berries, apple, orange)"
                    )
                    recommended.forEach { food ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "✓", color = SuccessColor, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(text = food, fontSize = 14.sp, color = MaterialTheme.colorScheme.onBackground)
                        }
                    }
                }
            }

            // Foods to Limit / Avoid Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = ErrorColor.copy(alpha = 0.08f))
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Cancel,
                            contentDescription = null,
                            tint = ErrorColor,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Foods to Limit / Avoid",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = ErrorColor
                        )
                    }

                    val avoid = listOf(
                        "Sugary foods and drinks",
                        "White bread and refined carbs",
                        "Processed and fast foods",
                        "High-fat meats"
                    )
                    avoid.forEach { food ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "✕", color = ErrorColor, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(text = food, fontSize = 14.sp, color = MaterialTheme.colorScheme.onBackground)
                        }
                    }
                }
            }

            // Tip Box
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFEF08A).copy(alpha = 0.4f))
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Lightbulb,
                        contentDescription = null,
                        tint = Color(0xFFCA8A04),
                        modifier = Modifier.size(28.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "Tip: A balanced diet and regular exercise help control blood sugar levels.",
                        fontSize = 13.sp,
                        color = Color(0xFF854D0E),
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}

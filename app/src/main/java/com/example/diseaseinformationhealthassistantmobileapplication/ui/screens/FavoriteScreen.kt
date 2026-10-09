package com.example.diseaseinformationhealthassistantmobileapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diseaseinformationhealthassistantmobileapplication.data.DiseaseImageMapper
import com.example.diseaseinformationhealthassistantmobileapplication.data.DiseaseRepository
import com.example.diseaseinformationhealthassistantmobileapplication.data.FavoriteRepository
import com.example.diseaseinformationhealthassistantmobileapplication.ui.theme.ErrorColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteScreen(
    language: String,
    onDiseaseClick: (String) -> Unit
) {
    // Get favorites from memory (snapshot state, so removals refresh the list)
    val allDiseases = DiseaseRepository.getDiseases(language)
    val favoriteDiseases = allDiseases.filter { disease ->
        FavoriteRepository.isFavorite(disease.id)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = when (language) {
                            "en" -> "My Favorites"
                            "om" -> "Jaallatamaan Koo"
                            else -> "የተወዳጎቼ"
                        },
                        fontWeight = FontWeight.Bold
                    )
                }
            )
        }
    ) { padding ->
        if (favoriteDiseases.isEmpty()) {
            Box(
                modifier = Modifier.padding(padding).fillMaxSize().padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = when (language) {
                        "en" -> "No favorite diseases yet."
                        "om" -> "Dhibee jaallatamaa hin jiru."
                        else -> "እስካሁን የተወዳጅ በሽታዎች የሉም።"
                    },
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier.padding(padding).fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(favoriteDiseases) { disease ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(onClick = { onDiseaseClick(disease.id) }),
                        shape = RoundedCornerShape(14.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = DiseaseImageMapper.getDiseaseImageResId(disease.id)),
                                contentDescription = disease.name,
                                modifier = Modifier
                                    .size(48.dp)
                                    .clip(RoundedCornerShape(12.dp)),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(modifier = Modifier.width(14.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = disease.name,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = disease.category,
                                    fontSize = 13.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            IconButton(onClick = { FavoriteRepository.removeFavorite(disease.id) }) {
                                Icon(
                                    imageVector = Icons.Default.Favorite,
                                    contentDescription = "Remove from favorites",
                                    tint = ErrorColor
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

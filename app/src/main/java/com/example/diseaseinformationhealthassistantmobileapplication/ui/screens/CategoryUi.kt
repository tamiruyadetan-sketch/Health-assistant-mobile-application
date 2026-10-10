package com.example.diseaseinformationhealthassistantmobileapplication.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Accessibility
import androidx.compose.material.icons.filled.Air
import androidx.compose.material.icons.filled.Bloodtype
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LunchDining
import androidx.compose.material.icons.filled.PestControl
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Shared category presentation matching the UI.png mockup:
 * short label for the home grid, full title + description for list screens,
 * and a distinct colored icon per category.
 */
data class CategoryUi(
    val label: String,
    val title: String,
    val description: String,
    val icon: ImageVector,
    val containerColor: Color,
    val contentColor: Color
)

val categoryUiList: List<CategoryUi> = listOf(
    CategoryUi(
        label = "Skin",
        title = "Skin Diseases",
        description = "Acne, eczema, fungal infections...",
        icon = Icons.Default.Face,
        containerColor = Color(0xFFFEEAE2),
        contentColor = Color(0xFFE76F51)
    ),
    CategoryUi(
        label = "Blood",
        title = "Blood Diseases",
        description = "Anemia, leukemia, clotting disorders...",
        icon = Icons.Default.Bloodtype,
        containerColor = Color(0xFFFEE2E2),
        contentColor = Color(0xFFDC2626)
    ),
    CategoryUi(
        label = "Heart",
        title = "Heart Diseases",
        description = "Hypertension, heart attack...",
        icon = Icons.Default.Favorite,
        containerColor = Color(0xFFFCE7F3),
        contentColor = Color(0xFFDB2777)
    ),
    CategoryUi(
        label = "Respiratory",
        title = "Respiratory Diseases",
        description = "Asthma, pneumonia, COPD...",
        icon = Icons.Default.Air,
        containerColor = Color(0xFFDBEAFE),
        contentColor = Color(0xFF2563EB)
    ),
    CategoryUi(
        label = "Digestive",
        title = "Digestive System Diseases",
        description = "Gastritis, ulcers, IBS...",
        icon = Icons.Default.LunchDining,
        containerColor = Color(0xFFFFEDD5),
        contentColor = Color(0xFFEA580C)
    ),
    CategoryUi(
        label = "Musculoskeletal",
        title = "Musculoskeletal Diseases",
        description = "Arthritis, back pain, osteoporosis...",
        icon = Icons.Default.Accessibility,
        containerColor = Color(0xFFCCFBF1),
        contentColor = Color(0xFF0D9488)
    ),
    CategoryUi(
        label = "Infectious",
        title = "Infectious Diseases",
        description = "Malaria, tuberculosis, dengue...",
        icon = Icons.Default.PestControl,
        containerColor = Color(0xFFDCFCE7),
        contentColor = Color(0xFF16A34A)
    ),
    CategoryUi(
        label = "Nervous",
        title = "Nervous System Diseases",
        description = "Migraine, epilepsy, Alzheimer's...",
        icon = Icons.Default.Psychology,
        containerColor = Color(0xFFEDE9FE),
        contentColor = Color(0xFF7C3AED)
    )
)

package com.example.diseaseinformationhealthassistantmobileapplication.data

import androidx.compose.runtime.mutableStateListOf

object FavoriteRepository {
    // A simple in-memory list of favorite disease IDs
    private val favoriteIds = mutableStateListOf<String>()

    fun getFavorites(): List<String> = favoriteIds

    fun addFavorite(id: String) {
        if (!favoriteIds.contains(id)) {
            // Because diseases might have different IDs per language (e.g. malaria_en vs malaria_om),
            // it's best to strip the language suffix to favorite the generic disease, or just save the raw ID.
            // But since the list changes, let's just save a generic prefix like "malaria"
            val genericId = id.substringBefore("_")
            if (!favoriteIds.contains(genericId)) {
                favoriteIds.add(genericId)
            }
        }
    }

    fun removeFavorite(id: String) {
        val genericId = id.substringBefore("_")
        favoriteIds.remove(genericId)
    }

    fun isFavorite(id: String): Boolean {
        val genericId = id.substringBefore("_")
        return favoriteIds.contains(genericId)
    }
}

package com.example.diseaseinformationhealthassistantmobileapplication.data

import androidx.compose.runtime.mutableStateListOf

data class HistoryItem(val id: String, val timestamp: Long)

object HistoryRepository {
    // A simple in-memory list of history items
    private val historyItems = mutableStateListOf<HistoryItem>()

    fun getHistory(): List<HistoryItem> = historyItems.sortedByDescending { it.timestamp }

    fun addHistory(id: String) {
        val genericId = id.substringBefore("_")
        // Remove old entry if it exists to bring it to the top
        historyItems.removeAll { it.id == genericId }
        historyItems.add(HistoryItem(genericId, System.currentTimeMillis()))
    }
}

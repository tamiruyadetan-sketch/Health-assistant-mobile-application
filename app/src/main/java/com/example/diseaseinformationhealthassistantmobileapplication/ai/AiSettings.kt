package com.example.diseaseinformationhealthassistantmobileapplication.ai

import android.content.Context
import android.content.SharedPreferences

/**
 * Stores the optional Gemini API key.
 *
 * When no key is configured the app uses the built-in offline AI engine,
 * so the assessment always works without internet access.
 */
object AiSettings {

    private const val PREFS = "ai_assistant_settings"
    private const val KEY_GEMINI_API = "gemini_api_key"

    fun getApiKey(context: Context): String =
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .getString(KEY_GEMINI_API, "") ?: ""

    fun setApiKey(context: Context, key: String) {
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .edit()
            .putString(KEY_GEMINI_API, key.trim())
            .apply()
    }

    fun clearApiKey(context: Context) = setApiKey(context, "")
}

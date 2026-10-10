package com.example.diseaseinformationhealthassistantmobileapplication.data

import android.content.Context

/**
 * Persists the user's appearance preferences:
 *  - darkMode: whether the app uses a dark color scheme
 *  - backgroundChoice: which solid background to draw (BLACK or WHITE)
 *
 * Stored in SharedPreferences so the choice survives app restarts.
 */
enum class BackgroundChoice { BLACK, WHITE }

object AppSettingsRepository {
    private const val PREFS_NAME = "app_settings"
    private const val KEY_DARK_MODE = "dark_mode"
    private const val KEY_BACKGROUND = "background_choice"

    private fun prefs(context: Context) =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun isDarkMode(context: Context): Boolean =
        prefs(context).getBoolean(KEY_DARK_MODE, false)

    fun setDarkMode(context: Context, enabled: Boolean) {
        prefs(context).edit().putBoolean(KEY_DARK_MODE, enabled).apply()
    }

    fun getBackgroundChoice(context: Context): BackgroundChoice {
        val raw = prefs(context).getString(KEY_BACKGROUND, BackgroundChoice.WHITE.name)
        return runCatching { BackgroundChoice.valueOf(raw!!) }.getOrDefault(BackgroundChoice.WHITE)
    }

    fun setBackgroundChoice(context: Context, choice: BackgroundChoice) {
        prefs(context).edit().putString(KEY_BACKGROUND, choice.name).apply()
    }
}

package com.example.diseaseinformationhealthassistantmobileapplication.voice

import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.speech.RecognizerIntent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat

/**
 * Voice assistant helper: converts spoken words into text.
 *
 * Returns a lambda that starts listening. It first ensures the RECORD_AUDIO
 * permission is granted, then launches the system speech recognizer.
 *
 * @param language app language ("en", "om", "am") used for the speech locale
 * @param onResult called with the recognized text (empty when nothing matched)
 * @param onError called with a user-facing (already localized) error message
 */
@Composable
fun rememberSpeechRecognizer(
    language: String,
    onResult: (String) -> Unit,
    onError: (String) -> Unit
): () -> Unit {
    val context = LocalContext.current

    // Handles the speech recognizer activity result.
    val resultLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val matches = result.data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
        val text = matches?.firstOrNull()
        if (!text.isNullOrBlank()) {
            onResult(text)
        } else {
            onError(errorMessage(language, "no_speech"))
        }
    }

    // Launches the system speech recognition UI.
    val launchSpeech: () -> Unit = remember(language) {
        {
            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                putExtra(
                    RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                    RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
                )
                putExtra(RecognizerIntent.EXTRA_LANGUAGE, speechLocale(language))
                putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1)
                putExtra(RecognizerIntent.EXTRA_PROMPT, errorMessage(language, "prompt"))
            }
            try {
                resultLauncher.launch(intent)
            } catch (e: ActivityNotFoundException) {
                onError(errorMessage(language, "unavailable"))
            }
        }
    }

    // Handles the microphone permission request.
    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        if (granted) {
            launchSpeech()
        } else {
            onError(errorMessage(language, "permission"))
        }
    }

    return {
        val hasPermission = ContextCompat.checkSelfPermission(
            context, Manifest.permission.RECORD_AUDIO
        ) == PackageManager.PERMISSION_GRANTED
        if (hasPermission) {
            launchSpeech()
        } else {
            permissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
        }
    }
}

private fun speechLocale(language: String): String = when (language) {
    "om" -> "om-ET"
    "am" -> "am-ET"
    else -> "en-US"
}

private fun errorMessage(language: String, code: String): String = when (language) {
    "om" -> when (code) {
        "no_speech" -> "Aldina hin dubbisne. Irra deebi'i yaali."
        "permission" -> "Gargaarsa afaanii ifaaaf hayyama mikroofoonii barbaachisaa dha."
        "prompt" -> "Afaanii keessan hiraa dhageessi..."
        else -> "Tajaajiluun dubbisuu afaanii moobaasii kana keessatti hin jiru."
    }
    "am" -> when (code) {
        "no_speech" -> "ድምጽ አልተገኘም። እባክዎ እንደገና ይሞክሩ።"
        "permission" -> "በኩባንያው መስማት ለማድረግ የማይክሮፎን ፈቃድ ያስፈልጋል።"
        "prompt" -> "ቃልዎን ይናገሩ..."
        else -> "በዚህ መሣሪያ የንግግር መለያየት አይገኝም።"
    }
    else -> when (code) {
        "no_speech" -> "No speech detected. Please try again."
        "permission" -> "Microphone permission is required for voice input."
        "prompt" -> "Speak your search..."
        else -> "Speech recognition is not available on this device."
    }
}

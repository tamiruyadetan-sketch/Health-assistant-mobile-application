package com.example.diseaseinformationhealthassistantmobileapplication.data

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

/**
 * The signed-in user's profile. A guest (no registration) is represented by a null profile.
 */
data class UserProfile(
    val displayName: String,
    val email: String,
    val photoUri: String? = null
)

/**
 * Persists a simple local profile so a guest user can register and pick a profile image.
 * The profile is exposed as Compose state so the UI (e.g. the Settings profile card)
 * updates as soon as the user registers or changes their photo.
 */
object UserRepository {
    private const val PREFS_NAME = "user_profile"
    private const val KEY_NAME = "display_name"
    private const val KEY_EMAIL = "email"
    private const val KEY_PHOTO = "photo_uri"

    /** Null while the user is a guest. */
    var profile by mutableStateOf<UserProfile?>(null)
        private set

    fun isRegistered(): Boolean = profile != null

    /** Load the persisted profile. Call once when the app starts. */
    fun init(context: Context) {
        profile = read(context)
    }

    /** Register (or update) the user's profile. */
    fun register(context: Context, displayName: String, email: String, photoUri: String?) {
        val updated = UserProfile(displayName.trim(), email.trim(), photoUri)
        write(context, updated)
        profile = updated
    }

    /** Change only the profile photo of an already-registered user. */
    fun updatePhoto(context: Context, photoUri: String?) {
        val existing = profile ?: return
        val updated = existing.copy(photoUri = photoUri)
        write(context, updated)
        profile = updated
    }

    /** Remove the profile and return to guest mode. */
    fun signOut(context: Context) {
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit().clear().apply()
        profile = null
    }

    private fun read(context: Context): UserProfile? {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val name = prefs.getString(KEY_NAME, null) ?: return null
        val email = prefs.getString(KEY_EMAIL, null) ?: return null
        return UserProfile(name, email, prefs.getString(KEY_PHOTO, null))
    }

    private fun write(context: Context, userProfile: UserProfile) {
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()
            .putString(KEY_NAME, userProfile.displayName)
            .putString(KEY_EMAIL, userProfile.email)
            .putString(KEY_PHOTO, userProfile.photoUri)
            .apply()
    }
}

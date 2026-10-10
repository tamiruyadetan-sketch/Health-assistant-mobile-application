package com.example.diseaseinformationhealthassistantmobileapplication.ui.screens

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast

/** A trusted online medical reference. */
data class OnlineSource(
    val name: String,
    val homepage: String,
    val description: String
)

/**
 * Central place for the external medical references used by the "Learn More" action
 * and the "Medical Sources" screen. Keeping the URLs here means they can be fixed
 * or extended in one place.
 */
object OnlineLinks {

    val trustedSources = listOf(
        OnlineSource(
            name = "World Health Organization (WHO)",
            homepage = "https://www.who.int/health-topics",
            description = "Global health information and fact sheets from the United Nations health agency."
        ),
        OnlineSource(
            name = "MedlinePlus (U.S. National Library of Medicine)",
            homepage = "https://medlineplus.gov/",
            description = "Plain-language health information for patients and families."
        ),
        OnlineSource(
            name = "Centers for Disease Control and Prevention (CDC)",
            homepage = "https://www.cdc.gov/",
            description = "Disease control, prevention, and outbreak information."
        ),
        OnlineSource(
            name = "Mayo Clinic",
            homepage = "https://www.mayoclinic.org/diseases-conditions",
            description = "Symptoms, causes, diagnosis, and treatment for many conditions."
        ),
        OnlineSource(
            name = "NHS Health A-Z (UK)",
            homepage = "https://www.nhs.uk/conditions/",
            description = "Conditions, treatments, and medicines explained by the UK health service."
        )
    )

    /** A MedlinePlus search page for a specific disease. */
    fun medlinePlusSearch(diseaseName: String): String =
        "https://medlineplus.gov/search/?query=" + Uri.encode(diseaseName)

    /** A WHO search page for a specific disease. */
    fun whoSearch(diseaseName: String): String =
        "https://www.who.int/home/search?searchQuery=" + Uri.encode(diseaseName)

    /** Open a URL in the user's browser, showing a message when no browser is available. */
    fun open(context: Context, url: String): Boolean {
        return try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(intent)
            true
        } catch (_: Exception) {
            Toast.makeText(
                context,
                "No app found to open this link. Please install a browser and try again.",
                Toast.LENGTH_LONG
            ).show()
            false
        }
    }
}

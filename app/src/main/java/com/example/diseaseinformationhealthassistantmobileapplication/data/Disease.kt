package com.example.diseaseinformationhealthassistantmobileapplication.data

data class DiseaseType(
    val name: String,
    val description: String
)

data class Disease(
    val id: String,
    val name: String,
    val category: String,
    val definition: String,
    val symptoms: List<String>,
    val causes: List<String>,
    val prevention: List<String>,
    val safetyPractices: List<String>,
    val foodGuidance: String? = null,
    val medicines: List<String>? = null,
    val medicineGuide: String? = null,
    val language: String, // "en", "om" or "am"
    val types: List<DiseaseType>? = null
) {companion object {
    fun createWithTypes(
        id: String,
        name: String,
        category: String,
        definition: String,
        symptoms: List<String>,
        causes: List<String>,
        prevention: List<String>,
        safetyPractices: List<String>,
        foodGuidance: String? = null,
        medicines: List<String>? = null,
        medicineGuide: String? = null,
        language: String,
        types: List<DiseaseType>
    ): Disease = Disease(
        id = id,
        name = name,
        category = category,
        definition = definition,
        symptoms = symptoms,
        causes = causes,
        prevention = prevention,
        safetyPractices = safetyPractices,
        foodGuidance = foodGuidance,
        medicines = medicines,
        medicineGuide = medicineGuide,
        language = language,
        types = types
    )
}}

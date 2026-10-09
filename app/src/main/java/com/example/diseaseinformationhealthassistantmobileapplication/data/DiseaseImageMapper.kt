package com.example.diseaseinformationhealthassistantmobileapplication.data

import com.example.diseaseinformationhealthassistantmobileapplication.R

object DiseaseImageMapper {
    /**
     * Gets the main photo/illustration image resource for a given disease ID.
     */
    fun getDiseaseImageResId(diseaseId: String): Int {
        val baseId = diseaseId.substringBefore("_").lowercase()
        return when (baseId) {
            "ear" -> R.drawable.ic_disease_ear
            "eye" -> R.drawable.ic_disease_eye
            "heart" -> R.drawable.ic_disease_heart
            "heart_disease" -> R.drawable.ic_disease_heart
            "cancer" -> R.drawable.ic_disease_cancer
            "brain" -> R.drawable.ic_disease_brain
            "lung" -> R.drawable.ic_disease_lung
            "tb" -> R.drawable.ic_disease_tb
            "pneumonia" -> R.drawable.ic_disease_pneumonia
            "hypertension" -> R.drawable.ic_disease_hypertension
            "typhoid" -> R.drawable.ic_disease_typhoid
            "hepatitis" -> R.drawable.ic_disease_hepatitis
            "asthma" -> R.drawable.ic_disease_asthma
            "stroke" -> R.drawable.ic_disease_stroke
            "diabetes" -> R.drawable.ic_disease_diabetes
            "malaria" -> R.drawable.ic_disease_malaria
            "hiv" -> R.drawable.ic_disease_hiv
            "skin" -> R.drawable.ic_disease_skin
            "skin_disease" -> R.drawable.ic_disease_skin
            "blood" -> R.drawable.ic_disease_blood
            "blood_disease" -> R.drawable.ic_disease_blood
            "gastritis" -> R.drawable.ic_disease_digestive
            "peptic" -> R.drawable.ic_disease_peptic_ulcer
            "gerd" -> R.drawable.ic_disease_gerd
            "ibs" -> R.drawable.ic_disease_ibs
            "arthritis" -> R.drawable.ic_disease_arthritis
            "back" -> R.drawable.ic_disease_back_pain
            "osteoporosis" -> R.drawable.ic_disease_osteoporosis
            else -> R.drawable.ic_disease_default
        }
    }

    /**
     * Gets the food guidance guide image resource for a given disease ID.
     */
    fun getFoodImageResId(diseaseId: String): Int {
        val baseId = diseaseId.substringBefore("_").lowercase()
        return when (baseId) {
            "ear" -> R.drawable.ic_food_ear
            "eye" -> R.drawable.ic_food_eye
            "heart" -> R.drawable.ic_food_heart
            "heart_disease" -> R.drawable.ic_food_heart
            "cancer" -> R.drawable.ic_food_cancer
            "brain" -> R.drawable.ic_food_brain
            "lung" -> R.drawable.ic_food_lung
            "tb" -> R.drawable.ic_food_tb
            "pneumonia" -> R.drawable.ic_food_pneumonia
            "hypertension" -> R.drawable.ic_food_hypertension
            "typhoid" -> R.drawable.ic_food_typhoid
            "hepatitis" -> R.drawable.ic_food_hepatitis
            "asthma" -> R.drawable.ic_food_asthma
            "stroke" -> R.drawable.ic_food_stroke
            "diabetes" -> R.drawable.ic_food_diabetes
            "malaria" -> R.drawable.ic_food_malaria
            "hiv" -> R.drawable.ic_food_hiv
            "skin" -> R.drawable.ic_food_default
            "skin_disease" -> R.drawable.ic_food_default
            "blood" -> R.drawable.ic_food_default
            "blood_disease" -> R.drawable.ic_food_default
            "gastritis" -> R.drawable.ic_food_digestive
            "peptic" -> R.drawable.ic_food_peptic_ulcer
            "gerd" -> R.drawable.ic_food_gerd
            "ibs" -> R.drawable.ic_food_ibs
            "arthritis" -> R.drawable.ic_food_arthritis
            "back" -> R.drawable.ic_food_back_pain
            "osteoporosis" -> R.drawable.ic_food_osteoporosis
            else -> R.drawable.ic_food_default
        }
    }

    /**
     * Gets the medicine/drug image resource for a given disease ID.
     * Used to show drug illustrations alongside medicine lists.
     */
    fun getMedicineImageResId(diseaseId: String): Int {
        return R.drawable.ic_medicine_antibiotic
    }
}

package com.example.diseaseinformationhealthassistantmobileapplication

import com.example.diseaseinformationhealthassistantmobileapplication.data.DiseaseImageMapper
import com.example.diseaseinformationhealthassistantmobileapplication.data.DiseaseRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Verifies the added diseases (Cancer, Heart Disease, Brain Disease, Lung Disease, TB,
 * Pneumonia, Hypertension, Typhoid, Hepatitis, Asthma, Stroke) are available with
 * their types, food guidance and disease/food images.
 */
class NewDiseasesTest {

    private val expectedIds = listOf(
        "cancer_en",
        "heart_disease_en",
        "brain_disease_en",
        "lung_disease_en",
        "tb_en",
        "pneumonia_en",
        "hypertension_en",
        "typhoid_en",
        "hepatitis_en",
        "asthma_en",
        "stroke_en",
        "gastritis_en",
        "peptic_ulcer_en",
        "gerd_en",
        "ibs_en",
        "arthritis_en",
        "back_pain_en",
        "osteoporosis_en"
    )

    @Test
    fun allNewDiseasesExistInEnglish() {
        val ids = DiseaseRepository.getDiseases("en").map { it.id }
        for (expected in expectedIds) {
            assertTrue("Missing disease: $expected", ids.contains(expected))
        }
        assertEquals("Duplicate disease ids found", ids.size, ids.toSet().size)
    }

    @Test
    fun newDiseasesHaveFullDetails() {
        for (id in expectedIds) {
            val disease = DiseaseRepository.getDiseaseById(id, "en")
            assertNotNull("Disease not found: $id", disease)
            disease!!
            assertTrue("$id has empty definition", disease.definition.isNotBlank())
            assertTrue("$id has no symptoms", disease.symptoms.isNotEmpty())
            assertTrue("$id has no causes", disease.causes.isNotEmpty())
            assertTrue("$id has no prevention", disease.prevention.isNotEmpty())
            assertTrue("$id has no safety practices", disease.safetyPractices.isNotEmpty())
            assertTrue("$id has no food guidance", !disease.foodGuidance.isNullOrBlank())
            assertTrue("$id has no types", !disease.types.isNullOrEmpty())
            assertEquals("$id should be English", "en", disease.language)
        }
    }

    @Test
    fun newDiseasesHaveDistinctImages() {
        val diseaseImages = expectedIds.map { DiseaseImageMapper.getDiseaseImageResId(it) }
        val foodImages = expectedIds.map { DiseaseImageMapper.getFoodImageResId(it) }

        // Every new disease must have its own image, not the shared default.
        assertEquals(
            "Some disease images fell back to the default",
            diseaseImages.size,
            diseaseImages.toSet().size
        )
        assertEquals(
            "Some food images fell back to the default",
            foodImages.size,
            foodImages.toSet().size
        )

        // Default resources must not be used for the new diseases.
        val defaultDisease = DiseaseImageMapper.getDiseaseImageResId("unknown_disease")
        val defaultFood = DiseaseImageMapper.getFoodImageResId("unknown_disease")
        assertTrue(diseaseImages.none { it == defaultDisease })
        assertTrue(foodImages.none { it == defaultFood })
    }

    @Test
    fun allNewDiseasesExistInAfaanOromoo() {
        val omIds = listOf(
            "cancer_om",
            "heart_disease_om",
            "brain_disease_om",
            "lung_disease_om",
            "tb_om",
            "pneumonia_om",
            "hypertension_om",
            "typhoid_om",
            "hepatitis_om",
            "asthma_om",
            "stroke_om",
            "gastritis_om",
            "peptic_ulcer_om",
            "gerd_om",
            "ibs_om",
            "arthritis_om",
            "back_pain_om",
            "osteoporosis_om"
        )
        val ids = DiseaseRepository.getDiseases("om").map { it.id }
        for (expected in omIds) {
            assertTrue("Missing Afaan Oromoo disease: $expected", ids.contains(expected))
        }
        assertEquals("Duplicate om disease ids found", ids.size, ids.toSet().size)

        for (id in omIds) {
            val disease = DiseaseRepository.getDiseaseById(id, "om")
            assertNotNull("Oromiffa disease not found: $id", disease)
            disease!!
            assertTrue("$id has empty definition", disease.definition.isNotBlank())
            assertTrue("$id has no symptoms", disease.symptoms.isNotEmpty())
            assertTrue("$id has no causes", disease.causes.isNotEmpty())
            assertTrue("$id has no prevention", disease.prevention.isNotEmpty())
            assertTrue("$id has no safety practices", disease.safetyPractices.isNotEmpty())
            assertTrue("$id has no food guidance", !disease.foodGuidance.isNullOrBlank())
            assertTrue("$id has no types", !disease.types.isNullOrEmpty())
            assertEquals("$id should be Oromiffa", "om", disease.language)
        }

        // Images are shared with English through the base id.
        for (id in omIds) {
            assertEquals(
                "Image mismatch for $id",
                DiseaseImageMapper.getDiseaseImageResId(id),
                DiseaseImageMapper.getDiseaseImageResId(id.replace("_om", "_en"))
            )
            assertEquals(
                "Food image mismatch for $id",
                DiseaseImageMapper.getFoodImageResId(id),
                DiseaseImageMapper.getFoodImageResId(id.replace("_om", "_en"))
            )
        }
    }

    @Test
    fun everyDiseaseHasMedicines() {
        // Every disease in both languages must have drug names and a how-to-take guide.
        val enIds: List<String> = DiseaseRepository.getDiseases("en").map { it.id }
        val omIds: List<String> = DiseaseRepository.getDiseases("om").map { it.id }

        for (id in enIds) {
            val disease = DiseaseRepository.getDiseaseById(id, "en")
            assertNotNull("Disease not found: $id", disease)
            val d = disease!!
            assertTrue("$id has no medicines", !d.medicines.isNullOrEmpty())
            assertTrue("$id has no medicine guidance", !d.medicineGuide.isNullOrBlank())
        }

        for (id in omIds) {
            val disease = DiseaseRepository.getDiseaseById(id, "om")
            assertNotNull("Oromiffa disease not found: $id", disease)
            val d = disease!!
            assertTrue("$id has no medicines", !d.medicines.isNullOrEmpty())
            assertTrue("$id has no medicine guidance", !d.medicineGuide.isNullOrBlank())
        }
    }

    @Test
    fun everyUiCategoryHasDiseases() {
        // The labels shown on the home grid / categories screen. Tapping a category
        // navigates to search with the label as the query, so each label must match
        // at least one disease's category in every language.
        val uiCategoryLabels = listOf(
            "Skin", "Blood", "Heart", "Respiratory",
            "Digestive", "Musculoskeletal", "Infectious", "Nervous"
        )
        for (language in listOf("en", "om")) {
            val diseases = DiseaseRepository.getDiseases(language)
            for (label in uiCategoryLabels) {
                val matches = diseases.filter { it.category.equals(label, ignoreCase = true) }
                assertTrue(
                    "Category '$label' has no diseases in language '$language'",
                    matches.isNotEmpty()
                )
            }
        }
    }

    @Test
    fun originalDiseasesStillPresent() {
        val ids = DiseaseRepository.getDiseases("en").map { it.id }
        for (original in listOf("malaria_en", "hiv_en", "diabetes_en")) {
            assertTrue("Missing original disease: $original", ids.contains(original))
        }
        // The original content for each id must be unique and correct.
        assertEquals("Malaria", DiseaseRepository.getDiseaseById("malaria_en", "en")!!.name)
        assertEquals("HIV/AIDS", DiseaseRepository.getDiseaseById("hiv_en", "en")!!.name)
        assertEquals("Diabetes", DiseaseRepository.getDiseaseById("diabetes_en", "en")!!.name)
    }
}

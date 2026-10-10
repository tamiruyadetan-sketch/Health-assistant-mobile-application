package com.example.diseaseinformationhealthassistantmobileapplication.ai

/**
 * Built-in, offline AI assessment engine.
 */
object HealthAssessmentEngine {

    private val redFlagSymptoms = setOf(
        "chest_pain", "breathing_difficulty", "severe_bleeding", "seizure", "allergic_reaction"
    )

    fun generate(answers: AssessmentAnswers, language: String): AssessmentResult {
        val urgency = decideUrgency(answers)
        return AssessmentResult(
            urgency = urgency,
            summary = buildSummary(answers, language),
            recommendations = buildRecommendations(answers, urgency, language),
            source = "builtin"
        )
    }

    fun decideUrgency(a: AssessmentAnswers): Urgency {
        if (a.symptoms.any { it in redFlagSymptoms }) return Urgency.EMERGENCY

        val age = a.age.toIntOrNull()

        if ("dizziness" in a.symptoms &&
            (a.severity == "moderate" || a.severity == "severe" || (age ?: 0) >= 65)
        ) return Urgency.EMERGENCY

        if ("high_fever" in a.symptoms && age != null && age <= 2) return Urgency.EMERGENCY

        if (a.severity == "severe" && "heart_disease" in a.conditions) return Urgency.EMERGENCY

        val urgent = a.severity == "moderate" ||
            a.severity == "severe" ||
            a.duration == "chronic" ||
            (age != null && age <= 5)

        return if (urgent) Urgency.URGENT else Urgency.SELF_CARE
    }

    private fun buildSummary(a: AssessmentAnswers, language: String): String {
        val genderLabel = a.gender?.let { AssessmentOptions.labelOf(AssessmentOptions.genders, it, language) }
        val durationLabel = a.duration?.let { AssessmentOptions.labelOf(AssessmentOptions.durations, it, language) }
        val severityLabel = a.severity?.let { AssessmentOptions.labelOf(AssessmentOptions.severities, it, language) }
        
        val symptomLabels = buildList {
            addAll(a.symptoms.filter { it != "other" }.map { AssessmentOptions.labelOf(AssessmentOptions.symptoms, it, language) })
            if (a.otherSymptoms.isNotBlank()) add(a.otherSymptoms.trim())
        }.joinToString(", ")
        
        val conditionLabels = buildList {
            addAll(a.conditions.filter { it != "none" && it != "other" }.map { AssessmentOptions.labelOf(AssessmentOptions.conditions, it, language) })
            if (a.otherCondition.isNotBlank()) add(a.otherCondition.trim())
        }.joinToString(", ")

        return when (language) {
            "om" -> buildString {
                append("Madaallii AI-n: ")
                append("Umrii ")
                append(a.age.ifBlank { "?" })
                if (genderLabel != null) append(", ").append(genderLabel)
                append(". ")
                append("Dhukkubbii: ").append(symptomLabels.ifBlank { "-" })
                append(" (").append(durationLabel ?: "-").append(", ").append(severityLabel ?: "-").append("). ")
                if (conditionLabels.isNotBlank()) append("Dhukkubbiin dura jiran: ").append(conditionLabels).append(". ")
                append(if (a.hadBefore == "yes") "Dura qabaata ture." else "Kun jalqabaa dha.")
            }
            "am" -> buildString {
                append("በአይ አይ የተመሰረተ ግምገማ፡ ")
                append("ታካሚ ")
                append(a.age.ifBlank { "ያልታወቀ" })
                if (genderLabel != null) append("፣ ").append(genderLabel)
                append("። ")
                append("ስምምነቶች፡ ").append(symptomLabels.ifBlank { "-" })
                append(" (").append(durationLabel ?: "-").append("፣ ").append(severityLabel ?: "-").append(")። ")
                if (conditionLabels.isNotBlank()) append("የቀድሞ በሽታዎች፡ ").append(conditionLabels).append("። ")
                append(if (a.hadBefore == "yes") "ይህን ሁኔታ ቀድሞ ያጋጠመዎት ነው።" else "የመጀመሪያ ጊዜዎ ነው።")
            }
            else -> buildString {
                append("AI assessment: patient aged ")
                append(a.age.ifBlank { "not provided" })
                if (genderLabel != null) append(", ").append(genderLabel.lowercase())
                append(". ")
                append("Symptoms: ").append(symptomLabels.ifBlank { "-" })
                append(" (").append(durationLabel ?: "-").append(", ").append(severityLabel ?: "-").append("). ")
                if (conditionLabels.isNotBlank()) append("Pre-existing conditions: ").append(conditionLabels).append(". ")
                append(if (a.hadBefore == "yes") "This has been experienced before." else "First time experiencing this.")
            }
        }
    }

    private fun buildRecommendations(
        a: AssessmentAnswers,
        urgency: Urgency,
        language: String
    ): List<String> {
        val base = when (language) {
            "om" -> when (urgency) {
                Urgency.EMERGENCY -> listOf("Amma bilbila gargaarsa atattamaa (991) bilbilaa.", "Ofii keessan hin oofin.")
                Urgency.URGENT -> listOf("Gara ogeessa fayyaa 24 sa'aatii keessatti deemaa.", "Bishaan qulqulluu dhugaa.")
                else -> listOf("Boqonnaa gahaa fudhaa.", "Dhukkubbiin yoo itti fufe gara mana yaalaa deemaa.")
            }
            "am" -> when (urgency) {
                Urgency.EMERGENCY -> listOf("አሁን የአስቸኳይ እርዳታ (991) ይደውሉ።", "ራስዎን አይምዱ።")
                Urgency.URGENT -> listOf("በ24 ሰዓት ውስጥ ሐኪም ያማክሩ።", "ብዙ ፈሳሽ ይጠጡ።")
                else -> listOf("በቂ እረፍት ያድርጉ።", "ሕመሙ ከቀጠለ ወደ ሕክምና ይሂዱ።")
            }
            else -> when (urgency) {
                Urgency.EMERGENCY -> listOf("Call emergency services now (991).", "Do not drive yourself.")
                Urgency.URGENT -> listOf("See a doctor within 24 hours.", "Drink plenty of fluids.")
                else -> listOf("Rest and monitor symptoms.", "Seek help if it persists.")
            }
        }

        val extra = buildList {
            if ("heart_disease" in a.conditions) add(localized(language, "Monitor heart rate and avoid stress.", "Rukuttaa onnee hordofaa.", "የልብ ምትን ይከታተሉ እና ውጥረትን ያስወግዱ።"))
            if ("skin_disease" in a.conditions) add(localized(language, "Keep the skin area clean and avoid harsh soaps.", "Gogaa keessan qulqulleessaa.", "የቆዳውን ንፅህና ይጠብቁ እና ኃይለኛ ሳሙናዎችን ያስወግዱ።"))
            if ("blood_disease" in a.conditions) add(localized(language, "Avoid heavy exertion and eat iron-rich foods.", "Nyaata ayiraanii qabu nyaadhaa.", "ከባድ የአካል እንቅስቃሴን ያስወግዱ እና አይረን ያላቸውን ምግቦች ይመገቡ።"))
            if (a.age.toIntOrNull()?.let { it <= 5 } == true) add(localized(language, "This is a child - watch them closely.", "Kun mucaa dha - haala isaanii hordofaa.", "ይህ ህፃን ነው - በጥንቃቄ ይከታተሉ።"))
        }

        return base + extra
    }

    private fun localized(language: String, en: String, om: String, am: String): String =
        when (language) {
            "om" -> om
            "am" -> am
            else -> en
        }
}

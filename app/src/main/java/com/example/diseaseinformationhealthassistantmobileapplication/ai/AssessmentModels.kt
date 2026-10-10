package com.example.diseaseinformationhealthassistantmobileapplication.ai

/** A selectable option shown in the emergency assessment questionnaire. */
data class ChoiceOption(
    val id: String,
    val en: String,
    val om: String,
    val am: String
) {
    fun label(language: String): String = when (language) {
        "om" -> om
        "am" -> am
        else -> en
    }
}

/** How urgent the AI assessment considers the patient's condition. */
enum class Urgency { EMERGENCY, URGENT, SELF_CARE }

/** The AI-generated answer produced at the end of the questionnaire. */
data class AssessmentResult(
    val urgency: Urgency,
    val summary: String,
    val recommendations: List<String>,
    val source: String // "builtin" or "gemini"
)

/** All answers collected through the multi-step emergency assessment. */
data class AssessmentAnswers(
    val age: String = "",
    val gender: String? = null,                  // male | female | prefer_not_to_say
    val symptoms: Set<String> = emptySet(),      // see AssessmentOptions.symptoms
    val otherSymptoms: String = "",
    val duration: String? = null,                // today | few_days | over_week | chronic
    val severity: String? = null,                // mild | moderate | severe
    val conditions: Set<String> = emptySet(),    // see AssessmentOptions.conditions
    val otherCondition: String = "",
    val onMedications: String? = null,           // yes | no
    val medicationsText: String = "",
    val allergies: String? = null,               // yes | no
    val hadBefore: String? = null                // yes | no
)

/** Question options shared by the questionnaire UI, the offline engine and the AI prompt. */
object AssessmentOptions {

    val genders = listOf(
        ChoiceOption("male", "Male", "Dhiira", "ወንድ"),
        ChoiceOption("female", "Female", "Dubartaa", "ሴት"),
        ChoiceOption("prefer_not_to_say", "Prefer not to say", "Dhaadhachuu dhiifama", "መገለጽ አልፈልግም")
    )

    val symptoms = listOf(
        ChoiceOption("chest_pain", "Chest pain", "Xixiqqaa laphee", "የደረት ህመም"),
        ChoiceOption("breathing_difficulty", "Difficulty breathing", "Hafuura dabuu", "የትንፋሽ ማጠር"),
        ChoiceOption("severe_bleeding", "Severe bleeding", "Dhiigni balaalee", "መሟላት ከፍተኛ መሆን"),
        ChoiceOption("high_fever", "High fever", "Qamaa andandaa", "ከፍተኛ ትኩሳት"),
        ChoiceOption("headache", "Headache", "Dhukkubii mataa", "የራስ ህመም"),
        ChoiceOption("dizziness", "Dizziness or fainting", "Marifachuu yookiin dadhabuu", "ማዞር ወይም ማነው"),
        ChoiceOption("abdominal_pain", "Abdominal pain", "Dhukkubii keelee", "የአፍ ህመም"),
        ChoiceOption("vomiting", "Vomiting or diarrhea", "Araaraa yookiin qoraamsuu", "መቅላቅል ወይም የአንጀት ሽፋን"),
        ChoiceOption("injury", "Injury or fracture", "Haala lama yookiin breakii", "ጉዳት ወይም መሰረት መበጠስ"),
        ChoiceOption("seizure", "Seizures", "Hiramaa (fit)", "እብራ (seizure)"),
        ChoiceOption("allergic_reaction", "Swelling or allergic reaction", "Badhaadhii yookiin aangoo", "ብብት ወይም የአለርጂ ምላሽ"),
        ChoiceOption("cough", "Cough or sore throat", "Kanjalaan yookiin fangaanii xiqqaa", "እንቁልቁል ወይም የጉሮሮ ህመም"),
        ChoiceOption("other", "Other symptoms", "Waan bira", "ሌሎች ስምምነቶች")
    )

    val durations = listOf(
        ChoiceOption("today", "Just started today", "Har'aa kan eegale", "ዛሬ ብቻ የተጀመረ"),
        ChoiceOption("few_days", "A few days", "Guyyoota tokko labsan", "ጥቂት ቀናት"),
        ChoiceOption("over_week", "More than a week", "Torbaa caalaa", "ከአንድ ሳምንት በላይ"),
        ChoiceOption("chronic", "Chronic / Ongoing", "Yeroo dheeraa / itti fufaa", "ረጅም ጊዜ / ቀጣይ")
    )

    val severities = listOf(
        ChoiceOption("mild", "Mild", "Xiqqaa", "ቀላል"),
        ChoiceOption("moderate", "Moderate", "Golboo", "መካከለኛ"),
        ChoiceOption("severe", "Severe", "Waliigalaa", "ከባድ")
    )

    val conditions = listOf(
        ChoiceOption("diabetes", "Diabetes", "Sukkaaraa", "የስኳር በሽታ"),
        ChoiceOption("hypertension", "High blood pressure", "Dhiibbaa dhiigaa ol'aanaa", "ከፍተኛ የደም ግፊት"),
        ChoiceOption("asthma", "Asthma", "Astmaa", "እንብርحة (Asthma)"),
        ChoiceOption("heart_disease", "Heart disease", "Dhibee onnee", "የልብ በሽታ"),
        ChoiceOption("skin_disease", "Skin disease", "Dhibee gogaa", "የቆዳ በሽታ"),
        ChoiceOption("blood_disease", "Blood disease", "Dhibee dhiigaa", "የደም በሽታ"),
        ChoiceOption("none", "None", "Hin jiru", "የለኝም"),
        ChoiceOption("other", "Other", "Kan biraa", "ሌላ")
    )

    fun labelOf(list: List<ChoiceOption>, id: String, language: String): String =
        list.find { it.id == id }?.label(language) ?: id

    fun labelsOf(list: List<ChoiceOption>, ids: Collection<String>, language: String): String =
        ids.joinToString(", ") { labelOf(list, it, language) }
}

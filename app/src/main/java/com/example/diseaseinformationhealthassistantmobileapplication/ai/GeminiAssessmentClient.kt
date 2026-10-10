package com.example.diseaseinformationhealthassistantmobileapplication.ai

import android.os.Handler
import android.os.Looper
import org.json.JSONArray
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

/**
 * Optional real-AI answer generation using the Google Gemini API.
 *
 * Used only when the user has pasted an API key in the assessment screen;
 * otherwise [HealthAssessmentEngine] generates the answer offline.
 * All callbacks are delivered on the main thread.
 */
object GeminiAssessmentClient {

    private const val MODEL = "gemini-2.0-flash"
    private const val ENDPOINT =
        "https://generativelanguage.googleapis.com/v1beta/models/$MODEL:generateContent"
    private const val CONNECT_TIMEOUT = 20_000
    private const val READ_TIMEOUT = 30_000

    private val mainHandler = Handler(Looper.getMainLooper())

    fun generate(
        apiKey: String,
        answers: AssessmentAnswers,
        language: String,
        onResult: (AssessmentResult) -> Unit,
        onError: (String) -> Unit
    ) {
        val prompt = buildPrompt(answers, language)
        Thread {
            try {
                val connection = URL("$ENDPOINT?key=$apiKey").openConnection() as HttpURLConnection
                connection.requestMethod = "POST"
                connection.doOutput = true
                connection.connectTimeout = CONNECT_TIMEOUT
                connection.readTimeout = READ_TIMEOUT
                connection.setRequestProperty("Content-Type", "application/json")

                val body = JSONObject().apply {
                    put("contents", JSONArray().apply {
                        put(JSONObject().apply {
                            put("parts", JSONArray().apply {
                                put(JSONObject().put("text", prompt))
                            })
                        })
                    })
                    put("generationConfig", JSONObject().apply {
                        put("temperature", 0.4)
                        put("responseMimeType", "application/json")
                    })
                }

                connection.outputStream.use { out ->
                    out.write(body.toString().toByteArray(Charsets.UTF_8))
                }

                val code = connection.responseCode
                if (code !in 200..299) {
                    val err = connection.errorStream?.bufferedReader()?.use { it.readText() }
                    val message = parseErrorMessage(err) ?: "HTTP $code"
                    postError(onError, message)
                    return@Thread
                }

                val responseText = connection.inputStream.bufferedReader().use { it.readText() }
                val result = parseResponse(responseText, answers, language)
                if (result == null) {
                    postError(onError, "unreadable AI response")
                } else {
                    mainHandler.post { onResult(result) }
                }
            } catch (t: Throwable) {
                postError(onError, t.message ?: "network error")
            }
        }.start()
    }

    private fun postError(onError: (String) -> Unit, detail: String) {
        mainHandler.post { onError(detail) }
    }

    // --------------------------------------------------------------- request

    private fun buildPrompt(answers: AssessmentAnswers, language: String): String {
        val languageName = when (language) {
            "om" -> "Afaan Oromoo (Oromo)"
            "am" -> "Amharic"
            else -> "English"
        }
        fun join(ids: Collection<String>, options: List<ChoiceOption>) =
            ids.joinToString(", ") { id -> options.find { it.id == id }?.en ?: id }

        val facts = buildList {
            add("Age: ${answers.age.ifBlank { "not provided" }}")
            add("Gender: ${answers.gender ?: "not provided"}")
            add("Symptoms: ${join(answers.symptoms, AssessmentOptions.symptoms)}" +
                if (answers.otherSymptoms.isNotBlank()) ", ${answers.otherSymptoms}" else "")
            add("Duration: ${answers.duration ?: "not provided"}")
            add("Severity: ${answers.severity ?: "not provided"}")
            add("Pre-existing conditions: ${join(answers.conditions, AssessmentOptions.conditions)}" +
                if (answers.otherCondition.isNotBlank()) ", ${answers.otherCondition}" else "")
            add("Taking medications: ${answers.onMedications ?: "not provided"}" +
                if (answers.medicationsText.isNotBlank()) " (${answers.medicationsText})" else "")
            add("Known allergies: ${answers.allergies ?: "not provided"}")
            add("Had this condition before: ${answers.hadBefore ?: "not provided"}")
        }.joinToString("\n")

        return """
            You are an emergency triage assistant inside a health information app.
            Based on the patient's answers below, give a triage assessment.

            Patient answers:
            $facts

            Reply ONLY with this JSON object (no other text):
            {
              "urgency": "EMERGENCY" or "URGENT" or "SELF_CARE",
              "summary": "2-4 sentence plain-language summary of the assessment",
              "recommendations": ["4-5 short, concrete action steps"]
            }

            Triage rules:
            - EMERGENCY: danger signs such as chest pain, difficulty breathing, severe bleeding,
              seizures, severe allergic reaction/swelling, fainting, or high fever in an infant.
            - URGENT: moderate or severe symptoms, chronic ongoing symptoms, or a young child.
            - SELF_CARE: mild, short-lived symptoms with no danger signs.

            Write the summary and recommendations in $languageName.
            Add a reminder that this does not replace professional medical advice.
            Keep it calm, practical and easy to understand.
        """.trimIndent()
    }

    // ---------------------------------------------------------------- parsing

    private fun parseResponse(
        responseText: String,
        answers: AssessmentAnswers,
        language: String
    ): AssessmentResult? {
        return try {
            val envelope = JSONObject(responseText)
            val text = envelope
                .getJSONArray("candidates")
                .getJSONObject(0)
                .getJSONObject("content")
                .getJSONArray("parts")
                .getJSONObject(0)
                .getString("text")

            val json = JSONObject(stripFences(text))
            val urgency = when (json.optString("urgency").uppercase()) {
                "EMERGENCY" -> Urgency.EMERGENCY
                "URGENT" -> Urgency.URGENT
                "SELF_CARE" -> Urgency.SELF_CARE
                else -> HealthAssessmentEngine.decideUrgency(answers)
            }
            val summary = json.optString("summary").trim()
            if (summary.isEmpty()) return null

            val recommendations = buildList {
                val array = json.optJSONArray("recommendations")
                if (array != null) {
                    for (i in 0 until array.length()) {
                        val item = array.optString(i).trim()
                        if (item.isNotEmpty()) add(item)
                    }
                }
            }

            AssessmentResult(
                urgency = urgency,
                summary = summary,
                recommendations = recommendations.ifEmpty {
                    HealthAssessmentEngine.generate(answers, language).recommendations
                },
                source = "gemini"
            )
        } catch (e: Exception) {
            null
        }
    }

    private fun stripFences(text: String): String {
        var t = text.trim()
        if (t.startsWith("```")) {
            t = t.removePrefix("```json").removePrefix("```JSON").removePrefix("```").trim()
            t = t.removeSuffix("```").trim()
        }
        // If the model wrapped the object in extra prose, keep the outermost braces.
        val start = t.indexOf('{')
        val end = t.lastIndexOf('}')
        if (start >= 0 && end > start) t = t.substring(start, end + 1)
        return t
    }

    private fun parseErrorMessage(body: String?): String? {
        if (body.isNullOrBlank()) return null
        return try {
            JSONObject(body)
                .optJSONObject("error")
                ?.optString("message")
                ?.takeIf { it.isNotBlank() }
        } catch (e: Exception) {
            null
        }
    }
}

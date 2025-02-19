package com.example.thelema

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONArray

class PreguntasFrecuentesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preguntas_frecuentes)

        val questionsContainer: LinearLayout = findViewById(R.id.questionsContainer)

        val preguntas = leerPreguntasDesdeArchivo()

        preguntas.forEach { (question, answer) ->
            val questionButton = Button(this).apply {
                text = question
                contentDescription = question
                setOnClickListener {
                    val existingAnswerTextView = questionsContainer.findViewWithTag<TextView>(question)
                    if (existingAnswerTextView == null) {
                        val answerTextView = TextView(this@PreguntasFrecuentesActivity).apply {
                            text = answer
                            textSize = 16f
                            setPadding(0, 16, 0, 16)
                            contentDescription = answer
                            tag = question
                        }
                        questionsContainer.addView(answerTextView)
                    }
                }
            }
            questionsContainer.addView(questionButton)
        }

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                finish()
            }
        }
        onBackPressedDispatcher.addCallback(this, callback)
    }

    private fun leerPreguntasDesdeArchivo(): List<Pair<String, String>> {
        val preguntas = mutableListOf<Pair<String, String>>()
        try {
            val inputStream = assets.open("preguntas.json")
            val jsonString = inputStream.bufferedReader().use { it.readText() }
            val jsonArray = JSONArray(jsonString)

            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                val pregunta = jsonObject.getString("pregunta")
                val respuesta = jsonObject.getString("respuesta")
                preguntas.add(Pair(pregunta, respuesta))
            }
        } catch (e: Exception) {
            Log.e("PreguntasFrecuentesActivity", "Error al leer preguntas desde archivo JSON: ${e.message}")
            // Consider showing a user-friendly message or handling the error more gracefully.
        }
        return preguntas
    }

    fun volverAtras() {
        finish()
    }

    fun volverAtras(view: View) {}
}
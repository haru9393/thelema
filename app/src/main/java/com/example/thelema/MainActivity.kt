package com.example.thelema

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.ScrollView
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // 1. Define bookContentData (This is an example - replace with your data)
    private val bookContentData: Map<String, Map<String, Map<String, String>>> = mapOf(
        "Liber AL vel Legis" to mapOf(
            "Capítulo 1" to mapOf(
                "1" to "Versículo 1: La Ley es para todos...",
                "2" to "Versículo 2: Haz lo que tú quieras...",
                // ... more verses
            ),
            "Capítulo 2" to mapOf(
                "1" to "Versículo 1: Tu que ens estas palabras...",
                // ... more verses
            ),
            // ... more chapters
        ),
        "Liber AL" to mapOf(
            // ... your Liber AL content
        ),
        "Liber II" to mapOf(
            // ... your Liber II content
        ),
        "Liber Tzaddi" to mapOf(
            // ... your Liber Tzaddi content
        )
    )

    // 2. Define oraciones (This is an example - replace with your oraciones)
    private val oraciones = mapOf(
        "Oración 1" to "Texto de la oración 1...",
        "Oración 2" to "Texto de la oración 2...",
        // ... more oraciones
    )

    // 3. Define preguntasFrecuentes (This is an example - replace with your questions)
    private val preguntasFrecuentes = mapOf(
        "Pregunta 1" to "Respuesta 1...",
        "Pregunta 2" to "Respuesta 2...",
        // ... more preguntas
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ... (Your findViewById calls and click listeners - NO CHANGES NEEDED HERE)

        val buttonLiberAlVelLegis = findViewById<Button>(R.id.buttonLiberAlVelLegis)
        val buttonLiberAl = findViewById<Button>(R.id.buttonLiberAl)
        val buttonLiberII = findViewById<Button>(R.id.buttonLiberII)
        val buttonLiberTzaddi = findViewById<Button>(R.id.buttonLiberTzaddi)
        val buttonOraciones = findViewById<Button>(R.id.buttonOraciones)
        val buttonPreguntas = findViewById<Button>(R.id.buttonPreguntas)
        val buttonThemes = findViewById<Button>(R.id.buttonThemes)
        val scrollView = findViewById<ScrollView>(R.id.scrollView)
        val textView = findViewById<TextView>(R.id.textView)

        textView.movementMethod = ScrollingMovementMethod()

        buttonLiberAlVelLegis.setOnClickListener { showChapters("Liber AL vel Legis", findViewById(R.id.chaptersLiberAlVelLegis)) }
        buttonLiberAl.setOnClickListener { showChapters("Liber AL", findViewById(R.id.chaptersLiberAl)) }
        buttonLiberII.setOnClickListener { showChapters("Liber II", findViewById(R.id.chaptersLiberII)) }
        buttonLiberTzaddi.setOnClickListener { showChapters("Liber Tzaddi", findViewById(R.id.chaptersLiberTzaddi)) }

        buttonOraciones.setOnClickListener { showContent(getOracionesContent()) }
        buttonPreguntas.setOnClickListener { showContent(getPreguntasFrecuentesContent()) }
        buttonThemes.setOnClickListener { showContent("Aquí irán los temas y versículos", findViewById(R.id.themesContainer)) }

        scrollView.visibility = View.GONE

    } // End of onCreate

    private fun showChapters(bookName: String, chaptersContainer: LinearLayout) {
        chaptersContainer.removeAllViews()
        val book = bookContentData[bookName]

        book?.forEach { (chapter, _) ->
            val button = Button(this)
            button.text = chapter
            button.setOnClickListener { showVerses(bookName, chapter) }
            chaptersContainer.addView(button)
        }

        chaptersContainer.visibility = View.VISIBLE
        showContent("")
    }

    private fun showVerses(bookName: String, chapter: String) {
        val verses = bookContentData[bookName]?.get(chapter)
        val content = StringBuilder()

        verses?.forEach { (verse, text) ->
            content.append("$verse: $text\n")
        }

        showContent(content.toString())
    }

    private fun showContent(content: String, container: LinearLayout? = null) {
        val scrollView = findViewById<ScrollView>(R.id.scrollView)
        val textView = findViewById<TextView>(R.id.textView)

        textView.text = content
        scrollView.visibility = View.VISIBLE
        container?.visibility = View.VISIBLE
    }

    private fun getOracionesContent(): String {
        val content = StringBuilder()
        oraciones.forEach { (title, text) ->
            content.append("$title\n")
            content.append("$text\n\n")
        }
        return content.toString()
    }

    private fun getPreguntasFrecuentesContent(): String {
        val content = StringBuilder()
        preguntasFrecuentes.forEach { (question, answer) ->
            content.append("Pregunta: $question\n")
            content.append("Respuesta: $answer\n\n")
        }
        return content.toString()
    }
}
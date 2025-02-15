package com.example.thelema

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.view.View
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val bookContentData: Map<String, Map<String, Map<String, String>>> = mapOf(
        // Agregar contenido de los libros
    )

    private val oraciones = listOf(
        // Contenido de las oraciones
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a los botones
        val oracionesButton: Button = findViewById(R.id.buttonOraciones)
        val liberALButton: Button = findViewById(R.id.buttonLiberAL)
        val liberIIButton: Button = findViewById(R.id.buttonLiberII)
        val liberTzaddiButton: Button = findViewById(R.id.buttonLiberTzaddi)
        val contentTextView: TextView = findViewById(R.id.textView)
        val scrollView: ScrollView = findViewById(R.id.scrollView)

        // Mostrar oraciones al hacer clic en el botón
        oracionesButton.setOnClickListener {
            contentTextView.text = getOracionesContent()
            scrollView.visibility = View.VISIBLE
        }

        // Mostrar el contenido de Liber AL vel Legis
        liberALButton.setOnClickListener {
            contentTextView.text = getBookContent("Liber AL vel Legis")
            scrollView.visibility = View.VISIBLE
        }

        // Mostrar el contenido de Liber II
        liberIIButton.setOnClickListener {
            contentTextView.text = getBookContent("Liber II")
            scrollView.visibility = View.VISIBLE
        }

        // Mostrar el contenido de Liber Tzaddi
        liberTzaddiButton.setOnClickListener {
            contentTextView.text = getBookContent("Liber Tzaddi")
            scrollView.visibility = View.VISIBLE
        }
    }

    // Función para obtener el contenido de las oraciones
    private fun getOracionesContent(): String {
        var content = ""
        oraciones.forEach { (title, text) ->
            content += "\n$title\n$text\n"
        }
        return content
    }

    // Función para obtener el contenido de un libro específico
    private fun getBookContent(bookTitle: String): String {
        val bookContent = bookContentData[bookTitle]
        var content = "$bookTitle\n"

        // Mostrar capítulos y versículos del libro
        bookContent?.forEach { (chapterTitle, verses) ->
            content += "\n$chapterTitle\n"
            verses.forEach { (verseTitle, verseText) ->
                content += "\n$verseTitle: $verseText\n"
            }
        }
        return content
    }
}

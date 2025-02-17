package com.example.thelema

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var chaptersContainer: LinearLayout
    private lateinit var chapterTitleTextView: TextView  // Nuevo TextView para títulos de capítulo
    private lateinit var verseTextView: TextView  // Nuevo TextView para textos de versículo
    private lateinit var versesContainer: LinearLayout

    // Tu mapa de datos (sin cambios)
    private val bookContentData: Map<String, Map<String, Map<String, String>>> = mapOf(
        // ... (tu información de libros, capítulos y versículos)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicialización de vistas (sin cambios)
        chaptersContainer = findViewById(R.id.chaptersContainer)
        chapterTitleTextView = findViewById(R.id.chapterTitleTextView)  // Nueva vista
        verseTextView = findViewById(R.id.verseTextView)  // Nueva vista
        versesContainer = findViewById(R.id.versesContainer)

        // Botones (sin cambios)
        val buttonLiberAlVelLegis: Button = findViewById(R.id.buttonLiberAlVelLegis)
        val buttonLiberII: Button = findViewById(R.id.buttonLiberII)
        val buttonLiberTzaddi: Button = findViewById(R.id.buttonLiberTzaddi)
        val buttonOraciones: Button = findViewById(R.id.buttonOraciones)
        val buttonPreguntas: Button = findViewById(R.id.buttonPreguntas)
        val buttonThemes: Button = findViewById(R.id.buttonThemes)

        // OnClickListeners (CORREGIDOS)
        buttonLiberAlVelLegis.setOnClickListener { showChapters("Liber AL vel Legis") }
        buttonLiberII.setOnClickListener { showChapters("Liber II") }
        buttonLiberTzaddi.setOnClickListener { showChapters("Liber Tzaddi") }
        buttonOraciones.setOnClickListener {
            val intent = Intent(this, OracionesActivity::class.java)
            startActivity(intent)
        }
        buttonPreguntas.setOnClickListener {
            val intent = Intent(this, PreguntasFrecuentesActivity::class.java)
            startActivity(intent)
        }
        buttonThemes.setOnClickListener {
            val intent = Intent(this, ThemesActivity::class.java)
            startActivity(intent)
        }

        // Mostrar libros (sin cambios)
        showBooks()
    }

    // showBooks (sin cambios)
    private fun showBooks() {
        chaptersContainer.removeAllViews()

        val books = listOf("Liber AL vel Legis", "Liber II", "Liber Tzaddi")
        books.forEach { bookName ->
            val bookButton = Button(this).apply {
                text = bookName
                setOnClickListener {
                    showChapters(bookName)
                }
            }
            chaptersContainer.addView(bookButton)
        }
    }

    // showChapters (CORREGIDO)
    private fun showChapters(bookName: String) {
        val chapters = bookContentData[bookName] ?: return

        chaptersContainer.removeAllViews()
        chaptersContainer.visibility = View.VISIBLE  // Mostrar capítulos
        versesContainer.visibility = View.GONE  // Ocultar versículos

        chapters.forEach { (chapterName, verses) ->
            val chapterButton = Button(this).apply {
                text = getString(R.string.chapter_title, chapterName)
                setOnClickListener {
                    showVerses(bookName, chapterName, verses)
                }
            }
            chaptersContainer.addView(chapterButton)
        }
    }

    // showVerses (CORREGIDO)
    private fun showVerses(bookName: String, chapterName: String, verses: Map<String, String>) {
        val chapterTitle = getString(R.string.book_title, bookName) + "\n" + getString(R.string.chapter_title, chapterName)
        chapterTitleTextView.text = chapterTitle  // Usar el nuevo TextView para el título del capítulo

        versesContainer.removeAllViews()
        chaptersContainer.visibility = View.GONE  // Ocultar capítulos
        versesContainer.visibility = View.VISIBLE  // Mostrar versículos

        verses.forEach { (verseName, verseText) ->
            val verseButton = Button(this).apply {
                text = verseName
                setOnClickListener {
                    verseTextView.text = verseText  // Usar el nuevo TextView para el texto del versículo
                }
            }
            versesContainer.addView(verseButton)
        }
    }
}

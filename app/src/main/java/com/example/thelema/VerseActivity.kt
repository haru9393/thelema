package com.example.thelema

import android.os.Bundle
import android.widget.TextView
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class VerseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ¡ESTE ES EL ORDEN CORRECTO! Primero setContentView(), luego findViewById()
        setContentView(R.layout.activity_verse)  // Establece el diseño

        // Ahora puedes buscar las vistas, ya que el diseño ya está inflado
        val bookName = intent.getStringExtra("bookName")
        val chapterName = intent.getStringExtra("chapterName")
        val verseText = intent.getStringExtra("verseText")

        val chapterTitleTextView = findViewById<TextView>(R.id.chapterTitleTextView)
        chapterTitleTextView.text = String.format(
            getString(R.string.chapter_title_format),
            getString(R.string.book_title, bookName),
            getString(R.string.chapter_title, chapterName)
        )

        val verseTextView = findViewById<TextView>(R.id.verseTextView)
        verseTextView.text = verseText

        val backButton = findViewById<ImageButton>(R.id.backButton)
        backButton.setImageResource(R.drawable.ic_arrow_back_verses) // Cambia el icono

        backButton.setOnClickListener {
            finish()
        }
    }
}
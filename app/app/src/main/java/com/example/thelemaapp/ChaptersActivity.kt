package com.example.thelemaapp

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class ChaptersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapters)

        // Obtener el nombre del libro que fue enviado desde MainActivity
        val bookName = intent.getStringExtra("BOOK_NAME")

        // Referencia al contenedor de los botones de los capítulos
        val chapterContainer = findViewById<LinearLayout>(R.id.chapterContainer)

        // Lista de capítulos de ejemplo (esto se puede cambiar según el libro seleccionado)
        val chapters = when (bookName) {
            "Liber AL vel Legis" -> listOf("Capítulo 1", "Capítulo 2", "Capítulo 3")
            "Liber II" -> listOf("Capítulo 1", "Capítulo 2", "Capítulo 3")
            "Liber Tzaddi" -> listOf("Capítulo 1", "Capítulo 2", "Capítulo 3")
            else -> listOf() // Si no se encuentra el libro, no mostramos nada
        }

        // Crear un botón por cada capítulo
        for (chapter in chapters) {
            val button = Button(this)
            button.text = chapter
            button.setOnClickListener {
                // Aquí podrías abrir una nueva actividad con el contenido del capítulo
                // Por ejemplo, podrías enviar el nombre del capítulo a la siguiente actividad
            }
            chapterContainer.addView(button) // Agregar el botón al layout
        }
    }
}

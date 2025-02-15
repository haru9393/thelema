package com.example.thelema

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ThemesActivity : AppCompatActivity() {

    private val themes = listOf(
        "Amor", "Enojo", "Ansiedad", "Esperanza", "Paz", "Temor",
        "Paciencia", "Orgullo", "Tentación", "Duda", "Gozo", "Estrés", "Sanidad"
    )

    private val verses = mapOf(
        "Amor" to "Amor es la ley, amor bajo voluntad. (Liber AL vel Legis 1:57)",
        "Enojo" to "No te detengas por el odio. Deja que todo se haga según la voluntad. (Liber AL vel Legis 3:42)",
        "Ansiedad" to "Nada hay que temer en el camino de la voluntad. (Liber AL vel Legis 2:70)",
        "Esperanza" to "Hay ayuda y esperanza en nuestra vida. (Liber AL vel Legis 2:21)",
        "Paz" to "Sé fuerte, oh hombre, en la alegría de tu fuerza. (Liber AL vel Legis 2:66)",
        "Temor" to "No temas nada, no dudes en absoluto. (Liber AL vel Legis 3:17)",
        "Paciencia" to "Sigue tu voluntad sin apurarte. (Liber AL vel Legis 1:44)",
        "Orgullo" to "Sé orgulloso de tu voluntad y síguela con pasión. (Liber AL vel Legis 2:30)",
        "Tentación" to "No hay ley más allá de Haz tu voluntad. (Liber AL vel Legis 3:60)",
        "Duda" to "No dudes de tu camino, pues es el camino de la estrella. (Liber AL vel Legis 2:7)",
        "Gozo" to "Vive con alegría, pues el gozo es poder. (Liber AL vel Legis 2:9)",
        "Estrés" to "Relájate en la danza de la vida. (Liber AL vel Legis 2:22)",
        "Sanidad" to "El cuerpo es un templo, cuídalo y fortalécelo. (Liber AL vel Legis 2:56)"
    )

    private lateinit var verseTextView: TextView
    private lateinit var themesListView: ListView
    private lateinit var buttonBack: Button
    private lateinit var buttonShare: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_themes)

        verseTextView = findViewById(R.id.verseTextView)
        themesListView = findViewById(R.id.themesListView)
        buttonBack = findViewById(R.id.buttonBack) // Inicializa buttonBack
        buttonShare = findViewById(R.id.buttonShare) // Inicializa buttonShare


        val adapter = ThemesAdapter(this, android.R.layout.simple_list_item_2, themes)
        themesListView.adapter = adapter

        themesListView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedTheme = themes[position]
            val verse = verses[selectedTheme] ?: "No hay versículo disponible"
            verseTextView.text = verse
        }

        buttonBack.setOnClickListener {
            finish()
        }

        buttonShare.setOnClickListener {
            val verseText = verseTextView.text.toString()

            if (verseText.isNotEmpty()) {
                val shareIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, " $verseText \n\nDescarga la app de Thelema ")
                    type = "text/plain"
                }
                startActivity(Intent.createChooser(shareIntent, "Compartir versículo con:"))
            } else {
                Toast.makeText(this, "No hay versículo seleccionado", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
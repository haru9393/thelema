package com.example.thelemaapp

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_themes)

        val themesListView: ListView = findViewById(R.id.themesListView)
        val verseTextView: TextView = findViewById(R.id.verseTextView)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, themes)
        themesListView.adapter = adapter

        themesListView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedTheme = themes[position]
            val verse = verses[selectedTheme] ?: "No hay versículo disponible"
            verseTextView.text = verse
        }
    }
}

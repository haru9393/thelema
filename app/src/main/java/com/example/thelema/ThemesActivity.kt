package com.example.thelema

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONArray


class ThemesActivity : AppCompatActivity() {

    private lateinit var verseTextView: TextView
    private lateinit var themesListView: ListView
    private lateinit var buttonBack: Button
    private lateinit var buttonShare: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_themes)

        verseTextView = findViewById(R.id.verseTextView)
        themesListView = findViewById(R.id.themesListView)
        buttonBack = findViewById(R.id.buttonBack)
        buttonShare = findViewById(R.id.buttonShare)

        val temas = leerTemasDesdeArchivo()

        Log.d("ThemesActivity", "Lista de temas: $temas")

        val adapter = ThemesAdapter(this, temas.map { it.tema })
        themesListView.adapter = adapter

        themesListView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedTheme = temas[position].tema
            val verse = temas.find { it.tema == selectedTheme }?.versiculo ?: "No hay versículo disponible"
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

    private fun leerTemasDesdeArchivo(): List<Tema> {
        val temas = mutableListOf<Tema>()
        try {
            val inputStream = assets.open("temas.json")
            val jsonString = inputStream.bufferedReader().use { it.readText() }
            val jsonArray = JSONArray(jsonString)

            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                val tema = jsonObject.getString("tema")
                val versiculo = jsonObject.getString("versiculo")
                temas.add(Tema(tema, versiculo))
            }
        } catch (e: Exception) {
            Log.e("ThemesActivity", "Error al leer temas desde archivo JSON: ${e.message}")
            // Maneja el error, por ejemplo, mostrando un mensaje al usuario
        }
        return temas
    }

    data class Tema(val tema: String, val versiculo: String)
}
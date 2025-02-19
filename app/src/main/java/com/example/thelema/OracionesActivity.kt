package com.example.thelema

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONArray


class OracionesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oraciones)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val scrollViewContenido = findViewById<ScrollView>(R.id.scrollViewContenido)
        val contenidoContainer: LinearLayout = findViewById(R.id.contenidoContainer)

        Log.d("OracionesActivity", "Contenido container: $contenidoContainer")

        // Inicialmente ocultamos el ScrollView
        scrollViewContenido.visibility = View.GONE

        val oraciones = leerOracionesDesdeArchivo()
        showOraciones(oraciones)

        // Buscamos el botón "Regresar" y le añadimos el listener
        val botonRegresar = findViewById<TextView>(R.id.buttonRegresar)
        botonRegresar.setOnClickListener {
            finish()
        }

        // Mostrar el ScrollView cuando se cargan las oraciones
        scrollViewContenido.visibility = View.VISIBLE
    }

    private fun leerOracionesDesdeArchivo(): List<Pair<String, String>> {
        val oraciones = mutableListOf<Pair<String, String>>()
        try {
            val inputStream = assets.open("oraciones.json")
            val jsonString = inputStream.bufferedReader().use { it.readText() }
            val jsonArray = JSONArray(jsonString)

            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                val titulo = jsonObject.getString("titulo")
                val texto = jsonObject.getString("texto")
                oraciones.add(Pair(titulo, texto))
            }
        } catch (e: Exception) {
            Log.e("OracionesActivity", "Error al leer oraciones desde archivo JSON: ${e.message}")
            // Maneja el error, por ejemplo, mostrando un mensaje al usuario
        }
        return oraciones
    }

    private fun showOraciones(oraciones: List<Pair<String, String>>) {
        val contenidoContainer: LinearLayout = findViewById(R.id.contenidoContainer)
        contenidoContainer.removeAllViews()

        for ((titulo, texto) in oraciones) {
            val tituloTextView = TextView(this).apply {
                text = titulo
                textSize = 18f
                setPadding(0, 8, 0, 8)
            }

            val contenidoTextView = TextView(this).apply {
                text = texto
                textSize = 16f
                setPadding(0, 8, 0, 8)
                visibility = View.GONE
            }

            tituloTextView.setOnClickListener {
                contenidoTextView.visibility = if (contenidoTextView.visibility == View.GONE) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
            }

            contenidoContainer.addView(tituloTextView)
            contenidoContainer.addView(contenidoTextView)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
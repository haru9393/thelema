package com.example.thelema

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetalleOracionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_oracion)

        // Obtener los datos del Intent
        val titulo = intent.getStringExtra("titulo") ?: "Sin Título"
        val contenido = intent.getStringExtra("contenido") ?: "Contenido no disponible"

        // Configurar los elementos de la interfaz
        val tituloTextView = findViewById<TextView>(R.id.textViewTitulo)
        val contenidoTextView = findViewById<TextView>(R.id.textViewContenido)

        // Mostrar los datos
        tituloTextView.text = titulo
        contenidoTextView.text = contenido
    }
}


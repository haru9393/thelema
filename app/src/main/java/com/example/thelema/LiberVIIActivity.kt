package com.example.thelema

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LiberVIIActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liber_vii)  // Usamos el layout que hemos creado para esta actividad

        // Si tienes algún TextView u otros componentes que quieras actualizar programáticamente
        // puedes encontrarlos aquí, por ejemplo:

        val textViewLiberVII: TextView = findViewById(R.id.textLiberVII)
        textViewLiberVII.text = getString(R.string.libervii_title) // Aquí puedes actualizar el texto dinámicamente si lo deseas
    }
}

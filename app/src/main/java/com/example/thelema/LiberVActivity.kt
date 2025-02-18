package com.example.thelema

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class LiberVActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liber_v) // Asegúrate de que el layout esté en res/layout/activity_liber_v.xml

        val textViewLiberV: TextView = findViewById(R.id.textLiberV)
        textViewLiberV.text = getString(R.string.liber_v_title) // Usa el recurso de texto definido en strings.xml
    }
}

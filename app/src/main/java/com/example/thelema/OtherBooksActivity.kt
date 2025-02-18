package com.example.thelema

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class OtherBooksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other_books)

        // Botones para abrir cada libro
        val btnLiberLXV = findViewById<Button>(R.id.btnLiberLXV)
        val btnLiberVII = findViewById<Button>(R.id.btnLiberVII)
        val btnLiberSamekh = findViewById<Button>(R.id.btnLiberSamekh)
        val btnLiberV = findViewById<Button>(R.id.btnLiberV)

        // Navegar a las actividades correspondientes de cada libro
        btnLiberLXV.setOnClickListener {
            startActivity(Intent(this, LiberLXVActivity::class.java))
        }
        btnLiberVII.setOnClickListener {
            startActivity(Intent(this, LiberVIIActivity::class.java))
        }
        btnLiberSamekh.setOnClickListener {
            startActivity(Intent(this, LiberSamekhActivity::class.java))
        }
        btnLiberV.setOnClickListener {
            startActivity(Intent(this, LiberVActivity::class.java))
        }
    }
}
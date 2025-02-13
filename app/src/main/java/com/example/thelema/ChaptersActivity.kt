package com.example.thelema

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ListView

class ChaptersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapters)

        val listView = findViewById<ListView>(R.id.listView)

        val data = listOf(
            Pair("Capítulo 1", "Descripción del capítulo 1"),
            Pair("Capítulo 2", "Descripción del capítulo 2"),
            Pair("Capítulo 3", "Descripción del capítulo 3")
        )

        val adapter = MiAdaptador(this, data)
        listView.adapter = adapter
    }
}
package com.example.thelema

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class VerseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verse)

        val bookName = intent.getStringExtra("bookName")
        val chapterName = intent.getStringExtra("chapterName")
        val verseText = intent.getStringExtra("verseText") // Only verseText is used

        val chapterTitleTextView = findViewById<TextView>(R.id.chapterTitleTextView)
        chapterTitleTextView.text = String.format(
            getString(R.string.chapter_title_format),
            getString(R.string.book_title, bookName),
            getString(R.string.chapter_title, chapterName)
        )

        val verseTextView = findViewById<TextView>(R.id.verseTextView)
        verseTextView.text = verseText
    }
}
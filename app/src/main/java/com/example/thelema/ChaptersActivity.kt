package com.example.thelema

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ChapterActivity : AppCompatActivity() {

    private lateinit var versesContainer: LinearLayout
    private lateinit var chapterTitleTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter)

        chapterTitleTextView = findViewById(R.id.chapterTitleTextView)
        versesContainer = findViewById(R.id.versesContainer)

        val bookName = intent.getStringExtra("bookName")
        val chapterName = intent.getStringExtra("chapterName")

        chapterTitleTextView.text = String.format(
            getString(R.string.chapter_title_format),
            getString(R.string.book_title, bookName),
            getString(R.string.chapter_title, chapterName)
        )

        // ***Correct way to retrieve data from the Bundle***
        val bundle = intent.getBundleExtra("chapterData") ?: Bundle()  // Get the bundle
        val chapterData = mutableMapOf<String, String>()
        bundle.keySet().forEach { verseName ->
            val verseText = bundle.getString(verseName)
            if (verseText != null) {
                chapterData[verseName] = verseText
            }
        }


        versesContainer.removeAllViews() // Clear previous verses

        chapterData.forEach { (verseName, verseText) ->  // Use chapterData here
            val verseButton = Button(this).apply {
                text = verseName
                setOnClickListener {
                    val intent = Intent(this@ChapterActivity, VerseActivity::class.java)
                    intent.putExtra("bookName", bookName)
                    intent.putExtra("chapterName", chapterName)
                    intent.putExtra("verseText", verseText) // Pass verseText
                    startActivity(intent)
                }
            }
            versesContainer.addView(verseButton)
        }
    }
}
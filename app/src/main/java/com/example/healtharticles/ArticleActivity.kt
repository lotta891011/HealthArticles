package com.example.healtharticles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.healtharticles.R

class ArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.article_view)
        val imageView: ImageView = findViewById(R.id.elementImg1)
        val titleView: TextView = findViewById(R.id.title1)
        val contentView : TextView = findViewById(R.id.content1)
        val extras = intent.extras
        val imageId = extras?.getInt("image")
        val title = extras?.getString("title")
        val content = extras?.getString("content")


        if (imageId != null) {
            imageView.setImageResource(imageId)
        }
        titleView.text=title
        contentView.text=content
    }
}
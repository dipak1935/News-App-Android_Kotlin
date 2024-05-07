package com.example.newsapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextClock
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_news_detail)

        val heading=intent.getStringExtra("heading")
        val imageId=intent.getIntExtra("imageId",R.drawable.img1)
        val newsContent=intent.getStringExtra("newsContent")

        val headingTextView=findViewById<TextView>(R.id.newsHeading)
        val headingImageView=findViewById<ImageView>(R.id.newsImage)
        val contentTextView=findViewById<TextView>(R.id.newsContent)


        headingTextView.text=heading
        headingImageView.setImageResource(imageId)
        contentTextView.text=newsContent



    }
}
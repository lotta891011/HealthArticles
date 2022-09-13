package com.example.healtharticles.model

import androidx.annotation.DrawableRes

data class Article(
    @DrawableRes val imageResourceId: Int,
    val title: String,
    val content:String)

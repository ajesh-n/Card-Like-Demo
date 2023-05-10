package com.example.cardlikedemo

data class Post(
    val id: String,
    val title: String,
    val content: String,
    val imageUrl: String,
    var isLiked: Boolean = false
)

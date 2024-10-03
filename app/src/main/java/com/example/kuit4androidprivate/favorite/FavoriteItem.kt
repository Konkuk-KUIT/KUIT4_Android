package com.example.kuit4androidprivate.favorite

data class FavoriteItem(
    val name: String,
    val score: String,
    val reviewCount: String,
    val image: Int,
    var isFavorite: Boolean = false
)


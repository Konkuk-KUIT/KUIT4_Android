package com.example.kuit4androidprivate.model

data class MenuData(
    val restaurantName: String,
    val eta: String,
    val imageUrl: String? = null,
    val imgId: Int? = null,
    val rating: String,
    val totalReviews: String
)

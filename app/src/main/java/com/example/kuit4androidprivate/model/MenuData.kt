package com.example.kuit4androidprivate.model

import java.io.Serializable

data class MenuData(
    val title: String,
    val time: String,
    val imageUrl: String,
    val reviewScore: String,
    val reviewCount: String
) : Serializable

package com.example.kuit4androidprivate.model

import java.io.Serializable
import java.net.URL

data class MenuData(
    val title: String,
    val time: String,
    val rate: String,
    val number: String,
    val imageUrl: String
) : Serializable
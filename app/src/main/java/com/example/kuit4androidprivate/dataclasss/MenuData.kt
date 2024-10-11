package com.example.kuit4androidprivate.dataClass

import java.io.Serializable

data class MenuData(
    val title: String,
    val time: String,
    val rate: String,
    val number: String,
    val imageUrl: String
) : Serializable
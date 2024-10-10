package com.example.kuit4androidprivate.model

data class MenuData(
    val imageUrl : String,
    val title: String,
    val time: String,
    val review: String,
    val count : String,
    var bookmark: Boolean = false

)

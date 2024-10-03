package com.example.kuit4androidprivate.model

data class MenuLatelyData(
    val imageUrl : String,
    val title : String,
    val time : String,
    val score : String,
    val num : String,
    var favorite : Boolean = false
)

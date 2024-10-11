package com.example.kuit4androidprivate.model

import java.io.Serializable

data class MenuData(
    val imgUrl: String,
    val name: String,
    val time: String,
    val ratingNumber: String,
    val visitNumber: String,
    var isFavorite: Boolean
) : Serializable {

}

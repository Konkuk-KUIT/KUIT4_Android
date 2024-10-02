package com.example.kuit4androidprivate.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MenuData(
    val restaurantName: String,
    val eta: String,
    val imgUrl: String? = null,
    val imgId: Int? = null,
    val rating: String,
    val totalReviews: String,
    var isFavorite: Boolean? = false,
):Parcelable

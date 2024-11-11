package com.example.kuit4androidprivate.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class MenuData(
    val restaurantName: String,
    val eta: String,
    val imgUrl: String? = null,
    val imgId: Int? = null,
    val rating: String,
    val totalReviews: String,
    var isFavorite: Boolean? = false,
):Parcelable{
    @PrimaryKey(autoGenerate = true) var id: Long = 0
}

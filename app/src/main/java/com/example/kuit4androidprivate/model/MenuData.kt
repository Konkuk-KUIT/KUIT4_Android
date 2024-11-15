package com.example.kuit4androidprivate.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "MenuData")
data class MenuData(
    val imgUrl: String,
    val name: String,
    val time: String,
    val ratingNumber: String,
    val visitNumber: String,
    var isFavorite: Boolean
) : Serializable{
    @PrimaryKey(autoGenerate = true)var id: Long = 0
}


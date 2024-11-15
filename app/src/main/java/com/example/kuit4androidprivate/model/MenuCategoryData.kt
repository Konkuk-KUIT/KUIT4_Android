package com.example.kuit4androidprivate.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MenuCategoryData(
    val title: String,
    val imageUrl: Int
){
    @PrimaryKey(autoGenerate = true)var id: Long = 0
}

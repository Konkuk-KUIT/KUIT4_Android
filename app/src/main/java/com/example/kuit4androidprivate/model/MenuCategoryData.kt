package com.example.kuit4androidprivate.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MenuCategoryData(
    val categoryName: String,
    val categoryImage: Int
){
    @PrimaryKey(autoGenerate = true) var id: Long = 0
}

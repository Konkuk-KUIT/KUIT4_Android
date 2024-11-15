package com.example.kuit4androidprivate.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MenuCategoryData(
    val image:Int,
    val name:String
) {
    @PrimaryKey(autoGenerate = true) var id: Long = 0
}
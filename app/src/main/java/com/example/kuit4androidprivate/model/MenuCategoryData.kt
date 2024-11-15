package com.example.kuit4androidprivate.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "menu_category")
data class MenuCategoryData(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val imageRes: Int
)

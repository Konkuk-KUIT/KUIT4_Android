package com.example.kuit4androidprivate.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "menu_data")
data class MenuData(
    val name: String,
    val score: String,
    val reviewCount: String,
    val imageUrl: String
) : Parcelable{
    @PrimaryKey(autoGenerate = true) var id: Long = 0
}

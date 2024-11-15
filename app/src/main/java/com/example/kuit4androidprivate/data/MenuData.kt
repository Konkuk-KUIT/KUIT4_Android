package com.example.kuit4androidprivate.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class MenuData(
    val image:Int,
    val name:String,
    val score:String,
    val review:String,
    val minute:String
) : Serializable {
    @PrimaryKey(autoGenerate = true) var id: Long = 0
}

package com.example.kuit4androidprivate.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MenuLatelyData(
    val imageUrl : String,
    val title : String,
    val time : String,
    val score : String,
    val num : String,
    var favorite : Boolean = false
){
    @PrimaryKey(autoGenerate = true) var id : Long = 0  /// 기본 키
}


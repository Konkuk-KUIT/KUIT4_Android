package com.example.kuit4androidprivate.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity   // entity로 쓰겟다
data class MenuCategoryData(
    val title : String,
    val image : Int
){
    @PrimaryKey(autoGenerate = true) var id : Long = 0  /// 기본 키
}

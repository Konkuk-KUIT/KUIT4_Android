package com.example.kuit4androidprivate.data

import java.io.Serializable

data class MenuData(
    val image:Int,
    val name:String,
    val score:String,
    val review:String,
    val minute:String
) : Serializable

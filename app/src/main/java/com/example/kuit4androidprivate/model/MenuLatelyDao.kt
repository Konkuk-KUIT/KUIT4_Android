package com.example.kuit4androidprivate.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MenuLatelyDao {
    @Insert
    fun insert(menuLatelyData : MenuLatelyData)

    @Update
    fun update(menuLatelyData: MenuLatelyData)

    @Delete
    fun delete(menuLatelyData: MenuLatelyData)

    @Query("SELECT * FROM MenuLatelyData")
    fun getAll(): List<MenuLatelyData>

}
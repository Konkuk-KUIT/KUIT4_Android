package com.example.kuit4androidprivate.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MenuDao {
    @Insert
    fun insert(menuData: MenuData)

    @Insert
    fun insertAll(menuData: List<MenuData>)

    @Update
    fun update(menuData: MenuData)

    @Delete
    fun delete(menuData: MenuData)

    @Query("SELECT * FROM MenuData")
    fun getAll(): List<MenuData>
}
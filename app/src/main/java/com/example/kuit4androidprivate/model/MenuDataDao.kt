package com.example.kuit4androidprivate.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MenuDataDao {
    @Insert
    suspend fun insert(menuData: MenuData)

    @Update
    suspend fun update(menuData: MenuData)

    @Delete
    suspend fun delete(menuData: MenuData)

    @Query("SELECT * FROM MenuData")
    suspend fun getAll(): List<MenuData>
}
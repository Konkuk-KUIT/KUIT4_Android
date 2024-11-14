package com.example.kuit4androidprivate.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MenuCategoryDao {
    @Insert
    suspend fun insert(menuCategoryData: MenuCategoryData)

    @Update
    suspend fun update(menuCategoryData: MenuCategoryData)

    @Delete
    suspend fun delete(menuCategoryData: MenuCategoryData)

    @Query("SELECT * FROM MenuCategoryData")
    suspend fun getAll(): List<MenuCategoryData>
}

package com.example.kuit4androidprivate.model

import android.view.Menu
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MenuCategoryDao {
    @Insert
    fun insert(menuCategoryData: MenuCategoryData)

    @Update
    fun update(menuCategoryData: MenuCategoryData)

    @Delete
    fun delete(menuCategoryData: MenuCategoryData)

    @Query("SELECT * FROM MenuCategoryData")
    fun getAll(): List<MenuCategoryData>

}
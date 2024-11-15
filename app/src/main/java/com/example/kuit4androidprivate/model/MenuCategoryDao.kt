package com.example.kuit4androidprivate.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MenuCategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(category: MenuCategoryData)

    @Query("SELECT * FROM menu_category")
    suspend fun getAllCategories(): List<MenuCategoryData>

    @Query("SELECT COUNT(*) FROM menu_category")
    suspend fun getCategoryCount(): Int

}

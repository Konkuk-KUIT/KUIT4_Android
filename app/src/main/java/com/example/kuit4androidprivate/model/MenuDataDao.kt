package com.example.kuit4androidprivate.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MenuDataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(menuData: MenuData)

    @Query("SELECT * FROM menu_data")
    suspend fun getAllMenus(): List<MenuData>
}

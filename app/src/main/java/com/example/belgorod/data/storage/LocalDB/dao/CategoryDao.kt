package com.example.belgorod.data.storage.LocalDB.dao

import androidx.room.*
import com.example.belgorod.data.storage.LocalDB.entity.CategoryModel

@Dao
interface CategoryDao {

    @Query("SELECT * FROM CategoryModel")
    suspend fun get(): List<CategoryModel>

    @Insert
    suspend fun insert(category: CategoryModel)

    @Delete
    suspend fun delete(category: CategoryModel)

    @Update
    suspend fun update(genre: CategoryModel)
}
package com.example.belgorod.data.storage.LocalDB.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.belgorod.data.storage.LocalDB.entity.ObjectModel

@Dao
interface ObjectDao {

    @Query("SELECT * FROM ObjectModel WHERE category = :category")
    suspend fun getObjects(category: String): List<ObjectModel>

    @Query("SELECT * FROM ObjectModel")
    suspend fun getAllObjects(): List<ObjectModel>

    @Insert
    suspend fun insert(category: ObjectModel)

    @Query("DELETE FROM ObjectModel")
    suspend fun delete()

    @Update
    suspend fun update(genre: ObjectModel)
}
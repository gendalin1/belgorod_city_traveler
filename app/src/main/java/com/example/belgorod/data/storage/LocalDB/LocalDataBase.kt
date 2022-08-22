package com.example.belgorod.data.storage.LocalDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.belgorod.data.storage.LocalDB.dao.CategoryDao
import com.example.belgorod.data.storage.LocalDB.dao.ObjectDao
import com.example.belgorod.data.storage.LocalDB.entity.CategoryModel
import com.example.belgorod.data.storage.LocalDB.entity.ObjectModel

@Database(
    entities = [CategoryModel::class, ObjectModel::class], version = 1
)
abstract class LocalDataBase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun objectDao(): ObjectDao

}
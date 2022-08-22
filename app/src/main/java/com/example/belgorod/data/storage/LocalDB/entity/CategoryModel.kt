package com.example.belgorod.data.storage.LocalDB.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CategoryModel(
    @PrimaryKey
    var name: String,
    var image_URL:String,
    var discount: Int
)
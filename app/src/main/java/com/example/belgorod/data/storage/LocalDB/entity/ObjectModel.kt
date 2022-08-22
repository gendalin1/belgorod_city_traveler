package com.example.belgorod.data.storage.LocalDB.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey




@Entity(
    foreignKeys = arrayOf (
        ForeignKey(
            entity = CategoryModel::class,
            parentColumns = arrayOf("name"),
            childColumns = arrayOf("category"),
            onDelete = ForeignKey.CASCADE
        )
    )
)
data class ObjectModel(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var image_URL:String,
    var discount: Int,
    var category:String,
    var time: Int
)
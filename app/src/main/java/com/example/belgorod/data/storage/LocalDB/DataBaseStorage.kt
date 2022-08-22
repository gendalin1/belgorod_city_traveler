package com.example.belgorod.data.storage.LocalDB

import com.example.belgorod.app.sealed.MainReturn
import com.example.belgorod.data.storage.models.CategoryData
import com.example.belgorod.data.storage.models.ObjectData
import com.example.belgorod.domain.module.CategoryDomain
import com.example.belgorod.domain.module.ObjectDomain

interface DataBaseStorage {
    suspend fun getCategory():MainReturn
    suspend fun InsertCategory(list: List<CategoryData>)
    suspend fun getObjects(category: String):MainReturn
    suspend fun InsertObject(list: List<ObjectData>)
}
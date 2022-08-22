package com.example.belgorod.domain.repository

import com.example.belgorod.app.sealed.MainReturn
import com.example.belgorod.data.storage.LocalDB.entity.CategoryModel
import com.example.belgorod.data.storage.LocalDB.entity.ObjectModel
import com.example.belgorod.domain.module.CategoryDomain
import com.example.belgorod.domain.module.ObjectDomain

interface MenuRepository {
    suspend fun getCategory():MainReturn
    suspend fun InsertCategory(list: List<CategoryDomain>)
    suspend fun getObject(category: String):MainReturn
    suspend fun InsertObject(list: List<ObjectDomain>)
}
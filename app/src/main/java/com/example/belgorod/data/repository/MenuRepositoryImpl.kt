package com.example.belgorod.data.repository

import com.example.belgorod.app.sealed.CategoryList
import com.example.belgorod.app.sealed.MainReturn
import com.example.belgorod.app.sealed.ObjectList
import com.example.belgorod.app.toData
import com.example.belgorod.app.toDomain
import com.example.belgorod.data.storage.LocalDB.DataBaseStorage
import com.example.belgorod.data.storage.models.CategoryData
import com.example.belgorod.data.storage.models.ObjectData
import com.example.belgorod.domain.module.CategoryDomain
import com.example.belgorod.domain.module.ObjectDomain
import com.example.belgorod.domain.repository.MenuRepository
import javax.inject.Inject

class MenuRepositoryImpl @Inject constructor(
    private val dataBaseStorage: DataBaseStorage
) : MenuRepository
{
    override suspend fun getCategory(): MainReturn {
        dataBaseStorage.getCategory().let {
            return when(it){
                is CategoryList.CategoryReceived ->{
                    val categoryList = ArrayList<CategoryDomain>()
                    it.categoryList.forEach { i-> categoryList.add(i.toDomain()) }
                    CategoryList.CategoryDomainReceived(categoryList)
                    }
                else -> it
            }
        }
    }

    override suspend fun InsertCategory(list: List<CategoryDomain>) {
        val listCategory = ArrayList<CategoryData>()
        list.forEach { i-> listCategory.add(i.toData()) }
        dataBaseStorage.InsertCategory(listCategory)
    }

    override suspend fun getObject(category: String): MainReturn {
        dataBaseStorage.getObjects(category).let {
            return when(it){
                is ObjectList.ObjectReceived ->{
                    val objectList = ArrayList<ObjectDomain>()
                    it.objectList.forEach { i-> objectList.add(i.toDomain()) }
                    ObjectList.ObjectDomainReceived(objectList)
                }
                else -> it
            }
        }
    }

    override suspend fun InsertObject(list: List<ObjectDomain>) {
        val listObject = ArrayList<ObjectData>()
        list.forEach { i-> listObject.add(i.toData()) }
        dataBaseStorage.InsertObject(listObject)
    }
}
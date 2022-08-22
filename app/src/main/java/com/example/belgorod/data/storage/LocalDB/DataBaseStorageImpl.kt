package com.example.belgorod.data.storage.LocalDB

import android.util.Log
import com.example.belgorod.app.sealed.CategoryList
import com.example.belgorod.app.sealed.MainReturn
import com.example.belgorod.app.sealed.ObjectList
import com.example.belgorod.app.toCategoryDB
import com.example.belgorod.app.toData
import com.example.belgorod.app.toObjectBD
import com.example.belgorod.data.storage.LocalDB.dao.CategoryDao
import com.example.belgorod.data.storage.LocalDB.dao.ObjectDao
import com.example.belgorod.data.storage.models.CategoryData
import com.example.belgorod.data.storage.models.ObjectData
import javax.inject.Inject

class DataBaseStorageImpl @Inject constructor(
    private val categoryDao: CategoryDao,
    private val objectDao: ObjectDao,
) : DataBaseStorage {

    override suspend fun getCategory(): MainReturn {
        categoryDao.get().let{
            return when(it.size){
                0 -> MainReturn.nullobject
                else -> {
                    val categoryList = ArrayList<CategoryData>()
                    it.forEach { i->
                        categoryList.add(i.toData())
                    }
                    CategoryList.CategoryReceived(categoryList)


                }
            }
        }
    }

    override suspend fun InsertCategory(list: List<CategoryData>) {
         list.forEach {
             categoryDao.insert(it.toCategoryDB())
         }
    }

    override suspend fun getObjects(category: String): MainReturn {
        objectDao.getObjects(category).let{
            return when(it.size){
                0 -> MainReturn.nullobject
                else -> {
                    val objectList = ArrayList<ObjectData>()
                    it.forEach {i-> objectList.add(i.toData())}
                    ObjectList.ObjectReceived(objectList)
                }
            }
        }

    }

    override suspend fun InsertObject(list: List<ObjectData>) {
        var i = 1
        objectDao.getAllObjects().let{
            i = it.size + 1
        }
        list.forEach {
            objectDao.insert(it.toObjectBD(i))
            i += 1
        }
    }
}
package com.example.belgorod.domain.Interactors

import android.util.Log
import com.example.belgorod.app.sealed.CategoryList
import com.example.belgorod.app.sealed.MainReturn
import com.example.belgorod.app.sealed.ObjectList
import com.example.belgorod.app.toDomain
import com.example.belgorod.app.toPresentation
import com.example.belgorod.data.storage.LocalDB.entity.CategoryModel
import com.example.belgorod.domain.module.CategoryDomain
import com.example.belgorod.domain.module.ObjectDomain
import com.example.belgorod.domain.repository.MenuRepository
import com.example.belgorod.presentation.Interactors.MenuInteractor
import com.example.belgorod.presentation.module.CategoryPresentation
import com.example.belgorod.presentation.module.ObjectPresentation
import javax.inject.Inject

class MenuInteractorImpl @Inject constructor(
    private val menuRepository: MenuRepository
)  : MenuInteractor {

    override suspend fun getCategory(): MainReturn {
        menuRepository.getCategory().let {
            return when(it){
                is CategoryList.CategoryDomainReceived ->{
                    val categoryList = ArrayList<CategoryPresentation>()
                    it.categoryList.forEach { i-> categoryList.add(i.toPresentation()) }
                    CategoryList.CategoryPresentationReceived(categoryList)
                }
                else -> it
            }
        }
    }

    override suspend fun InsertCategory(list: List<CategoryPresentation>) {
        val listCategory = ArrayList<CategoryDomain>()
        list.forEach { i-> listCategory.add(i.toDomain()) }
        menuRepository.InsertCategory(listCategory)
    }

    override suspend fun getObject(category: String): MainReturn {
        menuRepository.getObject(category).let {
            return when(it){
                is ObjectList.ObjectDomainReceived -> {
                    val objectList = ArrayList<ObjectPresentation>()
                    it.objectList.forEach { i-> objectList.add(i.toPresentation()) }
                    ObjectList.ObjectPresentationReceived(objectList)
                }
                else -> it
            }
        }
    }

    override suspend fun InsertObject(list: List<ObjectPresentation>) {
        val listObject = ArrayList<ObjectDomain>()
        list.forEach { i-> listObject.add(i.toDomain()) }
        menuRepository.InsertObject(listObject)
    }
}
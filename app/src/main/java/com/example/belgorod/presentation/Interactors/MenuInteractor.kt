package com.example.belgorod.presentation.Interactors

import com.example.belgorod.app.sealed.MainReturn
import com.example.belgorod.presentation.module.CategoryPresentation
import com.example.belgorod.presentation.module.ObjectPresentation

interface MenuInteractor {
    suspend fun getCategory(): MainReturn
    suspend fun InsertCategory(list: List<CategoryPresentation>)
    suspend fun getObject(category: String): MainReturn
    suspend fun InsertObject(list: List<ObjectPresentation>)
}
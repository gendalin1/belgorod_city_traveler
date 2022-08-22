package com.example.belgorod.app.sealed

import com.example.belgorod.data.storage.models.CategoryData
import com.example.belgorod.domain.module.CategoryDomain
import com.example.belgorod.presentation.module.CategoryPresentation

sealed class CategoryList: MainReturn() {
    class CategoryReceived(val categoryList: List<CategoryData>) : CategoryList()
    class CategoryDomainReceived(val categoryList: List<CategoryDomain>): CategoryList()
    class CategoryPresentationReceived(val categoryList: List<CategoryPresentation>): CategoryList()
}
package com.example.belgorod.app

import com.example.belgorod.data.storage.LocalDB.entity.CategoryModel
import com.example.belgorod.data.storage.LocalDB.entity.ObjectModel
import com.example.belgorod.data.storage.models.CategoryData
import com.example.belgorod.data.storage.models.NewsData
import com.example.belgorod.data.storage.models.ObjectData
import com.example.belgorod.domain.module.CategoryDomain
import com.example.belgorod.domain.module.NewsDomain
import com.example.belgorod.domain.module.ObjectDomain
import com.example.belgorod.presentation.module.CategoryPresentation
import com.example.belgorod.presentation.module.NewsPresentation
import com.example.belgorod.presentation.module.ObjectPresentation

fun NewsData.toDomain() = NewsDomain(
    title = this.title,
    description = this.description,
    imageUrl = this.imageUrl,
    link = this.link
)

fun NewsDomain.toPresentation(): NewsPresentation{
    var descriprion = ""
    this.description?.let { descriprion = it }
    return NewsPresentation(
        title = this.title,
        description = description,
        imageUrl = this.imageUrl,
        link = this.link
    )
}

fun CategoryModel.toData() = CategoryData(
    name = this.name,
    image_URL = this.image_URL,
    discount = this.discount
)

fun CategoryData.toDomain() = CategoryDomain(
    name = this.name,
    image_URL = this.image_URL,
    discount = this.discount
)

fun CategoryDomain.toPresentation() = CategoryPresentation(
    name = this.name,
    image_URL = this.image_URL,
    discount = this.discount
)

fun CategoryPresentation.toDomain() = CategoryDomain(
    name = this.name,
    image_URL = this.image_URL,
    discount = this.discount
)

fun CategoryDomain.toData()= CategoryData(
    name = this.name,
    image_URL = this.image_URL,
    discount = this.discount
)

fun CategoryData.toCategoryDB() = CategoryModel(
    name = this.name,
    image_URL = this.image_URL,
    discount = this.discount
)



fun ObjectModel.toData() = ObjectData(
    image_URL = this.image_URL,
    discount = this.discount,
    time = this.time,
    category = this.category
)

fun ObjectData.toDomain() = ObjectDomain(
    image_URL = this.image_URL,
    discount = this.discount,
    time = this.time,
    category = this.category
)

fun ObjectDomain.toPresentation() = ObjectPresentation(
    image_URL = this.image_URL,
    discount = this.discount,
    time = this.time,
    category = this.category
)

fun ObjectPresentation.toDomain()= ObjectDomain(
    image_URL = this.image_URL,
    discount = this.discount,
    time = this.time,
    category = this.category
)

fun ObjectDomain.toData()= ObjectData(
    image_URL = this.image_URL,
    discount = this.discount,
    time = this.time,
    category = this.category
)

fun ObjectData.toObjectBD(id: Int) = ObjectModel(
    id = id,
    image_URL = this.image_URL,
    discount = this.discount,
    time = this.time,
    category = this.category
)
package com.example.belgorod.domain.module

data class NewsDomain(
    val title: String,
    val description: String?,
    val link: String,
    val imageUrl: String?
    )
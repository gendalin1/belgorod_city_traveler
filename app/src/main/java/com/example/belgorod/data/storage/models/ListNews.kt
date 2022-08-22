package com.example.belgorod.data.storage.models

data class ListNews(
    val status: String,
    val totalResults: Long,
    val results: List<NewsData>,
    val nextPage: Int
)
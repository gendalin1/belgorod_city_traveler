package com.example.belgorod.data.storage.models
import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName

data class NewsData(
    val title: String,
    val link: String,
    val keywords: List<String>?,
    val creator: List<String>?,
    @SerializedName("video_url")
    val videoUrl: Any?,
    val description: String?,
    val content: Any?,
    val pubDate: String,
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("source_id")
    val sourceId: String,
    val country: List<String>,
    val category: List<String>,
    val language: String
)
package com.example.belgorod.data.storage.network

import com.example.belgorod.data.storage.models.ListNews
import retrofit2.Response
import retrofit2.http.*

interface NetworkRequests {
    @GET("news?")
    suspend fun getNews(
        @Query("apikey") key:String,
        @Query("country") country: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ):Response<ListNews>

    companion object {
        const val BASE_URL = "https://newsdata.io/api/1/"
        const val API_KEY = "pub_1028829a75e6a3138051d84b848d1c8e165b1"
    }
}
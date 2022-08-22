package com.example.belgorod.data.storage.network

import com.example.belgorod.app.sealed.MainReturn
import com.example.belgorod.data.storage.models.ListNews


interface NetworkStorage {

    suspend fun getNewsList(page: Int): MainReturn

}
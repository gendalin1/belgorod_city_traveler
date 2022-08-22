package com.example.belgorod.domain.repository

import com.example.belgorod.app.sealed.MainReturn
import com.example.belgorod.domain.module.NewsDomain

interface NewsRepository {
    suspend fun getNewsList(page:Int): MainReturn
}
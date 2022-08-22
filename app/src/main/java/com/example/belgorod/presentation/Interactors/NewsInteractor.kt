package com.example.belgorod.presentation.Interactors

import com.example.belgorod.app.sealed.MainReturn

interface NewsInteractor {
    suspend fun getNewsList(page:Int): MainReturn
}
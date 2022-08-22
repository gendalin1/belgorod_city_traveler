package com.example.belgorod.presentation.ui.News

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.belgorod.presentation.Interactors.NewsInteractor

class NewsViewModelFactory(
    val newsInteractor: NewsInteractor,
): ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T{
        return NewsViewModel(
            newsInteractor = newsInteractor
        ) as T
    }
}
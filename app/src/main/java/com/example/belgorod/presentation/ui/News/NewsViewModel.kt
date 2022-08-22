package com.example.belgorod.presentation.ui.News

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.belgorod.app.sealed.NewsList
import com.example.belgorod.presentation.Interactors.NewsInteractor
import com.example.belgorod.presentation.module.NewsPresentation
import kotlinx.coroutines.launch

class NewsViewModel(
    private val newsInteractor: NewsInteractor
) : ViewModel() {

    private var newsListLiveMutable = MutableLiveData<ArrayList<NewsPresentation>>()
    val newsListLive: LiveData<ArrayList<NewsPresentation>> = newsListLiveMutable

    fun getNewsList(page: Int) =
        viewModelScope.launch {
            newsInteractor.getNewsList(page).let {
                when (it) {
                    is NewsList.NewsPresentationReceived -> {
                        newsListLiveMutable.value = it.newsList as ArrayList<NewsPresentation>
                    }
                }
            }
        }
}
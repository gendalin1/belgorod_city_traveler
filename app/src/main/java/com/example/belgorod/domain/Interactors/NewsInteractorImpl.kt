package com.example.belgorod.domain.Interactors

import com.example.belgorod.app.sealed.MainReturn
import com.example.belgorod.app.sealed.NewsList
import com.example.belgorod.app.toPresentation
import com.example.belgorod.domain.repository.NewsRepository
import com.example.belgorod.presentation.Interactors.NewsInteractor
import com.example.belgorod.presentation.module.NewsPresentation
import javax.inject.Inject

class NewsInteractorImpl @Inject constructor(
    private val newsRepository: NewsRepository
)  : NewsInteractor {
    override suspend fun getNewsList(page: Int): MainReturn =
        newsRepository.getNewsList(page).let {
            when (it){
                is NewsList.NewsDomainReceived -> {
                    val listOfNews = ArrayList<NewsPresentation>()
                    it.newsList.forEach { i-> listOfNews.add(i.toPresentation()) }
                    NewsList.NewsPresentationReceived(listOfNews)
                }
                else -> it
            }
        }

}
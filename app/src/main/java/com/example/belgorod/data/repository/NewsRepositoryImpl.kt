package com.example.belgorod.data.repository

import android.util.Log
import com.example.belgorod.app.sealed.MainReturn
import com.example.belgorod.app.sealed.NewsList
import com.example.belgorod.app.toDomain
import com.example.belgorod.data.storage.network.NetworkStorage
import com.example.belgorod.domain.module.NewsDomain
import com.example.belgorod.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val networkStorage: NetworkStorage,
) : NewsRepository
{
    override suspend fun getNewsList(page:Int): MainReturn =
        networkStorage.getNewsList(page).let{
            when (it) {
                is NewsList.NewsReceived ->{
                    val listOfNews = ArrayList<NewsDomain>()
                    it.newsList.results.forEach { i -> listOfNews.add(i.toDomain()) }
                    NewsList.NewsDomainReceived(listOfNews)
                }
                else ->  it
            }
        }
}
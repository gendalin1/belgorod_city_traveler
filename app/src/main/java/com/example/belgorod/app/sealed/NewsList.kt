package com.example.belgorod.app.sealed

import com.example.belgorod.data.storage.models.ListNews
import com.example.belgorod.domain.module.NewsDomain
import com.example.belgorod.presentation.module.NewsPresentation

sealed class NewsList: MainReturn() {
    class NewsReceived(val newsList: ListNews) : NewsList()
    class NewsDomainReceived(val newsList: List<NewsDomain>): NewsList()
    class NewsPresentationReceived(val newsList: List<NewsPresentation>): NewsList()
}
package com.example.belgorod.data.storage.network
import android.util.Log
import com.example.belgorod.app.sealed.MainReturn
import com.example.belgorod.app.sealed.NewsList
import com.example.belgorod.data.storage.models.NewsData
import com.example.belgorod.data.storage.models.ListNews
import com.example.belgorod.data.storage.network.NetworkRequests.Companion.API_KEY
import javax.inject.Inject

class NetworkStorageImpl @Inject constructor(
    private val api: NetworkRequests
) : NetworkStorage {
    override suspend fun getNewsList(page: Int): MainReturn {
        api.getNews(API_KEY,"ru","ru",page).body().let{
            return when (it) {
                null -> MainReturn.nullobject
                else -> NewsList.NewsReceived(it)
            }
        }
    }

}
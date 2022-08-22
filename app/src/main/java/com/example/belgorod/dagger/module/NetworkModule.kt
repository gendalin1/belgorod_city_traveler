package com.example.belgorod.dagger.module

import com.example.belgorod.data.storage.network.NetworkRequests
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideApi(): NetworkRequests {
        val retrofit = Retrofit.Builder()
            .baseUrl(NetworkRequests.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create()
    }

}
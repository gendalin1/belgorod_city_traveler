package com.example.belgorod.dagger.module

import com.example.belgorod.data.repository.MenuRepositoryImpl
import com.example.belgorod.data.repository.NewsRepositoryImpl
import com.example.belgorod.data.storage.LocalDB.DataBaseStorage
import com.example.belgorod.data.storage.LocalDB.DataBaseStorageImpl
import com.example.belgorod.data.storage.network.NetworkStorage
import com.example.belgorod.data.storage.network.NetworkStorageImpl
import com.example.belgorod.domain.Interactors.NewsInteractorImpl
import com.example.belgorod.domain.Interactors.MenuInteractorImpl
import com.example.belgorod.domain.repository.MenuRepository
import com.example.belgorod.domain.repository.NewsRepository
import com.example.belgorod.presentation.Interactors.MenuInteractor
import com.example.belgorod.presentation.Interactors.NewsInteractor
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface DataBindsModule {

    @Binds
    @Singleton
    fun bindNetworkStorage(
        networkStorageImpl: NetworkStorageImpl
    ): NetworkStorage

    @Binds
    @Singleton
    fun bindDataBaseStorage(
        dataBaseStorageImpl: DataBaseStorageImpl
    ): DataBaseStorage

    @Binds
    @Singleton
    fun bindNewsRepository(
        newsRepositoryImpl: NewsRepositoryImpl
    ): NewsRepository

    @Binds
    @Singleton
    fun bindMenuRepository(
        menuRepositoryImpl: MenuRepositoryImpl
    ): MenuRepository

    @Binds
    @Singleton
    fun bindNewsInteractor(
        newsInteractorImpl: NewsInteractorImpl
    ): NewsInteractor

    @Binds
    @Singleton
    fun bindMenuInteractor(
        menuInteractorImpl: MenuInteractorImpl
    ): MenuInteractor
}
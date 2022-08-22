package com.example.belgorod.dagger.module

import android.content.Context
import androidx.room.Room
import com.example.belgorod.data.storage.LocalDB.LocalDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ContextModule::class])
class LocalDBModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context) = Room.databaseBuilder(
        context.applicationContext,
        LocalDataBase::class.java,
        "database"
    ).fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideCategoryDao(database: LocalDataBase) = database.categoryDao()

    @Provides
    @Singleton
    fun provideObjectDao(database: LocalDataBase) = database.objectDao()

}
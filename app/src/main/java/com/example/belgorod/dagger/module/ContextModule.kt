package com.example.belgorod.dagger.module

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ContextModule(
    private val context: Context
) {
    @Provides
    fun provideContext(): Context = context.applicationContext
}


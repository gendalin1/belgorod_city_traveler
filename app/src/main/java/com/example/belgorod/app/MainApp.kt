package com.example.belgorod.app

import android.app.Application
import android.content.Context
import com.example.belgorod.dagger.AppComponent
import com.example.belgorod.dagger.DaggerAppComponent
import com.example.belgorod.dagger.module.ContextModule

class MainApp : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .contextModule(ContextModule(applicationContext))
            .build()
    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is MainApp -> appComponent
        else -> this.applicationContext.appComponent
    }
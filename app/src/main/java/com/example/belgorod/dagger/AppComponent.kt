package com.example.belgorod.dagger

import com.example.belgorod.dagger.module.AppModule
import com.example.belgorod.dagger.module.ContextModule
import com.example.belgorod.presentation.Interactors.MenuInteractor
import com.example.belgorod.presentation.Interactors.NewsInteractor
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    val newsInteractor: NewsInteractor
    val menuInteractor: MenuInteractor
}
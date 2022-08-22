package com.example.belgorod.presentation.ui.Menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.belgorod.presentation.Interactors.MenuInteractor
import com.example.belgorod.presentation.Interactors.NewsInteractor
import com.example.belgorod.presentation.ui.News.NewsViewModel

class MenuViewModelFactory(
    val menuInteractor: MenuInteractor,
): ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T{
        return MenuViewModel(
            menuInteractor = menuInteractor
        ) as T
    }
}
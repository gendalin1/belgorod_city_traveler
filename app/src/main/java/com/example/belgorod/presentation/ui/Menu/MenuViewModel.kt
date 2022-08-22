package com.example.belgorod.presentation.ui.Menu

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.belgorod.app.sealed.CategoryList
import com.example.belgorod.app.sealed.ObjectList
import com.example.belgorod.presentation.Interactors.MenuInteractor
import com.example.belgorod.presentation.module.CategoryPresentation
import com.example.belgorod.presentation.module.ObjectPresentation
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MenuViewModel(
    private val menuInteractor: MenuInteractor
) : ViewModel() {
    private var categoryListLiveMutable = MutableLiveData<List<CategoryPresentation>>()
    val categoryListLive: LiveData<List<CategoryPresentation>> = categoryListLiveMutable

    private var objectListLiveMutable = MutableLiveData<List<ObjectPresentation>>()
    val objectListLive: LiveData<List<ObjectPresentation>> = objectListLiveMutable

    fun getCategoryList() =
        viewModelScope.launch {
            menuInteractor.getCategory().let {
                when(it) {
                    is CategoryList.CategoryPresentationReceived->{
                        categoryListLiveMutable.value = it.categoryList as ArrayList<CategoryPresentation>
                    }
                    else ->{
                        val categoryList =listOf(
                            CategoryPresentation(
                                name = "Бизнес",
                                image_URL = "https://www.pngitem.com/pimgs/m/75-754006_businessman-earnings-income-profit-salesman-statistics-businessman-icon.png",
                                discount = 11
                            ),
                            CategoryPresentation(
                                name = "Техника",
                                image_URL = "https://pic.onlinewebfonts.com/svg/img_352706.png",
                                discount = 3
                            ),
                            CategoryPresentation(
                                name = "Музыка",
                                image_URL = "https://w7.pngwing.com/pngs/759/249/png-transparent-itunes-store-computer-icons-music-itunes-text-musician-apple-music.png",
                                discount = 16
                            ),
                            CategoryPresentation(
                                name = "Еда",
                                image_URL = "https://freepngclipart.com/download/logo/83109-meal.-cash-bitcoin-cryptocurrency-ethereum-logo-cactaceae.png",
                                discount = 10
                            ),
                            CategoryPresentation(
                                name = "Машины",
                                image_URL = "https://static.tildacdn.com/tild6237-3166-4265-b966-383966393339/photo.jpg",
                                discount = 67
                            ),
                            CategoryPresentation(
                                name = "Книги",
                                image_URL = "https://img2.freepng.ru/20180328/sfq/kisspng-computer-icons-book-book-cover-5abb43f16ee8e1.0638341715222220654543.jpg",
                                discount = 13
                            ),
                            CategoryPresentation(
                                name = "Фильмы",
                                image_URL = "https://avatars.mds.yandex.net/i?id=ee9d4ce6771652f74b4d92278ace150e-3692823-images-thumbs&n=13",
                                discount = 43
                            )
                        )
                        categoryListLiveMutable.value = categoryList
                        menuInteractor.InsertCategory(categoryList)
                    }
                }
            }
        }

    fun getObjectList(category:String) =
        viewModelScope.launch {
            menuInteractor.getObject(category).let {
                when(it) {
                    is ObjectList.ObjectPresentationReceived->{
                        objectListLiveMutable.value = it.objectList as ArrayList<ObjectPresentation>
                    }
                    else -> {
                        val objectList =listOf(
                            ObjectPresentation(
                                category = category,
                                image_URL = "https://avatars.mds.yandex.net/i?id=976b4a41f37900890d0e776d598d69e0-5319478-images-thumbs&n=13",
                                discount = 48,
                                time = 13
                            ),
                            ObjectPresentation(
                                category = category,
                                image_URL = "https://sun6-21.userapi.com/s/v1/if1/l92e4MU6_XdIFuxSLr_pX6_BK9DfB4T0mFH_v8xJBrqOgAVEAsmnb1k5tazGonsdO_vRQoBg.jpg?size=400x400&quality=96&crop=0,0,1200,1200&ava=1",
                                discount = 31,
                                time = 30
                            ),
                            ObjectPresentation(
                                category = category,
                                image_URL = "https://gidsy.ru/tc/1501.png",
                                discount = 92,
                                time = 30
                            )
                        )
                        objectListLiveMutable.value = objectList
                        menuInteractor.InsertObject(objectList)
                    }
                }
            }
        }

}
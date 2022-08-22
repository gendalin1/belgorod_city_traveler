package com.example.belgorod

import android.os.Bundle
import android.util.TypedValue
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.belgorod.databinding.ActivityMainBinding
import com.example.belgorod.presentation.Adapters.ViewPagerAdapter
import com.example.belgorod.presentation.ui.Menu.MenuFragment
import com.example.belgorod.presentation.ui.News.NewsFragment
import com.example.belgorod.presentation.ui.Profile.ProfileFragment
import com.example.belgorod.presentation.ui.Shop.ShopFragment


const val APP_PREFERENCES = "APP_PREFERENCES"
const val CASH = "CASH"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navView = binding.navView

        val pager = binding.viewpager
        pager.isUserInputEnabled = false


        val fragments = listOf<Fragment>(
            NewsFragment(),
            MenuFragment(),
            ProfileFragment(),
            ShopFragment()
        )

        pager.adapter = ViewPagerAdapter(fragments, supportFragmentManager, lifecycle)
        pager.currentItem = 0
        navView.isItemHorizontalTranslationEnabled = true


        navView.setOnItemSelectedListener {
            val id = it.itemId
            val displayMetrics = resources.displayMetrics
            navView.itemIconSize =
                TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24f, displayMetrics).toInt()
            if (id == R.id.navigation_news) {
                pager.currentItem = 0
            }
            if (id == R.id.navigation_menu)
                pager.currentItem = 1
            if (id == R.id.navigation_person)
                pager.currentItem = 2
            if (id == R.id.navigation_shop)
                pager.currentItem = 3
            return@setOnItemSelectedListener true
        }

    }

}




package com.example.belgorod.presentation.ui.Shop

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.belgorod.APP_PREFERENCES
import com.example.belgorod.CASH
import com.example.belgorod.databinding.FragmentShopBinding
import com.example.belgorod.presentation.Adapters.HorizontalSpaceItemDecoration
import com.example.belgorod.presentation.Adapters.ShopAdapter
import com.example.belgorod.presentation.Adapters.VerticalSpaceItemDecoration
import com.example.belgorod.presentation.module.ShopPresentation



class ShopFragment : Fragment() {

    var shared: SharedPreferences? = null
    lateinit var binding: FragmentShopBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        shared = activity?.getSharedPreferences(APP_PREFERENCES,Context.MODE_PRIVATE)
        val binding = FragmentShopBinding.inflate(inflater, container, false)

        binding.recyclerView.addItemDecoration(VerticalSpaceItemDecoration(5* requireContext().resources.displayMetrics.density))
        binding.recyclerView.addItemDecoration(HorizontalSpaceItemDecoration(8* requireContext().resources.displayMetrics.density))

        val gridLayoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        binding.recyclerView.layoutManager = gridLayoutManager
        binding.cash.text = shared?.getInt(CASH,10000).toString()

        val shopList = listOf<ShopPresentation>(
            ShopPresentation(
                description = "Турник, брусья Absolute Champion Профи (с переворотом) черный",
                imageUrl = "https://avatars.mds.yandex.net/get-mpic/4458042/img_id906484162008908578.jpeg/x248_trim",
                price = 2800,
                link = "https://market.yandex.ru/catalog--detskii-sport/65828/list?srnum=2398&was_redir=1&rt=9&rs=eJwzUg9grGLheDZHYhajzMXGC_sv7LvYcLHpwo4Ley9surD1wl4gewNQpAcAocMXvw%2C%2C&text=спортинвентарь"
            ),
            ShopPresentation(
                description = "Спортивный комплекс на базе шведской стенки Формула здоровья Start mini, красный/радуга",
                imageUrl = "https://avatars.mds.yandex.net/get-mpic/4345877/img_id1681365775777941663.jpeg/x248_trim",
                price = 6050,
                link = "https://market.yandex.ru/catalog--detskii-sport/65828/list?srnum=2398&was_redir=1&rt=9&rs=eJwzUg9grGLheDZHYhajzMXGC_sv7LvYcLHpwo4Ley9surD1wl4gewNQpAcAocMXvw%2C%2C&text=спортинвентарь"
            ),
            ShopPresentation(
                description = "56304 Игрушечный спортинвентарь 'Набор для бокса'(SMOK)",
                imageUrl = "https://avatars.mds.yandex.net/get-mpic/4835126/img_id5401779655415388919.jpeg/x248_trim",
                price = 2020,
                link = "https://market.yandex.ru/catalog--detskii-sport/65828/list?srnum=2398&was_redir=1&rt=9&rs=eJwzUg9grGLheDZHYhajzMXGC_sv7LvYcLHpwo4Ley9surD1wl4gewNQpAcAocMXvw%2C%2C&text=спортинвентарь"
            )
        )

        binding.recyclerView.adapter = ShopAdapter(requireContext(),shopList, object : OnBuyItem{
            override fun OnBuy(price: Int) {
                val cash = binding.cash.text.toString().toInt()
                val sum:Int
                if (cash - price >= 0)
                   sum  = (cash - price)
                else {
                    Toast.makeText(
                        requireContext(),
                        "У вас не хватило средств. Добавляем 10000 баллов к вашему счёту",
                        Toast.LENGTH_SHORT
                    ).show()
                    sum = (cash+10000)
                }
                binding.cash.text = sum.toString()
                shared?.edit()?.putInt(CASH,binding.cash.text.toString().toInt())?.apply()
            }
        })

        return binding.root
    }

}
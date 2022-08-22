package com.example.belgorod.presentation.Adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.belgorod.R
import com.example.belgorod.databinding.ShopItemBinding
import com.example.belgorod.presentation.module.ShopPresentation
import com.example.belgorod.presentation.ui.Shop.OnBuyItem

class ShopAdapter(
    val context: Context,
    val list: List<ShopPresentation>,
    val onBuyItem: OnBuyItem
) : RecyclerView.Adapter<ShopAdapter.MyViewHolder>() {
    inner class MyViewHolder(view: ShopItemBinding) : RecyclerView.ViewHolder(view.root) {
        val description = view.description
        var image = view.image
        val price = view.price
        val buy = view.buy
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = ShopItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = list[position]
        holder.description.text = data.description
        holder.price.text = data.price.toString()
        Glide.with(context)
            .load(data.imageUrl)
            .fitCenter()
            .placeholder(R.drawable.no_shop_image)
            .error(R.drawable.no_shop_image)
            .into(holder.image)


        holder.description.setOnClickListener{
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(data.link))
            context.startActivity(browserIntent)
        }

        holder.buy.setOnClickListener{
            onBuyItem.OnBuy(data.price)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }
}
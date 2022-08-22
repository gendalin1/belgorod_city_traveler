package com.example.belgorod.presentation.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.belgorod.databinding.NewsItemBinding
import com.example.belgorod.databinding.ShopItemBinding
import com.example.belgorod.databinding.SliderItemBinding
import com.smarteist.autoimageslider.SliderViewAdapter

class SliderAdapter(
    val context: Context,
    val list: List<String>
):SliderViewAdapter<SliderAdapter.SliderAdapterVH>() {

    inner class SliderAdapterVH(view: SliderItemBinding) : SliderViewAdapter.ViewHolder(view.root) {
        var image = view.image
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH {
        val itemView = SliderItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SliderAdapterVH(itemView)
    }

    override fun onBindViewHolder(holder: SliderAdapterVH, position: Int) {
        val data = list[position]
        Glide.with(context)
            .load(data)
            .fitCenter()
            .into(holder.image)
    }
}
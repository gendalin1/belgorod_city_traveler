package com.example.belgorod.presentation.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.belgorod.R
import com.example.belgorod.databinding.CategoryItemBinding
import com.example.belgorod.presentation.module.CategoryPresentation
import com.example.belgorod.presentation.ui.Menu.OnClickCategory

class CategoryAdapter(
    val context: Context,
    val list: List<CategoryPresentation>,
    val onClickCategory: OnClickCategory
) : RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {
    inner class MyViewHolder(view: CategoryItemBinding) : RecyclerView.ViewHolder(view.root) {
        val name = view.category
        var image = view.image
        val discount = view.discount
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = CategoryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = list[position]
        holder.name.text = data.name
        val str = data.discount.toString() + "%"
        holder.discount.text = str
        Glide.with(context)
            .load(data.image_URL)
            .fitCenter()
            .placeholder(R.drawable.no_image)
            .error(R.drawable.no_image)
            .into(holder.image)

        holder.image.setOnClickListener{
            onClickCategory.OnClick(holder.name.text.toString())
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }
}

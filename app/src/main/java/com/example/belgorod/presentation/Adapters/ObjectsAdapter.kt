package com.example.belgorod.presentation.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.belgorod.R
import com.example.belgorod.databinding.CategoryItemBinding
import com.example.belgorod.databinding.ObjectItemBinding
import com.example.belgorod.presentation.module.CategoryPresentation
import com.example.belgorod.presentation.module.ObjectPresentation
import com.example.belgorod.presentation.ui.Menu.OnClickCategory

class ObjectsAdapter(
    val context: Context,
    val list: List<ObjectPresentation>
) : RecyclerView.Adapter<ObjectsAdapter.MyViewHolder>() {
    inner class MyViewHolder(view: ObjectItemBinding) : RecyclerView.ViewHolder(view.root) {
        var image = view.image
        val discount = view.discount
        val time = view.time
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = ObjectItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = list[position]
        var str = "${data.discount.toString()} %"
        holder.discount.text = str
        str = "${data.time.toString()} дней"
        Glide.with(context)
            .load(data.image_URL)
            .fitCenter()
            .placeholder(R.drawable.no_image)
            .error(R.drawable.no_image)
            .into(holder.image)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
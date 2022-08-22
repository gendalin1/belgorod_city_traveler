package com.example.belgorod.presentation.Adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.belgorod.R
import com.example.belgorod.databinding.NewsItemBinding
import com.example.belgorod.presentation.module.NewsPresentation

class NewsAdapter(
    val context: Context,
    val list: List<NewsPresentation>,
) :
    RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {
    inner class MyViewHolder(view: NewsItemBinding) : RecyclerView.ViewHolder(view.root) {
        val title = view.title
        var image = view.image
        val desk = view.text
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = NewsItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = list[position]
        holder.title.text = data.title
        holder.desk.text = data.description
        Glide.with(context)
            .load(data.imageUrl)
            .fitCenter()
            .placeholder(R.drawable.no_image)
            .error(R.drawable.no_image)
            .into(holder.image)


        holder.title.setOnClickListener{
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(data.link))
            context.startActivity(browserIntent)
        }


    }

    override fun getItemCount(): Int {
        return list.size
    }
}

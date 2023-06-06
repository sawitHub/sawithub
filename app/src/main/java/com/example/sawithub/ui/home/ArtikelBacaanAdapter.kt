package com.example.sawithub.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sawithub.R
import com.example.sawithub.entity.Artikel

class ArtikelBacaanAdapter(private val listArtikel: ArrayList<Artikel>): RecyclerView.Adapter<ArtikelBacaanAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_bacaan, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, imgUrl, _) = listArtikel[position]
        holder.tvName.text = name
        Glide.with(holder.itemView.context)
            .load(imgUrl)
            .into(holder.imgPhoto)
    }

    override fun getItemCount(): Int = listArtikel.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.text_title_bacaan)
        val imgPhoto: ImageView = itemView.findViewById(R.id.image_bacaan)
    }
}
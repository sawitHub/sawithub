package com.example.sawithub.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.sawithub.R
import com.smarteist.autoimageslider.SliderViewAdapter

class BannerSliderAdapter(image: ArrayList<Int>): SliderViewAdapter<BannerSliderAdapter.SliderViewHolder>() {
    var sliderImageList: ArrayList<Int> = image

    override fun getCount(): Int {
        return sliderImageList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?): BannerSliderAdapter.SliderViewHolder {
        val inflate: View = LayoutInflater.from(parent?.context).inflate(R.layout.item_banner, null)
        return SliderViewHolder(inflate)
    }

    override fun onBindViewHolder(viewHolder: BannerSliderAdapter.SliderViewHolder, position: Int) {
        Glide.with(viewHolder.itemView)
            .load(sliderImageList.get(position))
            .fitCenter()
            .into(viewHolder.imageView)
    }

    class SliderViewHolder(itemView: View): SliderViewAdapter.ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.mybanner_image)
    }
}


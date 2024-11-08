package com.example.kuit4androidprivate.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.databinding.ItemDetailRestaurantViewpagerBinding
import com.example.kuit4androidprivate.model.RestaurantImageData

class DetailRestaurantImageRVAdapter : ListAdapter<RestaurantImageData, DetailRestaurantImageRVAdapter.ViewHolder>(diffUtl) {
    inner class ViewHolder (val binding: ItemDetailRestaurantViewpagerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : RestaurantImageData) {
            Glide.with(binding.root)
                .load(item.id)
                .into(binding.ivDetailRestaurant)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailRestaurantImageRVAdapter.ViewHolder {
        val binding = ItemDetailRestaurantViewpagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailRestaurantImageRVAdapter.ViewHolder, position: Int) {
        holder.bind(currentList[position % 3])
    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }

    companion object{
        val diffUtl = object : DiffUtil.ItemCallback<RestaurantImageData>(){
            override fun areItemsTheSame(oldItem: RestaurantImageData, newItem: RestaurantImageData): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: RestaurantImageData, newItem: RestaurantImageData): Boolean {
                return oldItem == newItem
            }

        }
    }
}
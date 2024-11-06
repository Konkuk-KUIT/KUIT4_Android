package com.example.kuit4androidprivate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.databinding.ItemDetailRestaurantBinding
import com.example.kuit4androidprivate.model.MenuData

class MyeatsFavoriteRVAdapter (
    private val context : Context,
    private val items: ArrayList<MenuData>
) : RecyclerView.Adapter<MyeatsFavoriteRVAdapter.ViewHolder>() {

    inner class ViewHolder(
        private val binding: ItemDetailRestaurantBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MenuData) {
            binding.tvDetailRestaurant.text = item.title
            binding.tvDetailRate.text = item.reviewScore
            binding.tvDetailReviewcount.text = item.reviewCount

            Glide.with(binding.root)
                .load(item.imageUrl)
                .into(binding.ivDetailRestaurant)
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyeatsFavoriteRVAdapter.ViewHolder {
        val binding =
            ItemDetailRestaurantBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyeatsFavoriteRVAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }


}
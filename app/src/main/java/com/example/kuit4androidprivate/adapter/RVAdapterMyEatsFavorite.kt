package com.example.kuit4androidprivate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.databinding.ItemMyEatsFavoriteBinding
import com.example.kuit4androidprivate.model.MenuData

class RVAdapterMyEatsFavorite(
    private val context: Context,
    private val items: ArrayList<MenuData>,
) : RecyclerView.Adapter<RVAdapterMyEatsFavorite.ViewHolder>() {

    inner class ViewHolder(val binding: ItemMyEatsFavoriteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MenuData) {
            if (item.imgId != null) {//res의 image 사용하는 경우
                binding.ivRestaurantImg.setImageResource(item.imgId)
            } else {//Glide로 image url 사용하는 경우
                Glide.with(context)
                    .load(item.imgUrl)
                    .into(binding.ivRestaurantImg)
            }

            binding.tvRestaurantName.text = item.restaurantName
            binding.tvDetailRating.text = item.rating
            binding.tvDetailTotalReview.text = item.totalReviews

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMyEatsFavoriteBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }
}
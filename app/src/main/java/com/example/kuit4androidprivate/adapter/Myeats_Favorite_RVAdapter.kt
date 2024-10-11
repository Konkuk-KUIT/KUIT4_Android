package com.example.kuit4androidprivate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.databinding.ItemDetailRestaurantBinding
import com.example.kuit4androidprivate.databinding.ItemReviewBinding
import com.example.kuit4androidprivate.model.MenuData
import com.example.kuit4androidprivate.model.ReviewData

class Myeats_Favorite_RVAdapter (
    private val context : Context,
    private val items: ArrayList<MenuData>
) : RecyclerView.Adapter<Myeats_Favorite_RVAdapter.ViewHolder>() {

    inner class ViewHolder(
        private val binding: ItemDetailRestaurantBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MenuData) {
            binding.tvDetailRestaurantname.text = item.title
            binding.tvDetailReviewscore.text = item.reviewScore
            binding.tvDetailReviewcount.text = item.reviewCount

            Glide.with(binding.root)
                .load(item.imageUrl)
                .into(binding.ivDetailRestaurantdetail)
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Myeats_Favorite_RVAdapter.ViewHolder {
        val binding =
            ItemDetailRestaurantBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: Myeats_Favorite_RVAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }


}
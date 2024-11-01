package com.example.kuit4androidprivate.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.databinding.ItemFavoriteRestaurantBinding
import com.example.kuit4androidprivate.detail.DetailActivity
import com.example.kuit4androidprivate.model.MenuData

class FavoriteRVAdapter(
    private val context: Context,
    private val items: ArrayList<MenuData>,
) : RecyclerView.Adapter<FavoriteRVAdapter.Favorite_ViewHolder>() {

    inner class Favorite_ViewHolder(
        private val binding: ItemFavoriteRestaurantBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MenuData) {
            binding.tvFavoriteRestaurant.text = item.title
            binding.tvFavoriteTime.text = item.time
            binding.tvFavoriteRate.text = item.reviewScore
            binding.tvFavoriteReviewcount.text = item.reviewCount

            Glide.with(context)
                .load(item.imageUrl)
                .into(binding.ivFavoriteRestaurant)


            binding.ivFavoriteLikeFilled.setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java).apply {
                    putExtra("title", item.title)
                    putExtra("imageUrl", item.imageUrl)
                    putExtra("reviewScore", item.reviewScore)
                    putExtra("reviewCount", item.reviewCount)
                }
                context.startActivity(intent)
            }

            binding.ivFavoriteLikeEmpty.setOnClickListener {
                if (binding.ivFavoriteLikeEmpty.visibility == View.VISIBLE) {
                    binding.ivFavoriteLikeEmpty.visibility = View.INVISIBLE
                    binding.ivFavoriteLikeFilled.visibility = View.VISIBLE
                }
            }
            binding.ivFavoriteLikeFilled.setOnClickListener {
                if (binding.ivFavoriteLikeFilled.visibility == View.VISIBLE) {
                    binding.ivFavoriteLikeEmpty.visibility = View.VISIBLE
                    binding.ivFavoriteLikeFilled.visibility = View.INVISIBLE
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Favorite_ViewHolder {
        val binding =
            ItemFavoriteRestaurantBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return Favorite_ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: Favorite_ViewHolder,
        position: Int,
    ) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

}
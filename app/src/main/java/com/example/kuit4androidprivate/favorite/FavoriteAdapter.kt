package com.example.kuit4androidprivate.favorite

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.detail.DetailActivity
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.databinding.ItemFavoriteBinding

class FavoriteAdapter(
    private val context: Context,
    private val favoriteList: List<FavoriteItem>
) : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("favorite_prefs", Context.MODE_PRIVATE)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val binding = ItemFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val favoriteItem = favoriteList[position]

        favoriteItem.isFavorite = sharedPreferences.getBoolean(favoriteItem.name, false)

        holder.bind(favoriteItem)

        holder.binding.ivFavoriteLove.setOnClickListener {
            favoriteItem.isFavorite = !favoriteItem.isFavorite
            saveFavoriteState(favoriteItem.name, favoriteItem.isFavorite)
            holder.updateFavoriteIcon(favoriteItem.isFavorite)
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java).apply {
                putExtra("name", favoriteItem.name)
                putExtra("score", favoriteItem.score)
                putExtra("reviewCount", favoriteItem.reviewCount)
                putExtra("image", favoriteItem.image)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = favoriteList.size

    class FavoriteViewHolder(val binding: ItemFavoriteBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(favoriteItem: FavoriteItem) {
            binding.tvFavoriteSnack.text = favoriteItem.name
            binding.tvFavoriteScore.text = favoriteItem.score
            binding.tvFavoriteReview.text = "(${favoriteItem.reviewCount})"
            Glide.with(binding.ivFavoriteLike.context)
                .load(favoriteItem.image)
                .into(binding.ivFavoriteLike)

            updateFavoriteIcon(favoriteItem.isFavorite)
        }

        fun updateFavoriteIcon(isFavorite: Boolean) {
            if (isFavorite) {
                binding.ivFavoriteLove.setImageResource(R.drawable.ic_nav_like_red)
            } else {
                binding.ivFavoriteLove.setImageResource(R.drawable.ic_nav_like)
            }
        }
    }

    private fun saveFavoriteState(itemName: String, isFavorite: Boolean) {
        sharedPreferences.edit().putBoolean(itemName, isFavorite).apply()
    }
}
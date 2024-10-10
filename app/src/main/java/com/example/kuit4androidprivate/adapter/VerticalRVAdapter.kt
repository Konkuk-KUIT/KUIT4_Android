package com.example.kuit4androidprivate.adapter

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.data.FavoriteData
import com.example.kuit4androidprivate.databinding.ItemFavoiteBinding

class VerticalRVAdapter(private val context: Context,
        private val FavoriteList : ArrayList<FavoriteData>) : RecyclerView.Adapter<VerticalRVAdapter.FavoriteViewHolder>() {

        private val sharedPreferences : SharedPreferences= context.getSharedPreferences("favorite_prefs", Context.MODE_PRIVATE)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalRVAdapter.FavoriteViewHolder {
                val binding = ItemFavoiteBinding.inflate(LayoutInflater.from(parent.context), parent, false )
                return FavoriteViewHolder(binding)
        }

        override fun getItemCount(): Int {
                return FavoriteList.size
        }

        override fun onBindViewHolder(holder: VerticalRVAdapter.FavoriteViewHolder, position: Int) {
                val favoriteItem = FavoriteList[position]

                favoriteItem.isFavorite = sharedPreferences.getBoolean(favoriteItem.name, false)

                holder.bind(favoriteItem)

                holder.binding.ivLike.setOnClickListener{
                        favoriteItem.isFavorite = !favoriteItem.isFavorite
                        saveFavoriteState(favoriteItem.name, favoriteItem.isFavorite)
                        holder.updateFavoriteLike(favoriteItem.isFavorite)
                }
        }

        private fun saveFavoriteState(itemName:String, isFavorite: Boolean) {
                sharedPreferences.edit().putBoolean(itemName, isFavorite).apply()
        }

        open class FavoriteViewHolder(val binding: ItemFavoiteBinding) : RecyclerView.ViewHolder(binding.root){
                fun bind(item:FavoriteData) {
                        binding.ivFavorite.setImageResource(item.image)
                        binding.tvFavoriteName.text = item.name
                        binding.tvFavoriteScore.text = item.score
                        binding.tvFavoriteMinute.text = item.minute
                        binding.tvFavoriteReview.text = item.review
                }

                fun updateFavoriteLike(isFavorite : Boolean){
                        if (isFavorite) {
                                binding.ivLike.setImageResource(R.drawable.ic_like)
                        }
                        else {
                                binding.ivLike.setImageResource(R.drawable.ic_like_filled)
                        }
                }
        }
}
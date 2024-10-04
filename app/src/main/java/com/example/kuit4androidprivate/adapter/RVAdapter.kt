package com.example.kuit4androidprivate.adapter

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.databinding.ItemFavoriteMenuBinding
import com.example.kuit4androidprivate.favorite.FavoriteActivity
import com.example.kuit4androidprivate.model.MenuData

class RVAdapter(
    private val context: FavoriteActivity,
    private val items: ArrayList<MenuData>, private val menuClickListener: (MenuData) -> Unit
) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemFavoriteMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MenuData) {
            binding.tvFavmenu.text = item.title
            binding.tvFavTime.text = item.time
            binding.tvFavReview.text = item.review
            binding.tvFavCount.text = item.count



            binding.ivFavFilledheart.setOnClickListener {
                item.bookmark = false
                binding.ivFavHeart.visibility = View.VISIBLE
                binding.ivFavFilledheart.visibility = View.GONE
            }

            binding.ivFavHeart.setOnClickListener {
                item.bookmark = true
                binding.ivFavHeart.visibility = View.GONE
                binding.ivFavFilledheart.visibility = View.VISIBLE
            }


            Glide.with(context)
                .load(item.imageUrl)
                .into(binding.sivItem)

            itemView.setOnClickListener() { menuClickListener(item) }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemFavoriteMenuBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}


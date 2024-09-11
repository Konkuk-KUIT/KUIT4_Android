package com.example.kuit4androidprivate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.databinding.ItemFavoriteMenuBinding
import com.example.kuit4androidprivate.model.MenuData

class RVAdapter (private val context : Context,
                 private val items: ArrayList<MenuData>,
                 private val textClickListener: (String) -> Unit
) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemFavoriteMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MenuData) {
            binding.tvFavmenu.text = item.title
            binding.tvFavTime.text = item.time
            binding.tvFavReview.text = item.review
            binding.tvFavCount.text = item.count

            Glide.with(context)
                .load(item.imageUrl)
                .into(binding.ivItem)

            binding.favoriteMenuTotal.setOnClickListener {
                textClickListener(item.title)
            }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ViewHolder {
        val binding =ItemFavoriteMenuBinding.inflate(
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


package com.example.kuit4androidprivate.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.ActionMenuView.OnMenuItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.databinding.ItemFavorite2Binding
import com.example.kuit4androidprivate.model.MenuData
import detail.DetailActivity

class RVAdapter1(
    private val context : Context,
    private val items: ArrayList<MenuData>,
    private val itemClickListener: (MenuData) -> Unit
) : RecyclerView.Adapter<RVAdapter1.ViewHolder>(){

    inner class ViewHolder(private val binding: ItemFavorite2Binding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item:MenuData){
            binding.tvFavoriteName.text = item.title
            binding.tvFavoriteMinuite.text = item.time
            binding.tvFavoriteRate.text = item.rate
            binding.tvFavoriteNumber.text = item.number
           
            Glide.with(context)
                .load(item.imageUrl)
                .into(binding.ivFavoriteFood)


            binding.ivFavoriteNoheart.setOnClickListener {
                toggleHeartVisibility()
            }
            binding.ivFavoriteHeart.setOnClickListener {
                toggleHeartVisibility()
            }


            //FavoriteActivity에서 DetailActivity로 넘기기 위한 설정 부분
            itemView.setOnClickListener {
                itemClickListener(item)
            }
        }


        private fun toggleHeartVisibility() {
            if (binding.ivFavoriteNoheart.visibility == View.VISIBLE) {
                binding.ivFavoriteNoheart.visibility = View.GONE
                binding.ivFavoriteHeart.visibility = View.VISIBLE
            } else {
                binding.ivFavoriteNoheart.visibility = View.VISIBLE
                binding.ivFavoriteHeart.visibility = View.GONE
            }

        }


    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter1.ViewHolder {
        val binding = ItemFavorite2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RVAdapter1.ViewHolder, position: Int) {
            holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}
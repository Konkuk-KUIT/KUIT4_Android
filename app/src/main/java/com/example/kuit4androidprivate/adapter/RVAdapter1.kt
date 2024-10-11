package com.example.kuit4androidprivate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.databinding.ItemFavoriteBinding
import com.example.kuit4androidprivate.dataClass.MenuData

class RVAdapter1(
    private val context : Context,
    private val items: ArrayList<MenuData>,
    private val itemClickListener: (MenuData) -> Unit
) : RecyclerView.Adapter<RVAdapter1.ViewHolder>(){

    inner class ViewHolder(private val binding: ItemFavoriteBinding) : RecyclerView.ViewHolder(binding.root){
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



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}
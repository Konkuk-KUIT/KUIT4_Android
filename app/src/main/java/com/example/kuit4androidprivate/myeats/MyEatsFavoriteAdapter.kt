package com.example.kuit4androidprivate.myeats

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.databinding.ItemMyEatsFavoriteBinding

class MyEatsFavoriteAdapter(private val myEatsFavoriteList: List<MyEatsFavoriteItem>) :
    RecyclerView.Adapter<MyEatsFavoriteAdapter.MyEatsFavoriteViewHolder>() {

    inner class MyEatsFavoriteViewHolder(private val binding: ItemMyEatsFavoriteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(myEatsFavoriteItem: MyEatsFavoriteItem) {
            Log.d("MyEatsFavoriteAdapter", "데이터확인 ${adapterPosition} ${myEatsFavoriteItem.name}")
            binding.tvMyeatsFavorite.text = myEatsFavoriteItem.name
            binding.tvMyeatsFavoriteScore.text = myEatsFavoriteItem.score
            binding.tvMyeatsFavoriteReview.text = myEatsFavoriteItem.reviewCount
            binding.ivMyeatsFavorite.setImageResource(myEatsFavoriteItem.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyEatsFavoriteViewHolder {
        val binding = ItemMyEatsFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyEatsFavoriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyEatsFavoriteViewHolder, position: Int) {
        holder.bind(myEatsFavoriteList[position])
    }

    override fun getItemCount(): Int {
        return myEatsFavoriteList.size
    }
}

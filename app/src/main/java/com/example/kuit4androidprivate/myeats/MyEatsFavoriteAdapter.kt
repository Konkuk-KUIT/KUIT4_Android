package com.example.kuit4androidprivate.myeats

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.databinding.ItemMyEatsFavoriteBinding

class MyEatsFavoriteAdapter(private val myEatsFavoriteList: List<MyEatsFavoriteItem>) :
    RecyclerView.Adapter<MyEatsFavoriteAdapter.MyEatsFavoriteViewHolder>() {

    inner class MyEatsFavoriteViewHolder(val binding: ItemMyEatsFavoriteBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyEatsFavoriteViewHolder {
        val binding = ItemMyEatsFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyEatsFavoriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyEatsFavoriteViewHolder, position: Int) {
        val myEatsFavoriteItem = myEatsFavoriteList[position]

        Log.d("MyEatsFavoriteAdapter", "데이터확인 $position  ${myEatsFavoriteItem.name}")
        holder.binding.tvMyeatsFavorite.text = myEatsFavoriteItem.name
        holder.binding.tvMyeatsFavoriteScore.text = myEatsFavoriteItem.score
        holder.binding.tvMyeatsFavoriteReview.text = myEatsFavoriteItem.reviewCount
        holder.binding.ivMyeatsFavorite.setImageResource(myEatsFavoriteItem.image)
    }

    override fun getItemCount(): Int {
        return myEatsFavoriteList.size
    }
}

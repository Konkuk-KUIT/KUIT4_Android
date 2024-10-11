package com.example.kuit4androidprivate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.dataClass.MenuData
import com.example.kuit4androidprivate.databinding.ItemMyPageFavoriteBinding

class MyFavoriteRVAdapter(
    private val context: Context,
    private val items: List<MenuData>
) : RecyclerView.Adapter<MyFavoriteRVAdapter.ViewHolder>() {

    // ViewHolder 클래스 정의
    inner class ViewHolder(private val binding: ItemMyPageFavoriteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MenuData) {
            binding.tvDetailName.text = item.title
            binding.tvDetailRate.text = item.rate
            binding.tvDetailNumber.text = item.number

            Glide.with(context)
                .load(item.imageUrl)
                .into(binding.ivDetailImage1)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // 올바른 바인딩 객체 사용
        val binding = ItemMyPageFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}

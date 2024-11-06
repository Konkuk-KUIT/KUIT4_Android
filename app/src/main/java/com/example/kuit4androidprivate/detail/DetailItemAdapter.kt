package com.example.kuit4androidprivate.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.databinding.ItemDetailFoodlistBinding

class DetailItemAdapter(private val items: List<DetailItem>) : RecyclerView.Adapter<DetailItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(private val binding: ItemDetailFoodlistBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: DetailItem) {
            binding.tvDetailName.text = item.name
            binding.tvDetailPrice.text = item.price
            binding.ivDetailImg.setImageResource(item.imageResId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemDetailFoodlistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}

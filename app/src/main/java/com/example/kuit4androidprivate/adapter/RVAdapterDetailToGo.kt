package com.example.kuit4androidprivate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.databinding.ItemDetailMenuBinding
import com.example.kuit4androidprivate.model.DetailMenuData

class RVAdapterDetailToGo (
    private val context: Context,
    private val items: ArrayList<DetailMenuData>,
) : RecyclerView.Adapter<RVAdapterDetailToGo.ViewHolder>() {
    inner class ViewHolder(val binding: ItemDetailMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DetailMenuData) {
            binding.tvDetailMenuName.text = item.menuName
            binding.tvDetailMenuPrice.text = item.price
            binding.ivDetailMenuImg.setImageResource(item.imgId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDetailMenuBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RVAdapterDetailToGo.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}
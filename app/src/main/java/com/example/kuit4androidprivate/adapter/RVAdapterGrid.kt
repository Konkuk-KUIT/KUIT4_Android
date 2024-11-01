package com.example.kuit4androidprivate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.databinding.ItemFoodBinding
import com.example.kuit4androidprivate.dataClass.MenuCategoryData

class RVAdapterGrid(
    private val context: Context,
    private val items: List<MenuCategoryData>
) : RecyclerView.Adapter<RVAdapterGrid.ViewHolder>(){
    inner class ViewHolder(private val binding: ItemFoodBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(foodItem: MenuCategoryData) {
            // 리소스 ID로 이미지 설정
            binding.ivFoodImg.setImageResource(foodItem.image)
            binding.tvFoodName.text = foodItem.name
        }
}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }
    override fun getItemCount(): Int = items.size

}


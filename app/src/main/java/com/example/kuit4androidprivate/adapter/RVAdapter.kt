package com.example.kuit4androidprivate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.databinding.ItemHomeCategoryBinding
import com.example.kuit4androidprivate.model.MenuCategoryData

class RVAdapter(
    private val context: Context,
    private val items: ArrayList<MenuCategoryData>,
    private val categoryClickListener: (MenuCategoryData) -> Unit
    ): RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemHomeCategoryBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: MenuCategoryData){
            binding.ivCategoryImage.setImageResource(item.categoryImage)
            binding.tvCategoryName.text = item.categoryName

            binding.root.setOnClickListener {
                categoryClickListener(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ViewHolder {
        val binding = ItemHomeCategoryBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }
}
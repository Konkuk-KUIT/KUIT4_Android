package com.example.kuit4androidprivate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.databinding.ItemMenuCategoryBinding
import com.example.kuit4androidprivate.data.MenuCategoryData

class GridRVAdapter(
    private val context: Context,
    private val items: ArrayList<MenuCategoryData>) : RecyclerView.Adapter<GridRVAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding:ItemMenuCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MenuCategoryData){
            binding.ivMenuImage.setImageResource(item.image)
            binding.tvMenuText.text = item.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridRVAdapter.ViewHolder {
        val binding = ItemMenuCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GridRVAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

}
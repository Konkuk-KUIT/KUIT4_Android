package com.example.kuit4androidprivate.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.databinding.CategoryShowMoreBinding
import com.example.kuit4androidprivate.databinding.MenuCategoryItemBinding
import com.example.kuit4androidprivate.home.HomeFragment
import com.example.kuit4androidprivate.model.MenuCategoryData

class MenuCategoryRVAdapter(
    private val context: HomeFragment,
    private val items: ArrayList<MenuCategoryData>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_ITEM = 0
        private const val VIEW_TYPE_SHOW_MORE = 1
    }

    inner class ItemViewHolder(val binding: MenuCategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MenuCategoryData) {
            binding.tvCategoryItem.text = item.title
            binding.ivCategoryItem.setImageResource(item.image)
        }
    }

    inner class ShowMoreViewHolder(val binding: CategoryShowMoreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_ITEM) {
            val itemBinding = MenuCategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            ItemViewHolder(itemBinding)
        } else {
            val showMoreBinding = CategoryShowMoreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            ShowMoreViewHolder(showMoreBinding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder) {
            holder.bind(items[position])
        }
    }

    override fun getItemCount(): Int {
        return items.size +1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == items.size) VIEW_TYPE_SHOW_MORE else VIEW_TYPE_ITEM
    }
}
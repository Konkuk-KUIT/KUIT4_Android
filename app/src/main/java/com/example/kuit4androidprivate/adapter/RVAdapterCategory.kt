package com.example.kuit4androidprivate.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.databinding.ItemHomeCategoryBinding
import com.example.kuit4androidprivate.databinding.ItemShowMoreBinding
import com.example.kuit4androidprivate.model.MenuCategoryData
class RVAdapterCategory(
    private val context: Context,
    private val items: ArrayList<MenuCategoryData>,
    private val categoryClickListener: (MenuCategoryData) -> Unit,
    private val showMoreClickListener: () -> Unit
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        private const val VIEW_TYPE_ITEM = 0
        private const val VIEW_TYPE_SHOW_MORE = 1
    }

    inner class ItemViewHolder(val binding: ItemHomeCategoryBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: MenuCategoryData){
            binding.ivCategoryImage.setImageResource(item.categoryImage)
            binding.tvCategoryName.text = item.categoryName

            binding.root.setOnClickListener {
                categoryClickListener(item)
            }
        }
    }

    inner class ShowMoreViewHolder(val binding: ItemShowMoreBinding): RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener{
                showMoreClickListener()
            }
        }
    }

    // 아이템 뷰 타입을 반환하는 함수
    override fun getItemViewType(position: Int): Int {
        return if (position == 9) { // 마지막 포지션
            VIEW_TYPE_SHOW_MORE
        } else {
            VIEW_TYPE_ITEM
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_TYPE_ITEM){
            val binding = ItemHomeCategoryBinding.inflate(LayoutInflater.from(context), parent, false)
            return ItemViewHolder(binding)
        }else{
            val showMoreBinding =
                ItemShowMoreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ShowMoreViewHolder(showMoreBinding)
        }
    }

    override fun getItemCount(): Int = items.size + 1

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder){
            holder.bind(items[position])
        }
    }
}

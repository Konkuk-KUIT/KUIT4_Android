package com.example.kuit4androidprivate.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.R

class MenuCategoryDataAdapter(private val menuCategoryDataList: List<MenuCategoryData>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_ITEM = 0
        const val VIEW_TYPE_MORE = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == menuCategoryDataList.size - 1) {
            VIEW_TYPE_MORE
        } else {
            VIEW_TYPE_ITEM
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_ITEM) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
            menuCategoryDataViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_more, parent, false)
            MoreViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is menuCategoryDataViewHolder) {
            val menuCategoryData = menuCategoryDataList[position]
            holder.bind(menuCategoryData)
        }
    }

    override fun getItemCount(): Int = menuCategoryDataList.size

    class menuCategoryDataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val menuCategoryDataImage: ImageView = itemView.findViewById(R.id.iv_food_image)
        private val menuCategoryDataName: TextView = itemView.findViewById(R.id.tv_food_name)

        fun bind(food: MenuCategoryData) {
            menuCategoryDataImage.setImageResource(food.imageRes)
            menuCategoryDataName.text = food.name
        }
    }

    class MoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}


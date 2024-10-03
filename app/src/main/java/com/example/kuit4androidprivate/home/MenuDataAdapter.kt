package com.example.kuit4androidprivate.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.R

class MenuDataAdapter(
    private val menuList: List<MenuData>,
    private val onItemClick: (MenuData) -> Unit
) : RecyclerView.Adapter<MenuDataAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_horizontal_food, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val menuData = menuList[position]
        holder.bind(menuData)
        holder.itemView.setOnClickListener {
            onItemClick(menuData)
        }
    }

    override fun getItemCount(): Int = menuList.size

    class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val foodImage: ImageView = itemView.findViewById(R.id.iv_home_food)
        private val foodName: TextView = itemView.findViewById(R.id.tv_home_food)
        private val foodScore: TextView = itemView.findViewById(R.id.tv_home_score)
        private val foodReview: TextView = itemView.findViewById(R.id.tv_home_review)

        fun bind(menuData: MenuData) {
            foodName.text = menuData.name
            foodScore.text = menuData.score
            foodReview.text = "(${menuData.reviewCount})"

            Glide.with(itemView.context)
                .load(menuData.imageUrl)
                .into(foodImage)
        }
    }
}

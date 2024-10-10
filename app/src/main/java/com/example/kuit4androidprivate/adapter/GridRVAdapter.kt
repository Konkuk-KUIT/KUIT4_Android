package com.example.kuit4androidprivate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.databinding.ItemMenuCategoryBinding
import com.example.kuit4androidprivate.data.MenuCategoryData

class GridRVAdapter(
    private val context: Context,
    private val MenuCategoryList: ArrayList<MenuCategoryData>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        const val VIEW_TYPE_ITEM = 0
        const val VIEW_TYPE_MORE = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if(position == MenuCategoryList.size - 1) {
            VIEW_TYPE_MORE
        }
        else {
            VIEW_TYPE_ITEM
        }
    }

    inner class moreMenuCategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    }

    inner class menuCategoryDataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private var menuCategoryDataImage: ImageView = itemView.findViewById(R.id.iv_menu_image)
        private var menuCategoryDataText: TextView = itemView.findViewById(R.id.tv_menu_text)
        fun bind(menuCategoryData: MenuCategoryData){
            menuCategoryDataImage.setImageResource(menuCategoryData.image)
            menuCategoryDataText.text = menuCategoryData.name
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_ITEM) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu_category,parent, false)
            menuCategoryDataViewHolder(view)
        }
        else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_more_menu_category, parent, false)
            moreMenuCategoryViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is menuCategoryDataViewHolder){
            val menuCategoryData = MenuCategoryList[position]
            holder.bind(menuCategoryData)
        }
    }

    override fun getItemCount(): Int {
        return MenuCategoryList.size
    }

}
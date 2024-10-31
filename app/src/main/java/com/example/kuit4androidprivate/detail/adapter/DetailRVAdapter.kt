package com.example.kuit4androidprivate.detail.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.data.DetailMenuData
import com.example.kuit4androidprivate.databinding.ItemDetailMenuBinding

class DetailRVAdapter(
    private val context: Context,
    private val DetailMenuList: ArrayList<DetailMenuData>) : RecyclerView.Adapter<DetailRVAdapter.ViewHolder>() {

        inner class ViewHolder(val binding: ItemDetailMenuBinding): RecyclerView.ViewHolder(binding.root){
            fun bind(item: DetailMenuData){
                binding.tvDetailMenuName.text = item.name
                binding.tvDetailMenuPrice.text = item.price
                binding.ivDetailMenu.setImageResource(item.image)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailRVAdapter.ViewHolder {
        val binding = ItemDetailMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailRVAdapter.ViewHolder, position: Int) {
        val item = DetailMenuList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return DetailMenuList.size
    }
}
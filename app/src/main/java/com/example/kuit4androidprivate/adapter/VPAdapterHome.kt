package com.example.kuit4androidprivate.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.databinding.ItemHomeVpBinding
import com.example.kuit4androidprivate.model.MenuData

class VPAdapterHome(val totalItemCount: Int): ListAdapter<MenuData, VPAdapterHome.ViewHolder>(diffUtil){
    inner class ViewHolder(private val binding: ItemHomeVpBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: MenuData, position: Int){
            Glide.with(binding.root)
                .load(item.imgUrl)
                .into(binding.ivHomeVpImg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHomeVpBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position % totalItemCount], position)
    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }

    companion object{
        val diffUtil = object: DiffUtil.ItemCallback<MenuData>(){
            override fun areItemsTheSame(oldItem: MenuData, newItem: MenuData): Boolean {
                //각 아이템들의 고유한 id를 비교해야 한다.
                return oldItem.restaurantName == newItem.restaurantName
            }
            override fun areContentsTheSame( oldItem: MenuData, newItem: MenuData): Boolean {
                //컨텐츠 자체를 비교
                return oldItem == newItem

            }
        }
    }

}
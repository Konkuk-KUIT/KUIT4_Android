package com.example.kuit4androidprivate.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.databinding.ItemDetailVpBinding
import com.example.kuit4androidprivate.model.DetailMenuData

class VPAdapterDetail(val totalItemCount: Int): ListAdapter<DetailMenuData, VPAdapterDetail.ViewHolder>(diffUtil){
    inner class ViewHolder(private val binding: ItemDetailVpBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: DetailMenuData, position: Int){
            Glide.with(binding.root)
                .load(item.imgId)
                .into(binding.ivDetailVpImg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDetailVpBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position % totalItemCount], position)
    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }

    companion object{
        val diffUtil = object: DiffUtil.ItemCallback<DetailMenuData>(){
            override fun areItemsTheSame(oldItem: DetailMenuData, newItem: DetailMenuData): Boolean {
                //각 아이템들의 고유한 id를 비교해야 한다.
                return oldItem.imgId== newItem.imgId
            }
            override fun areContentsTheSame(oldItem: DetailMenuData, newItem: DetailMenuData): Boolean {
                //컨텐츠 자체를 비교
                return oldItem == newItem

            }
        }
    }

}
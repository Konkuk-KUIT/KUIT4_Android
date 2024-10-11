package com.example.kuit4androidprivate.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.databinding.ItemHomeVpBinding
import com.example.kuit4androidprivate.dataClass.HomeVPData

class HomeVPAdapter : ListAdapter<HomeVPData, HomeVPAdapter.ViewHolder>(diffUtil){

    inner class ViewHolder(val binding: ItemHomeVpBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HomeVPData){

            Glide.with(binding.root)
                .load(item.imgUrl)
                .into(binding.ivHomeVp)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeVPAdapter.ViewHolder {
        val binding = ItemHomeVpBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeVPAdapter.ViewHolder, position: Int) {
        holder.bind(currentList[position%5])
        //holder.bind(currentList[position])
    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
        //return super.getItemCount()
    }


    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<HomeVPData>(){
            override fun areItemsTheSame(oldItem: HomeVPData, newItem: HomeVPData): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: HomeVPData, newItem: HomeVPData): Boolean {
                return oldItem == newItem
            }

        }
    }
}


package com.example.kuit4androidprivate.adapter

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.databinding.ItemDetailStoreBinding
import com.example.kuit4androidprivate.model.DetailStoreData

class DetailStoreVPAdapter : ListAdapter<DetailStoreData, DetailStoreVPAdapter.ViewHolder>(diffUtil) {
    inner class ViewHolder(val binding: ItemDetailStoreBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DetailStoreData, position: Int) {
            binding.ivDetailItem.setImageResource(data.imageResId)
            binding.tvBottomPageNumber.text = "${position%3+1}/3"

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailStoreVPAdapter.ViewHolder {
        val binding =
            ItemDetailStoreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailStoreVPAdapter.ViewHolder, position: Int) {
        holder.bind(currentList[position%3], position)
    }


    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }
    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<DetailStoreData>() {
            override fun areItemsTheSame(
                oldItem: DetailStoreData,
                newItem: DetailStoreData
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: DetailStoreData,
                newItem: DetailStoreData
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

}
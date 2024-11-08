package com.example.kuit4androidprivate.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.databinding.ItemHomeCardBinding
import com.example.kuit4androidprivate.model.CardData

class CardHomeVPAdapter : ListAdapter<CardData, CardHomeVPAdapter.ViewHolder>(DiffUtil) {
    inner class ViewHolder(val binding: ItemHomeCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CardData) {
            Glide.with(binding.root)
                .load(item.imgUrl)
                .into(binding.ivItemHomeCard)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding =
            ItemHomeCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position % 5])
    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }

    companion object {
        val DiffUtil = object : DiffUtil.ItemCallback<CardData>() {
            override fun areItemsTheSame(oldItem: CardData, newItem: CardData): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: CardData, newItem: CardData): Boolean {
                return oldItem == newItem
            }

        }
    }

}
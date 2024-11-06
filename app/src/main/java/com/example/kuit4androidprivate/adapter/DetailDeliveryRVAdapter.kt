package com.example.kuit4androidprivate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.databinding.ItemDetailMenuBinding
import com.example.kuit4androidprivate.model.DishData

class DetailDeliveryRVAdapter (
    private val context : Context,
    private val items: ArrayList<DishData>
): RecyclerView.Adapter<DetailDeliveryRVAdapter.ViewHolder>(){

    inner class ViewHolder (
        private val binding: ItemDetailMenuBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DishData) {
            binding.tvDetailMenu.text = item.name
            binding.tvDetailPrice.text = item.price

            Glide.with(binding.root)
                .load(item.img)
                .into(binding.ivDetailImg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailDeliveryRVAdapter.ViewHolder {
        val binding =
            ItemDetailMenuBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailDeliveryRVAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

}
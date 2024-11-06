package com.example.kuit4androidprivate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.databinding.ItemDetailDeliveryDataBinding
import com.example.kuit4androidprivate.model.DetailData

class LinearDetailRVAdapter(
    private val context: Context,
    private val detailDataItems: ArrayList<DetailData>
) : RecyclerView.Adapter<LinearDetailRVAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemDetailDeliveryDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DetailData) {
            binding.tvItemDetailDeliveryName.text = item.name
            binding.tvItemDetailDeliveryPrice.text = item.price
            Glide.with(context)
                .load(item.img)
                .into(binding.ivItemDetailDeliveryImg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDetailDeliveryDataBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = detailDataItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(detailDataItems[position])
    }
}
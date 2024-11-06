package com.example.kuit4androidprivate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.FavoritesOrderPackageFragment
import com.example.kuit4androidprivate.databinding.MenuOrderBinding
import com.example.kuit4androidprivate.model.OrderData

class MenuOrderDeliveryRVAdapter(
    private val context: Context,
    private val items: ArrayList<OrderData>
) :
    RecyclerView.Adapter<MenuOrderDeliveryRVAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: MenuOrderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: OrderData) {
            with(binding) {
                tvOrderItemName.text = item.name
                tvOrderItemPrice.text = item.price
                binding.ivOrderItemImage.setImageResource(item.image)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MenuOrderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

}
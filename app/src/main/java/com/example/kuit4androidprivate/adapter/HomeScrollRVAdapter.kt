package com.example.kuit4androidprivate.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.kuit4androidprivate.databinding.ItemLatelyMenuBinding
import com.example.kuit4androidprivate.home.HomeFragment
import com.example.kuit4androidprivate.model.MenuData

class HomeScrollRVAdapter(
    private val context: HomeFragment, private val items: ArrayList<MenuData>,
    private val menuClickListener: (MenuData) -> Unit
) : RecyclerView.Adapter<HomeScrollRVAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemLatelyMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MenuData) {
            binding.tvLatelymenu.text = item.title
            binding.tvLatelytime.text = item.time
            binding.tvLatelyReview.text = item.review
            binding.tvLatelyCount.text = item.count


            Glide.with(context)
                .load(item.imageUrl)
                .into(binding.sivLatelyitem)

            itemView.setOnClickListener() { menuClickListener(item) }


        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ItemLatelyMenuBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }
}
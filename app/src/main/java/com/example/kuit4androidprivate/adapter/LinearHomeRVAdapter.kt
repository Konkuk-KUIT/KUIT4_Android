package com.example.kuit4androidprivate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.databinding.ItemMainMenuDataBinding
import com.example.kuit4androidprivate.model.MenuData


class LinearHomeRVAdapter(
    private val context: Context,
    private val menuDataItems: ArrayList<MenuData>,
    private val textClickListener: (MenuData) -> Unit
) : RecyclerView.Adapter<LinearHomeRVAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemMainMenuDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MenuData) {

            binding.tvName.text = item.name
            binding.tvTime.text = item.time
            binding.tvRatingNumber.text = item.ratingNumber
            binding.tvVisit.text = item.visitNumber

            Glide.with(context)
                .load(item.imgUrl)
                .into(binding.ivItem)

            binding.root.setOnClickListener {
                textClickListener(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMainMenuDataBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(menuDataItems[position])
    }


    override fun getItemCount(): Int = menuDataItems.size

}


package com.example.kuit4androidprivate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.databinding.ItemMyEatsLikeBinding
import com.example.kuit4androidprivate.model.MenuData


class LinearMyEatsLikeRVAdapter(
    private val context: Context,
    private val linearHomeItems: ArrayList<MenuData>,
    private val textClickListener: (MenuData) -> Unit
) : RecyclerView.Adapter<LinearMyEatsLikeRVAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemMyEatsLikeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MenuData) {
            binding.tvMyEatsLikeStoreName.text = item.name
            binding.tvMyEatsLikeVisitNumber.text = item.visitNumber
            binding.tvMyEatsLikeRatingNumber.text = item.ratingNumber

            Glide.with(context)
                .load(item.imgUrl)
                .into(binding.ivMyEatsLikeFood)
            //글라이드는 크기가 없어서
            binding.root.setOnClickListener {
                textClickListener(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMyEatsLikeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = linearHomeItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(linearHomeItems[position])
    }
}
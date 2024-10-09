package com.example.kuit4androidprivate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.databinding.ItemMyEatsReviewBinding
import com.example.kuit4androidprivate.model.ReviewData

class RVAdapterMyEatsReview(
    private val context: Context,
    private val items: ArrayList<ReviewData>,
) : RecyclerView.Adapter<RVAdapterMyEatsReview.ViewHolder>() {
    inner class ViewHolder(val binding: ItemMyEatsReviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ReviewData) {
            binding.tvReviewName.text = item.restaurantName
            binding.tvReviewText.text = item.review
            binding.tvReviewDate.text = item.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMyEatsReviewBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RVAdapterMyEatsReview.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size


}
package com.example.kuit4androidprivate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.databinding.ItemMyEatsReviewBinding
import com.example.kuit4androidprivate.model.ReviewData

class LinearMyEatsReviewRVAdapter(
    private var context: Context,
    private var reviewDataItems: ArrayList<ReviewData>
) : RecyclerView.Adapter<LinearMyEatsReviewRVAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemMyEatsReviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ReviewData) {
            binding.tvEatsItemDate.text = item.storeName
            binding.tvEatsItemReview.text = item.review
            binding.tvEatsItemDate.text = item.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMyEatsReviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = reviewDataItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(reviewDataItems[position])
    }
}
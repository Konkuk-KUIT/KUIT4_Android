package com.example.kuit4androidprivate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.databinding.ItemFavoriteRestaurantBinding
import com.example.kuit4androidprivate.databinding.ItemReviewBinding
import com.example.kuit4androidprivate.model.ReviewData

class Review_RVAdapter(
    private val context : Context,
    private val items: ArrayList<ReviewData>
) : RecyclerView.Adapter<Review_RVAdapter.ViewHolder>() {

    inner class ViewHolder(
        private val binding: ItemReviewBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ReviewData) {
            binding.tvReviewRestaruantName.text = item.restaurantName
            binding.tvReviewDate.text = item.date
            binding.tvReviewComment.text = item.reviewComment
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Review_RVAdapter.ViewHolder {
        val binding =
            ItemReviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: Review_RVAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }


}
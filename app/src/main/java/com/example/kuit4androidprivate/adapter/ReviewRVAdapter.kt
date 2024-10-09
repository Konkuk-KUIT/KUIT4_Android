package com.example.kuit4androidprivate.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.ReviewViewPageFragment
import com.example.kuit4androidprivate.databinding.MenuReviewItemBinding
import com.example.kuit4androidprivate.model.ReviewData

class ReviewRVAdapter(
    private val context : ReviewViewPageFragment,
    private val items : ArrayList<ReviewData>
) : RecyclerView.Adapter<ReviewRVAdapter.ViewHolder>(){

    inner class  ViewHolder(private val binding : MenuReviewItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item:ReviewData){
            with(binding){
                tvReviewComment.text = item.comment
                tvReviewItemStoreName.text = item.storeName
                tvReviewDate.text = item.date
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MenuReviewItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }
}
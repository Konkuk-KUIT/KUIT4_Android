package com.example.kuit4androidprivate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.databinding.ItemMyPageReviewBinding
import com.example.kuit4androidprivate.dataclasss.MyPageReviewData

class MyPageReviewRVAdapter(
    private val context: Context,
    private val items: ArrayList<MyPageReviewData>
) : RecyclerView.Adapter<MyPageReviewRVAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemMyPageReviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MyPageReviewData){
            binding.tvReviewName.text = item.name
            binding.tvReviewDate.text = item.date
            binding.tvReviewReview.text = item.review
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMyPageReviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }
    override fun getItemCount(): Int = items.size

}
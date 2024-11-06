package com.example.kuit4androidprivate.myeats.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.data.MyEatsReviewData
import com.example.kuit4androidprivate.databinding.ItemMyReviewBinding

class MyEatsReviewRVAdapter(
    private val context: Context,
    private val reviewList: ArrayList<MyEatsReviewData>) : RecyclerView.Adapter<MyEatsReviewRVAdapter.ViewHolder>() {

        class ViewHolder(private val binding: ItemMyReviewBinding) : RecyclerView.ViewHolder(binding.root){
            fun bind(item: MyEatsReviewData){
                binding.tvMyReviewDate.text = item.date
                binding.tvMyReviewName.text = item.name
                binding.tvMyReviewComment.text = item.comment
            }
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMyReviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val myReview = reviewList[position]
        holder.bind(myReview)
    }

    override fun getItemCount(): Int {
        return reviewList.size
    }
}
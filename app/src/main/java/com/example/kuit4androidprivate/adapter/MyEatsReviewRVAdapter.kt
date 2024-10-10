package com.example.kuit4androidprivate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.data.MyEatsReviewData
import com.example.kuit4androidprivate.databinding.ItemMyReviewBinding

class MyEatsReviewRVAdapter(
    private val context: Context,
    private val reviewList: ArrayList<MyEatsReviewData>) : RecyclerView.Adapter<MyEatsReviewRVAdapter.ViewHolder>() {

        inner class ViewHolder(private val binding: ItemMyReviewBinding) : RecyclerView.ViewHolder(binding.root){
            fun bind(item: MyEatsReviewData){

            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyEatsReviewRVAdapter.ViewHolder {
        val binding = ItemMyReviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyEatsReviewRVAdapter.ViewHolder, position: Int) {
        val myReview = reviewList[position]
        holder.bind(myReview)
    }

    override fun getItemCount(): Int {
        return reviewList.size
    }
}
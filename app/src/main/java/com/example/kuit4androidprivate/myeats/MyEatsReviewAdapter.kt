package com.example.kuit4androidprivate.myeats

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.databinding.ItemMyEatsReviewBinding

class MyEatsReviewAdapter(private val reviewList: List<MyEatsReviewItem>) :
    RecyclerView.Adapter<MyEatsReviewAdapter.MyEatsReviewViewHolder>() {

    inner class MyEatsReviewViewHolder(val binding: ItemMyEatsReviewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyEatsReviewViewHolder {
        val binding = ItemMyEatsReviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyEatsReviewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyEatsReviewViewHolder, position: Int) {
        val reviewItem = reviewList[position]
        holder.binding.tvMyeatsReviewName.text = reviewItem.reviewerName
        holder.binding.tvMyeatsReviewTxt.text = reviewItem.reviewText
        holder.binding.tvReviewDate.text = reviewItem.reviewDate

        for (i in 0 until reviewItem.score) {
            (holder.binding.llMyeatsReviewScore.getChildAt(i) as ImageView).setImageResource(R.drawable.img_home_star)
        }
    }

    override fun getItemCount(): Int {
        return reviewList.size
    }
}

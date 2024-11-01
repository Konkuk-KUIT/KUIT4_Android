package com.example.kuit4androidprivate.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.databinding.ItemHomeRestaurantBinding
import com.example.kuit4androidprivate.detail.DetailActivity
import com.example.kuit4androidprivate.home.HomeFragment
import com.example.kuit4androidprivate.keep.KeepActivity
import com.example.kuit4androidprivate.model.MenuData


class RVAdapter(
    private val context: Context,
    private val items: ArrayList<MenuData>,
) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    inner class ViewHolder(
        private val binding: ItemHomeRestaurantBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MenuData) {
            binding.tvItemRestaurant.text = item.title
            binding.tvItemTime.text = item.time
            binding.tvItemRate.text = item.reviewScore
            binding.tvItemReviewcount.text = item.reviewCount

            Glide.with(context)
                .load(item.imageUrl)
                .into(binding.ivItemRestaurant)


            binding.ivItemRestaurant.setOnClickListener {
                //상세 페이지로 이동
                val intent = Intent(context, DetailActivity::class.java).apply {
                    putExtra("title", item.title)
                    putExtra("imageUrl", item.imageUrl)
                    putExtra("reviewScore", item.reviewScore)
                    putExtra("reviewCount", item.reviewCount)
                }
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding =
            ItemHomeRestaurantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int,
    ) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size


}
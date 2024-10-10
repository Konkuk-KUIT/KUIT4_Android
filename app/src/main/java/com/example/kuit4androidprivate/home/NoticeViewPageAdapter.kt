package com.example.kuit4androidprivate.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.databinding.ItemNoticeBinding

class NoticeViewPagerAdapter(private val images: IntArray, private val texts: Array<String>) :
    RecyclerView.Adapter<NoticeViewPagerAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemNoticeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(image: Int) {
            binding.ivHomeVp.setImageResource(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNoticeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(images[position % images.size])
    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }
}

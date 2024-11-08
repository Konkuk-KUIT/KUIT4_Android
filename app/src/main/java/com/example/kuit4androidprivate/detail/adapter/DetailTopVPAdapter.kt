package com.example.kuit4androidprivate.detail.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.databinding.ItemDetailTabBinding
import com.example.kuit4androidprivate.databinding.ItemDetailViewpagerBinding

class DetailTopVPAdapter(private val context: Context,
    private val imageList: List<Int>): RecyclerView.Adapter<DetailTopVPAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemDetailViewpagerBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Int){
            binding.ivItemDetailScroll.setImageResource(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDetailViewpagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return 100
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = imageList[position%3]
        holder.bind(item)
    }

}
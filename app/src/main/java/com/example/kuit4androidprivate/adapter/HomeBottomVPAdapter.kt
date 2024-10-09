package com.example.kuit4androidprivate.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.databinding.ItemHomeBottomBinding
import com.example.kuit4androidprivate.model.HomeBottomData

class HomeBottomVPAdapter : ListAdapter<HomeBottomData, HomeBottomVPAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(val binding: ItemHomeBottomBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HomeBottomData) {
            Glide.with(binding.root)
                .load(item.imageUrl)
                .into(binding.ivBottomItem)

            // 각 아이템에 번호 설정해줌
            binding.tvBottomPageNumber.text =  "${position%5+1}/5"
        }

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeBottomVPAdapter.ViewHolder {
        val binding =
            ItemHomeBottomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeBottomVPAdapter.ViewHolder, position: Int) {
        holder.bind(currentList[position%5])
    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<HomeBottomData>() {
            override fun areItemsTheSame(
                oldItem: HomeBottomData,
                newItem: HomeBottomData
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: HomeBottomData,
                newItem: HomeBottomData
            ): Boolean {
                return oldItem == newItem
            }

        }
    }
}
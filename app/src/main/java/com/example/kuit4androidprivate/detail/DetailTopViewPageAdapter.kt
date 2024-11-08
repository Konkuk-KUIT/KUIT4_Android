package com.example.kuit4androidprivate.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.databinding.ItemDetailMainfoodBinding

class DetailTopViewPageAdapter : RecyclerView.Adapter<DetailTopViewPageAdapter.DetailViewHolder>() {

    private val items = listOf(R.drawable.img_home_snackfood, R.drawable.img_home_snackfood, R.drawable.img_home_snackfood)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val binding = ItemDetailMainfoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class DetailViewHolder(private val binding: ItemDetailMainfoodBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(imageResId: Int) {
            binding.ivHomeVp.setImageResource(imageResId)
        }
    }
}


package com.example.kuit4androidprivate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.databinding.ItemHome2Binding
import com.example.kuit4androidprivate.model.MenuData



class RVAdapter(
    private val context: Context,
    private val items: ArrayList<MenuData>

) : RecyclerView.Adapter<RVAdapter.ViewHolder>(){


    inner class ViewHolder(private val binding:ItemHome2Binding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item:MenuData){
            binding.tvItemName.text = item.title
            binding.tvItemMinuite.text = item.time
            binding.tvItemRate.text = item.rate
            binding.tvItemNumber.text = item.number

            Glide.with(context)
                .load(item.imageUrl)
                .into(binding.ivItemFood)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ViewHolder {
        val binding = ItemHome2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

}
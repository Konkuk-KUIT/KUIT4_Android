package com.example.kuit4androidprivate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.data.MyEatsFavoriteData
import com.example.kuit4androidprivate.databinding.ItemFavoiteBinding

class MyEatsFavoriteRVAdapter(
    private val context: Context,
    private val FavoriteList: ArrayList<MyEatsFavoriteData>) : RecyclerView.Adapter<MyEatsFavoriteRVAdapter.ViewHolder>() {

        inner class ViewHolder(private val binding: ItemFavoiteBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(item: MyEatsFavoriteData){

            }
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyEatsFavoriteRVAdapter.ViewHolder {
        val binding = ItemFavoiteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyEatsFavoriteRVAdapter.ViewHolder, position: Int) {
        val item = FavoriteList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return FavoriteList.size
    }
}
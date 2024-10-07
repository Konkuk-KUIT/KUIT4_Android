package com.example.kuit4androidprivate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.data.FavoriteData
import com.example.kuit4androidprivate.databinding.ActivityFavoriteBinding

class VerticalRVAdapter(private val context: Context,
        private val items : ArrayList<FavoriteData>) : RecyclerView.Adapter<VerticalRVAdapter.ViewHolder>() {

        inner class ViewHolder(private val binding:ActivityFavoriteBinding):RecyclerView.ViewHolder(binding.root){
                fun bind(item:FavoriteData){

                }
        }
        override fun onCreateViewHolder(
                parent: ViewGroup,
                viewType: Int
        ): VerticalRVAdapter.ViewHolder {
                val binding = ActivityFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: VerticalRVAdapter.ViewHolder, position: Int) {
                holder.bind(items[position])
        }

        override fun getItemCount(): Int {
                return items.size
        }
}
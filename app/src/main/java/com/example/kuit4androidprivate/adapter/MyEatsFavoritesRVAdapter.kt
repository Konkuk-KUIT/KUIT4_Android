package com.example.kuit4androidprivate.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.FavoritesViewPageFragment
import com.example.kuit4androidprivate.databinding.MenuFavoritesItemBinding
import com.example.kuit4androidprivate.databinding.MenuMyEatsFavoritesItemBinding
import com.example.kuit4androidprivate.model.MenuLatelyData

class MyEatsFavoritesRVAdapter(
    private val context: FavoritesViewPageFragment,
    private val items: ArrayList<MenuLatelyData>
) : RecyclerView.Adapter<MyEatsFavoritesRVAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding : MenuMyEatsFavoritesItemBinding)
        :RecyclerView.ViewHolder(binding.root){
        fun bind(item : MenuLatelyData){
            with(binding){
                tvMyEatsFavoritesNum.text = item.num
                tvMyEatsFavoritesStoreName.text = item.title
                tvMyEatsFavoritesScore.text = item.score
            }
            Glide.with(context)
                .load(item.imageUrl)
                .into(binding.ivMyEatsFavoritesItem)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val binding = MenuMyEatsFavoritesItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }
}
package com.example.kuit4androidprivate.adapter

import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.databinding.MenuLatelyItemBinding
import com.example.kuit4androidprivate.home.HomeFragment
import com.example.kuit4androidprivate.model.MenuCategoryData
import com.example.kuit4androidprivate.model.MenuLatelyData

class MenuDataRVAdapter(
    private val context: HomeFragment,
    private val items : ArrayList<MenuLatelyData>,
    private val menuClickListener: (MenuLatelyData) -> Unit
) : RecyclerView.Adapter<MenuDataRVAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: MenuLatelyItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MenuLatelyData) {
            with(binding) {
                tvLatelyItemNum.text = item.num
                tvLatelyItemScore.text = item.score
                tvLatelyItemTime.text = item.time
                tvLatelyItemTitle.text = item.title

                Glide.with(context)
                    .load(item.imageUrl)
                    .into(binding.ivLatelyItemImg)
                itemView.setOnClickListener(){
                    menuClickListener(item)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MenuLatelyItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }



}
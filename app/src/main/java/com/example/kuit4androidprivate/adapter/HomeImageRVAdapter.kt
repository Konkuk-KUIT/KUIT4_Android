package com.example.kuit4androidprivate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.data.HomeImageData
import com.example.kuit4androidprivate.databinding.ItemHomeImageScrollBinding

class HomeImageRVAdapter(
    private val context: Context,
    private val HomeImageList: ArrayList<HomeImageData>) : RecyclerView.Adapter<HomeImageRVAdapter.ViewHolder>() {

        inner class ViewHolder(private val binding:ItemHomeImageScrollBinding): RecyclerView.ViewHolder(binding.root){
            fun bind(item:HomeImageData){
                binding.ivScrollImage.setImageResource(item.image)
                if(item.index == 1)
                {
                    binding.tvScrollNumber.text = "1/3"
                }
                else if(item.index == 2)
                {
                    binding.tvScrollNumber.text = "2/3"
                }
                else
                {
                    binding.tvScrollNumber.text = "3/3"
                }
            }

        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeImageRVAdapter.ViewHolder {
        val binding = ItemHomeImageScrollBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeImageRVAdapter.ViewHolder, position: Int) {
        val HomeImage = HomeImageList[position % 3]
        holder.bind(HomeImage)
    }

    override fun getItemCount(): Int {
        return 1000
    }
}
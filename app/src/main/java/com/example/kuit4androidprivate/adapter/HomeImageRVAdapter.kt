package com.example.kuit4androidprivate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.data.ScrollImageData
import com.example.kuit4androidprivate.databinding.ItemImageScrollBinding

class HomeImageRVAdapter(
    private val context: Context,
    private val HomeImageList: ArrayList<ScrollImageData>) : RecyclerView.Adapter<HomeImageRVAdapter.ViewHolder>() {

        inner class ViewHolder(private val binding:ItemImageScrollBinding): RecyclerView.ViewHolder(binding.root){
            fun bind(item: ScrollImageData){
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
        val binding = ItemImageScrollBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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
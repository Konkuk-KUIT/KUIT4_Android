package com.example.kuit4androidprivate.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.DetailActivity
import com.example.kuit4androidprivate.data.MenuData
import com.example.kuit4androidprivate.databinding.ActivityDetailBinding
import com.example.kuit4androidprivate.databinding.ItemMenuDataBinding

class HorizontalRVAdapter(private val context: Context,
    private val items: ArrayList<MenuData>) : RecyclerView.Adapter<HorizontalRVAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding:ItemMenuDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item:MenuData) {
            binding.ivRecent.setImageResource(item.image)
            binding.tvRecentName.text = item.name
            binding.tvRecentMinute.text = item.minute
            binding.tvRecentScore.text = item.score

        }
    }

        override fun onCreateViewHolder( parent: ViewGroup, viewType: Int): HorizontalRVAdapter.ViewHolder {
            val binding = ItemMenuDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)

            return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HorizontalRVAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.itemView.setOnClickListener{
            val intent = Intent(context, DetailActivity::class.java).apply {
                    putExtra("name", item.name)
                    putExtra("score", item.score)
                    putExtra("review", item.review)
                    putExtra("minute", item.minute)
                    putExtra("image", item.image)
            }
            context.startActivity(intent)
        }
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }


}

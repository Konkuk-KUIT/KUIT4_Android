package com.example.kuit4androidprivate.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.databinding.IconMainAddBinding
import com.example.kuit4androidprivate.databinding.ItemMainMenuCategoryBinding
import com.example.kuit4androidprivate.model.MenuCategoryData

class GridHomeRVAdapter(
    //변수명 소문자시작(카멜케이스) 클래스는 대문자시작(파스칼케이스)//서버통신할때 중요함 명세서짤때
    private val context: Context,
    private val menuCategoryItems: ArrayList<MenuCategoryData>,
    private val textClickListener: (String) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemMainMenuCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MenuCategoryData) {
            binding.tvItem1.text = item.title
            Glide.with(context)
                .load(item.imageUrl)
                .into(binding.ivFavoriteDataItem)
        }
    }

    companion object {
        private const val VIEW_TYPE_ITEM = 0
        private const val VIEW_TYPE_SHOW_MORE = 1

    }

    private var currentItemCount = 9

    inner class ShowMoreViewHolder(
        private val binding: IconMainAddBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                if (currentItemCount == 14) {
                    currentItemCount = 9
                } else {
                    currentItemCount = 14
                }
                notifyDataSetChanged()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_ITEM) {
            val binding = ItemMainMenuCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            ViewHolder(binding)
        } else {
            val showMoreBinding = IconMainAddBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            ShowMoreViewHolder(showMoreBinding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            holder.bind(menuCategoryItems[position])
        } else if (holder is ShowMoreViewHolder) {

        }

    }

    override fun getItemCount(): Int = currentItemCount + 1

    override fun getItemViewType(position: Int): Int {
        return if (position == currentItemCount) {
            VIEW_TYPE_SHOW_MORE
        } else {
            VIEW_TYPE_ITEM
        }
    }
}
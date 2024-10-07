package com.example.kuit4androidprivate.adapter

import android.content.Context
import android.view.LayoutInflater
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.databinding.ItemHomeCategoryBinding
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.databinding.ItemHomeShowmoreBinding
import com.example.kuit4androidprivate.model.MenuCategoryData

class Category_RVAdapter(
    private val context: Context,
    private val items: ArrayList<MenuCategoryData>,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_ITEM = 0
        private const val VIEW_TYPE_SHOW_MORE = 1
    }

    inner class Category_ViewHolder(
        private val binding: ItemHomeCategoryBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MenuCategoryData) {
            binding.tvHomeCategoryname.text = item.categoryName

            Glide.with(context)
                .load(item.image)
                .into(binding.vHomeCategoryimg)
        }
    }

    inner class ShowMore_ViewHolder(
        private val binding: ItemHomeShowmoreBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.tvHomeShowmoreText.text = "더보기"
        }
    }

    // 아이템 뷰 타입을 반환하는 함수
    override fun getItemViewType(position: Int): Int {
        return if (position == 9) { // 마지막 포지션
            VIEW_TYPE_SHOW_MORE
        } else {
            VIEW_TYPE_ITEM
        }
    }
    // onCreateViewHolder 로 넘겨줌.

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RecyclerView.ViewHolder {

        if (viewType == VIEW_TYPE_ITEM) {
            val itemBinding =
                ItemHomeCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return Category_ViewHolder(itemBinding)

        } else { // VIEW_TYPE_SHOW_MORE
            val showMoreBinding =
                ItemHomeShowmoreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ShowMore_ViewHolder(showMoreBinding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is Category_ViewHolder) holder.bind(items[position])
        if (holder is ShowMore_ViewHolder) holder.bind()
    }

    override fun getItemCount(): Int = items.size + 1

}
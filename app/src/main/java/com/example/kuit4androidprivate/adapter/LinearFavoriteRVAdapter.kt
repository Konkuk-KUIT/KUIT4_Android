package com.example.kuit4androidprivate.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.DetailActivity
import com.example.kuit4androidprivate.FavoriteActivity
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.databinding.ItemFavoriteDataBinding
import com.example.kuit4androidprivate.model.MenuData

class LinearFavoriteRVAdapter(
    private val context: Context,
    private val menuDataItems: ArrayList<MenuData>,
    private val textClickListener: (MenuData) -> Unit
) : RecyclerView.Adapter<LinearFavoriteRVAdapter.ViewHolder>() {

    // ViewHolder 정의
    inner class ViewHolder(private val binding: ItemFavoriteDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        // 아이템 데이터를 View에 바인딩
        fun bind(item: MenuData) {

            binding.tvFavoriteDataName.text = item.name
            binding.tvFavoriteDataTime.text = item.time
            binding.tvFavoriteDataVisitNumber.text = item.visitNumber
            binding.tvFavoriteDataRatingNumber.text = item.ratingNumber


            Glide.with(context)
                .load(item.imgUrl)
                .into(binding.ivFavoriteDataItem)

            if (item.isFavorite) {
                Glide.with(context)
                    .load(R.drawable.ic_like_full)
                    .into(binding.ivFavoriteDataHeart)
            } else {
                Glide.with(context)
                    .load(R.drawable.ic_nav_like)
                    .into(binding.ivFavoriteDataHeart)
            }
            // 클릭 리스너 설정
            binding.ivFavoriteDataHeart.setOnClickListener {
                item.isFavorite = !item.isFavorite  // 즐겨찾기 상태 변경
                if (item.isFavorite) {
                    Glide.with(context)
                        .load(R.drawable.ic_like_full)
                        .into(binding.ivFavoriteDataHeart)
                } else {
                    Glide.with(context)
                        .load(R.drawable.ic_nav_like)
                        .into(binding.ivFavoriteDataHeart)
                }

//                // 아이템 상태가 변경되었으므로 UI 갱신
//                notifyItemChanged(adapterPosition)
            }
            binding.ivFavoriteDataItem.setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("item_data", item)
                context.startActivity(intent)
            }
            binding.root.setOnClickListener {
                textClickListener(item)  // 클릭된 아이템을 리스너로 전달
            }
        }
    }

    // ViewHolder 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemFavoriteDataBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = menuDataItems.size

    // ViewHolder와 데이터 바인딩
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(menuDataItems[position])
    }
}

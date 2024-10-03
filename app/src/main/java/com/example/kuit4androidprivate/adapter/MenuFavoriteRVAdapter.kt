package com.example.kuit4androidprivate.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.FavoriteActivity
import com.example.kuit4androidprivate.databinding.MenuFavoritesItemBinding
import com.example.kuit4androidprivate.model.MenuLatelyData

class MenuFavoriteRVAdapter(
    private val context: FavoriteActivity,
    private val items: ArrayList<MenuLatelyData>,
    private val menuClickListener: (MenuLatelyData) -> Unit
) : RecyclerView.Adapter<MenuFavoriteRVAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: MenuFavoritesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MenuLatelyData) {
            with(binding) {
                tvFavoritesItemNum.text = item.num
                tvFavoritesItemScore.text = item.score
                tvFavoritesItemTime.text = item.time
                tvFavoritesItemTitle.text = item.title

                Glide.with(context)
                    .load(item.imageUrl)
                    .into(binding.ivFavoritesItemImg)

                if (item.favorite) {
                    ivFavoriteBlankHeart.visibility = View.GONE
                    ivFavoriteFilledHeart.visibility = View.VISIBLE
                } else {
                    ivFavoriteBlankHeart.visibility = View.VISIBLE
                    ivFavoriteFilledHeart.visibility = View.GONE
                }

                ivFavoriteBlankHeart.setOnClickListener {
                    ivFavoriteBlankHeart.visibility = View.GONE
                    ivFavoriteFilledHeart.visibility = View.VISIBLE
                    item.favorite = true
                }

                // 채워진 하트를 클릭했을 때
                ivFavoriteFilledHeart.setOnClickListener {
                    ivFavoriteBlankHeart.visibility = View.VISIBLE
                    ivFavoriteFilledHeart.visibility = View.GONE
                    item.favorite = false
                }


                itemView.setOnClickListener() {
                    menuClickListener(item)
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            MenuFavoritesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuFavoriteRVAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }


}
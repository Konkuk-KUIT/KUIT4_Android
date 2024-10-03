package com.example.kuit4androidprivate.favorite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding
    private lateinit var favoriteAdapter: FavoriteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivFavoriteBack.setOnClickListener {
            finish()
        }

        val favoriteList = listOf(
            FavoriteItem("아워떡볶이", "4.9", "3,849", R.drawable.img_home_food),
            FavoriteItem("굽네치킨", "4.8", "2,349", R.drawable.img_home_chicken),
            FavoriteItem("BHC", "4.7", "1,849", R.drawable.img_home_grill),
            FavoriteItem("BBQ", "4.5", "1,349", R.drawable.img_home_food),
            FavoriteItem("도미노피자", "5.0", "5,355", R.drawable.img_home_pizza),
            FavoriteItem("신전떡볶이", "4.9", "3,849", R.drawable.img_home_food),
            FavoriteItem("순살만공격", "4.8", "2,349", R.drawable.img_home_chicken),
            FavoriteItem("삼겹살", "4.7", "1,849", R.drawable.img_home_grill),
            FavoriteItem("엽기떡볶이", "4.5", "1,349", R.drawable.img_home_food),
            FavoriteItem("피자헛", "5.0", "5,355", R.drawable.img_home_pizza)
        )

        favoriteAdapter = FavoriteAdapter(this, favoriteList)

        binding.rvFavorite.apply {
            layoutManager = LinearLayoutManager(this@FavoriteActivity)
            adapter = favoriteAdapter
        }

    }
}

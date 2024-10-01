package com.example.kuit4androidprivate.favorite

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.adapter.RVAdapterCategory
import com.example.kuit4androidprivate.adapter.RVAdapterFavorite
import com.example.kuit4androidprivate.databinding.ActivityFavoriteBinding
import com.example.kuit4androidprivate.databinding.ActivityKeepBinding
import com.example.kuit4androidprivate.detail.DetailActivity
import com.example.kuit4androidprivate.model.MenuCategoryData
import com.example.kuit4androidprivate.model.MenuData

class FavoriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavoriteBinding
    private lateinit var rvAdapterFavorite: RVAdapterFavorite
    private val favoriteItem = arrayListOf<MenuData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivActivityFavoriteBack.setOnClickListener{
            finish()
        }

        initFavorite()
        initRVAdapterFavorite()
    }

    private fun initRVAdapterFavorite() {
        rvAdapterFavorite= RVAdapterFavorite(this, favoriteItem) { it ->
            val intent = Intent(this, DetailActivity::class.java)
            //menuData를 intent에 넘김
            intent.putExtra("menuData",it)
            startActivity(intent)
        }

        with(binding.rvFavoriteRestaurants) {
            adapter = rvAdapterFavorite
            layoutManager =
                LinearLayoutManager(this@FavoriteActivity, LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun initFavorite(){
        favoriteItem.addAll(
            arrayListOf(
                MenuData(
                    restaurantName = getString(R.string.our_snacks),
                    eta = "50분",
                    imgId = R.drawable.img_favorite_our_snack,
                    rating = "2.9",
                    totalReviews = "(1149)"
                ),
                MenuData(
                    restaurantName = getString(R.string.our_snacks),
                    eta = "30분",
                    imgId = R.drawable.img_favorite_our_snack,
                    rating = "4.9",
                    totalReviews = "(3849)"
                ),
                MenuData(
                    restaurantName = getString(R.string.our_snacks),
                    eta = "30분",
                    imgId = R.drawable.img_favorite_our_snack,
                    rating = "4.9",
                    totalReviews = "(3849)"
                ),
                MenuData(
                    restaurantName = getString(R.string.our_snacks),
                    eta = "30분",
                    imgId = R.drawable.img_favorite_our_snack,
                    rating = "4.9",
                    totalReviews = "(3849)"
                ),
                MenuData(
                    restaurantName = getString(R.string.our_snacks),
                    eta = "30분",
                    imgId = R.drawable.img_favorite_our_snack,
                    rating = "4.9",
                    totalReviews = "(3849)"
                ),
                MenuData(
                    restaurantName = getString(R.string.our_snacks),
                    eta = "30분",
                    imgId = R.drawable.img_favorite_our_snack,
                    rating = "4.9",
                    totalReviews = "(3849)"
                ),
                MenuData(
                    restaurantName = getString(R.string.our_snacks),
                    eta = "30분",
                    imgId = R.drawable.img_favorite_our_snack,
                    rating = "4.9",
                    totalReviews = "(3849)"
                ),
                MenuData(
                    restaurantName = getString(R.string.our_snacks),
                    eta = "30분",
                    imgId = R.drawable.img_favorite_our_snack,
                    rating = "4.9",
                    totalReviews = "(3849)"
                ),
                MenuData(
                    restaurantName = getString(R.string.our_snacks),
                    eta = "30분",
                    imgId = R.drawable.img_favorite_our_snack,
                    rating = "4.9",
                    totalReviews = "(3849)"
                ),
                MenuData(
                    restaurantName = getString(R.string.our_snacks),
                    eta = "30분",
                    imgId = R.drawable.img_favorite_our_snack,
                    rating = "4.9",
                    totalReviews = "(3849)"
                ),
            )
        )
    }
}
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
                    eta = "30분",
                    imgId = R.drawable.img_favorite_our_snack,
                    rating = "3.9",
                    totalReviews = "(1149)"
                ),
                MenuData(
                    restaurantName = "피자",
                    eta = "20분",
                    imgUrl = "https://media.istockphoto.com/id/1146536318/ko/%EC%82%AC%EC%A7%84/%ED%9B%84%EC%B6%94-%EB%8B%88-%ED%94%BC%EC%9E%90-%EA%B7%BC%EC%A0%91-%EC%B4%AC%EC%98%81.jpg?s=1024x1024&w=is&k=20&c=yexBLtBeNPNJQBW7Wi_plRljy280ZR0KlN_SdVVGfVA=",
                    rating = "5.0",
                    totalReviews = "(2849)"
                ),
                MenuData(
                    restaurantName = "치킨",
                    eta = "50분",
                    imgUrl = "https://media.istockphoto.com/id/1432036799/ko/%EC%82%AC%EC%A7%84/%EB%A7%9B%EC%9E%88%EB%8A%94-pohan-piscanec-%EB%A5%98%EB%B8%94-%EB%9E%B4%EB%82%98-%EC%98%A4%ED%94%88-%ED%82%A4%EC%B9%9C-%EC%8B%9D%ED%92%88-%EC%8B%9C%EC%9E%A5%EC%97%90%EC%84%9C-%ED%8C%90%EB%A7%A4-%EB%90%A0-%EC%A4%80%EB%B9%84%EA%B0%80%EB%90%98%EC%97%88%EC%8A%B5%EB%8B%88%EB%8B%A4.jpg?s=612x612&w=0&k=20&c=LWoigW-YQijFXgyeT_waJ8YXn8pra-K-XT3Z5wlgyE8=",
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
package com.example.kuit4androidprivate.detail

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.databinding.ActivityDetailBinding
import com.example.kuit4androidprivate.model.MenuData

class DetailActivity: AppCompatActivity() {

    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val menuData: MenuData
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            menuData = intent.extras?.getParcelable("menuData",MenuData::class.java)!!
        }else{
            menuData = intent.extras?.getParcelable("menuData")!!
        }

        if (menuData.imgId != null){
            binding.ivDetailRestaurant.setImageResource(menuData.imgId)
        }else if (menuData.imgUrl != null){
            Glide.with(this)
                .load(menuData.imgUrl)
                .into(binding.ivDetailRestaurant)
        }

        binding.tvDetailRestaurantName.text = menuData.restaurantName
        binding.tvDetailRating.text = menuData.rating
        binding.tvDetailTotalReview.text = menuData.totalReviews


        binding.ivDetailBack.setOnClickListener {
            finish()
        }
    }

}
package com.example.kuit4androidprivate.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.root

        val restaurantName = intent.getStringExtra("title")
        val imageUrl = intent.getStringExtra("imageUrl")
        val reviewScore = intent.getStringExtra("reviewScore")
        val reviewCount = intent.getStringExtra("reviewCount")

        binding.tvDetailRestaurantname.text = restaurantName
        binding.tvDetailReviewscore.text = reviewScore
        binding.tvDetailReviewcount.text = reviewCount

        Glide.with(this)
            .load(imageUrl)
            .into(binding.ivDetailRestaurantdetail)

        binding.ivDetailBack.setOnClickListener {
            finish()
        }

    }
}
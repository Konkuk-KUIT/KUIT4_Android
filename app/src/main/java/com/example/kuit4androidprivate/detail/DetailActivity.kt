package com.example.kuit4androidprivate.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.databinding.ActivityDetailBinding
import com.example.kuit4androidprivate.model.MenuData


class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Base_Theme_Kuit4AndroidPrivate2)
        super.onCreate(savedInstanceState)

        //window.statusBarColor = ContextCompat.getColor(this, R.color.light_blue)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.root

        val menuData = intent.getSerializableExtra("menuData") as? MenuData

        if (menuData != null) {
            binding.tvDetailRestaurant.text = menuData.title
            binding.tvDetailRate.text = menuData.reviewScore
            binding.tvDetailReviewcount.text = menuData.reviewCount

            Glide.with(this)
                .load(menuData.imageUrl)
                .into(binding.ivDetailRestaurant)
        }
        binding.ivDetailBack.setOnClickListener {
            finish()
        }

    }
}
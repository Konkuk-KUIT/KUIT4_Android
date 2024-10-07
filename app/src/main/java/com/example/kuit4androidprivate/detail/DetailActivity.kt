package com.example.kuit4androidprivate.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.databinding.ActivityDetailBinding
import com.example.kuit4androidprivate.databinding.MenuFavoritesItemBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var favoritesItemBinding: MenuFavoritesItemBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListener()

        val title = intent.getStringExtra("title")
        val imageUrl = intent.getStringExtra("imageUrl")
        val score = intent.getStringExtra("score")
        val num = intent.getStringExtra("num")


        binding.tvDetailStoreName.text = title
        binding.tvDetailScore.text = score
        binding.tvDetailNum.text = num

        Glide.with(this)
            .load(imageUrl)
            .into(binding.ivDetailStore)

    }

    private fun initListener() {
        binding.ivDetailBackButton.setOnClickListener() {
            finish()
        }
    }
}
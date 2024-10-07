package com.example.kuit4androidprivate.detail

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.databinding.ActivityDetailBinding
import com.example.kuit4androidprivate.databinding.ItemFavoriteMenuBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var ItemFavMenuBinding: ItemFavoriteMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageUrl = intent.getStringExtra("imageUrl")
        val title = intent.getStringExtra("title")
        val review = intent.getStringExtra("review")
        val count = intent.getStringExtra("count")

        binding.tvDetailTitle.text = title
        binding.tvDetailReview.text = review;
        binding.tvDetailCount.text = count;

        Glide.with(this).load(imageUrl).into(binding.ivDetailPic)

        binding.ivBack.setOnClickListener() { finish() }
    }

}
package com.example.kuit4androidprivate

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

        val name = intent.getStringExtra("name")
        val score = intent.getStringExtra("score")
        val reviewCount = intent.getStringExtra("reviewCount")
        val imageUrl = intent.getStringExtra("imageUrl")
        val image = intent.getIntExtra("image", 0)

        binding.tvDetail.text = name
        binding.tvDetailScore.text = score
        binding.tvDetailReview.text = "($reviewCount)"

        if (!imageUrl.isNullOrEmpty()) {
            Glide.with(this)
                .load(imageUrl)
                .into(binding.ivDetail)
        } else if (image != 0) {
            Glide.with(this)
                .load(image)
                .into(binding.ivDetail)
        }

        binding.ivDetailBack.setOnClickListener {
            finish()
        }
    }
}

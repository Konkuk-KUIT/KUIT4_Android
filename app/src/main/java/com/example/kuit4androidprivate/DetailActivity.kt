package com.example.kuit4androidprivate

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kuit4androidprivate.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding:ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ivDetailArrow.setOnClickListener{
            finish()
        }
        val name = intent.getStringExtra("name")
        val score = intent.getStringExtra("score")
        val review = intent.getStringExtra("review")
        val image = intent.getIntExtra("image", 0)

        binding.tvDetailMenu.text = name
        binding.tvDetailScore.text = score
        binding.tvDetailReview.text = review

        binding.ivDetailMenu.setImageResource(image)

        initVerticalRVAdapter()
    }

    private fun initVerticalRVAdapter() {

    }
}
package com.example.kuit4androidprivate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.databinding.ActivityDetailBinding
import com.example.kuit4androidprivate.model.MenuData

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val item = intent.getSerializableExtra("item_data") as? MenuData
        item?.let {
            binding.tvDetailStoreName.text = item.name
            binding.tvDetailVisitNumber.text = item.visitNumber
            binding.tvDetailRatingNumber.text = item.ratingNumber

            Glide.with(this)
                .load(item.imgUrl)
                .into(binding.ivDetailHomeFood)
        }

        initBackIconImgListener()
    }

    private fun initBackIconImgListener() {
        binding.ivDetailBack.setOnClickListener {//fragment는 context가 없음
            finish()
        }
    }
}
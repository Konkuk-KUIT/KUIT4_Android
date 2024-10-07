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
            binding.storeName.text = item.name
            binding.tvRatingNumber.text = item.ratingNumber
            binding.tvVisitNumber.text = item.visitNumber
            Glide.with(this)
                .load(item.imgUrl)
                .into(binding.imgHomeFood)
        }

        initBackIconImgListener()
    }

    private fun initBackIconImgListener() {
        binding.iconBack.setOnClickListener {//fragment는 context가 없음
            finish()
        }
    }
}
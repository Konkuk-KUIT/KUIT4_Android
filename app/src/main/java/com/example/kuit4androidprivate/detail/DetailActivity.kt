package com.example.kuit4androidprivate.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.adapter.DetailVPAdapter
import com.example.kuit4androidprivate.databinding.ActivityDetailBinding
import com.example.kuit4androidprivate.model.MenuData
import com.google.android.material.tabs.TabLayoutMediator

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private var tabItems =arrayListOf<String>(
        "배달30분","포장15분"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
//        setTheme(R.style.Base_Theme_Kuit4AndroidPrivate2)
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
        initFragmentAdapter()
    }

    private fun initFragmentAdapter() {
        binding.vpDetail.adapter=DetailVPAdapter(this)
        TabLayoutMediator(binding.tlDetail,binding.vpDetail){
            tab,position->
            tab.text=tabItems[position]
        }.attach()
    }

    private fun initBackIconImgListener() {
        binding.ivDetailBack.setOnClickListener {//fragment는 context가 없음
            finish()
        }
    }
}
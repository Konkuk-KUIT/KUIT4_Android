package com.example.kuit4androidprivate.detail

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.DetailViewPagerFragment
import com.example.kuit4androidprivate.FavoritesOrderViewPagerFragment
import com.example.kuit4androidprivate.MyEatsDetailFragment
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.adapter.FavoritesOrderVPAdapter
import com.example.kuit4androidprivate.databinding.ActivityDetailBinding
import com.example.kuit4androidprivate.databinding.MenuFavoritesItemBinding
import com.example.kuit4androidprivate.keep.KeepActivity
import com.google.android.material.tabs.TabLayoutMediator

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var favoritesItemBinding: MenuFavoritesItemBinding
    private var tabItems = arrayListOf<String>(
        "배달 30분","포장 15분"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        //setTheme(R.style.)
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

        val parentFragment = FavoritesOrderViewPagerFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcv_detail_page, parentFragment)
            .commit()


    }

    private fun initListener() {
        binding.ivDetailBackButton.setOnClickListener() {
            finish()
        }
    }

}
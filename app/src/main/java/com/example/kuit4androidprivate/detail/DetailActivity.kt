package com.example.kuit4androidprivate.detail

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.data.MenuData
import com.example.kuit4androidprivate.databinding.ActivityDetailBinding
import com.example.kuit4androidprivate.detail.adapter.DetailVPAdapter
import com.google.android.material.tabs.TabLayoutMediator

class DetailActivity : AppCompatActivity() {

    private lateinit var binding:ActivityDetailBinding
    private lateinit var detailVPAdapter: DetailVPAdapter
    private var tabItems = arrayListOf("배달", "포장")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ivDetailArrow.setOnClickListener{
            finish()
        }

        val menuData: MenuData = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("menuData", MenuData::class.java)!!
        }else {
            intent.getSerializableExtra("menuData") as MenuData
        }


        binding.tvDetailMenu.text = menuData.name
        binding.tvDetailScore.text = menuData.score
        binding.tvDetailReview.text = menuData.review

        binding.ivDetailMenu.setImageResource(menuData.image)

        detailVPAdapter = DetailVPAdapter(this)
        binding.vpDetail.adapter = detailVPAdapter

        TabLayoutMediator(binding.tlDetail, binding.vpDetail) { tab, position ->
            tab.text = tabItems[position]
        }.attach()

    }
}
package com.example.kuit4androidprivate.detail

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.data.MenuData
import com.example.kuit4androidprivate.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding:ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Base_Theme_Kuit4AndroidPrivate2)
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

        val detailInfoFragment = DetailInfoFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcv_detail, detailInfoFragment)
            .commit()

    }
}
package com.example.kuit4androidprivate.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kuit4androidprivate.databinding.ActivityDetailBinding
import com.google.android.material.tabs.TabLayoutMediator

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivDetailBack.setOnClickListener {
            finish()
        }

        val adapter = DetailFragmentAdapter(this)
        binding.vpDetail.adapter = adapter

        TabLayoutMediator(binding.tlDetail, binding.vpDetail) { tab, position ->
            tab.text = when (position) {
                0 -> "배달 30분"
                1 -> "포장 15분"
                else -> null
            }
        }.attach()
    }
}

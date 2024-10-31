package com.example.kuit4androidprivate.keep

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kuit4androidprivate.detail.DetailActivity
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.data.MenuData
import com.example.kuit4androidprivate.databinding.ActivityKeepBinding

class KeepActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKeepBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityKeepBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.clKeepTteokbokki.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("menuData", MenuData(
                name = "아워떡볶이",
                image = R.drawable.img_tteokbokki_detail,
                score = "4.9",
                review = "3,849",
                minute = "30분"
            )
            )
            startActivity(intent)
        }
        binding.ivKeepArrow.setOnClickListener{
            finish()
        }

    }

}
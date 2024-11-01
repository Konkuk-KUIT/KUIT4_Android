package com.example.kuit4androidprivate.keep

import com.example.kuit4androidprivate.detail.DetailActivity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kuit4androidprivate.databinding.ActivityKeepBinding
import com.example.kuit4androidprivate.model.MenuLatelyData

class KeepActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKeepBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityKeepBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.conFavoritesMenu.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("title", "아워떡볶이")
            intent.putExtra("time", "30분")
            intent.putExtra("score", "4.9")
            intent.putExtra("num", "(3,849)")
            intent.putExtra("imageUrl", "https://cdn.pixabay.com/photo/2017/09/10/14/23/toppokki-2735719_1280.jpg")

            startActivity(intent)
        }
        binding.ivKeepBackButton.setOnClickListener() {
            finish()
        }
    }





}

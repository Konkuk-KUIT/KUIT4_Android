package com.example.kuit4androidprivate.keep

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kuit4androidprivate.DetailActivity
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.databinding.ActivityKeepBinding

class KeepActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKeepBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityKeepBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.clKeepTteokbokki.setOnClickListener {
            intentToDetailActivity()
        }
        binding.ivKeepArrow.setOnClickListener{
            finish()
        }

    }

    private fun intentToDetailActivity() {
        val intent = Intent(this, DetailActivity::class.java).apply{
            intent.putExtra("name", "아워떡볶이")
            intent.putExtra("score", "4.9")
            intent.putExtra("review", "3,849")
            intent.putExtra("image", R.drawable.img_tteokbokki)
        }
        startActivity(intent)
    }
}
package com.example.kuit4androidprivate.keep

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.databinding.ActivityKeepBinding
import com.example.kuit4androidprivate.detail.DetailActivity
import com.example.kuit4androidprivate.myeats.MyEatsFragment

class KeepActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKeepBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityKeepBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.root

        binding.clKeepRestaurant01.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }

        binding.ivKeepBack.setOnClickListener {
            finish()
        }
    }
}

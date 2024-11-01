package com.example.kuit4androidprivate.keep

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.databinding.ActivityKeepBinding
import com.example.kuit4androidprivate.detail.DetailActivity

class KeepActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKeepBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityKeepBinding.inflate(layoutInflater)

        binding.layoutKeep1.setOnClickListener{
            initDetailActivity()
        }

        binding.ivKeepBack.setOnClickListener{
            finish()
        }

        setContentView(binding.root)
    }

    private fun initDetailActivity() {
        val intent = Intent(this, DetailActivity::class.java)
        startActivity(intent)
    }
}

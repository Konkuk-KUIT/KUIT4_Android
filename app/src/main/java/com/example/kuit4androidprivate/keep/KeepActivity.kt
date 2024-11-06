package com.example.kuit4androidprivate.keep

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kuit4androidprivate.databinding.ActivityKeepBinding
import com.example.kuit4androidprivate.detail.DetailActivity

class KeepActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKeepBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityKeepBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.clKeepLike.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }

        binding.ivKeepBack.setOnClickListener {
            finish()
        }
    }
}

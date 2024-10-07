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

        binding.clKeepTteokbokki.setOnClickListener{
            intentToDetailActivity()

            val arrow = findViewById<ImageView>(R.id.iv_keep_arrow) as ImageView
        arrow.setOnClickListener(View.OnClickListener { finish() })
        }

    }

    private fun intentToDetailActivity() {
        val intent = Intent(this, DetailActivity::class.java)
        startActivity(intent)
    }
}
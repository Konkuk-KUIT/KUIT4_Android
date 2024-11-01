package com.example.kuit4androidprivate.detail

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.databinding.ActivityDetailBinding
import com.example.kuit4androidprivate.dataClass.MenuData

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val menuData = intent.getSerializableExtra("menuData") as? MenuData

        menuData?.let {
            Log.d("DetailActivity", "Image URL: ${it.imageUrl}")
            binding.tvDetailName.text = it.title
            binding.tvDetailRate.text = it.rate
            binding.tvDetailNumber.text = it.number

            Glide.with(this@DetailActivity)
                .load(it.imageUrl)
                .error(R.drawable.image1)
                .listener(object : RequestListener<Drawable> {

                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>,
                        isFirstResource: Boolean
                    ): Boolean {
                        Log.e("GlideError", "Image load failed", e)  // 로그 형식 수정
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable,
                        model: Any,
                        target: Target<Drawable>?,
                        dataSource: DataSource,
                        isFirstResource: Boolean
                    ): Boolean {
                        Log.d("GlideSuccess", "Image loaded successfully")  // 로그 형식 수정
                        return false
                    }
                })
                .into(binding.ivDetailImage1)


        }

        binding.ivDetailBack.setOnClickListener{
            finish()
        }


    }
}
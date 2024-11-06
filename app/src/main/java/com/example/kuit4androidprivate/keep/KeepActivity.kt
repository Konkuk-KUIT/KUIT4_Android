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
import com.example.kuit4androidprivate.model.MenuData

class KeepActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKeepBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityKeepBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.clFavoritesRestaurantContainer.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("menuData", MenuData(
                restaurantName = "아워떡볶이",
                eta = "30분",
                imgId = R.drawable.img_detail_restaurant,
                rating = "4.9",
                totalReviews = "(3849)"
            )
            )
            startActivity(intent)
        }

        binding.ivActivityKeepBack.setOnClickListener{
            finish()
        }
    }
}

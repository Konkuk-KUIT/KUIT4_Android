package com.example.kuit4androidprivate

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import com.example.kuit4androidprivate.adapter.VerticalRVAdapter
import com.example.kuit4androidprivate.data.FavoriteData
import com.example.kuit4androidprivate.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding:ActivityFavoriteBinding
    private lateinit var verticalRVAdapter: VerticalRVAdapter
    private var favoriteData: ArrayList<FavoriteData> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addFavoriteData()
        initVerticalRVAdapter()
        binding.ivFavoriteArrow.setOnClickListener{
            finish()
        }


    }

    private fun initVerticalRVAdapter() {
        verticalRVAdapter = VerticalRVAdapter(this, favoriteData)

        binding.rvFavorite.adapter = verticalRVAdapter
        binding.rvFavorite.layoutManager = LinearLayoutManager(this, VERTICAL,false)
    }

    private fun addFavoriteData() {
        favoriteData.addAll(
            arrayListOf(
                FavoriteData(image=R.drawable.img_tteokbokki, name="아워떡볶이", score="4.9",
                    review="3,849", minute="30분"),
                FavoriteData(image=R.drawable.img_bagel, name="니커버커베이글", score="4.9",
                    review="7,079", minute="40분"),
                FavoriteData(image=R.drawable.img_bbq, name="BBQ", score="4.4",
                    review="5,093", minute="40분"),
                FavoriteData(image=R.drawable.img_donut, name="크리스피크림도넛", score="4.6",
                    review="983", minute="20분"),
                FavoriteData(image=R.drawable.img_burger, name="맥도날드", score="4.7",
                    review="6,849", minute="25분"),
                FavoriteData(image=R.drawable.img_gukbap, name="정담옥", score="4.5",
                    review="849", minute="50분"),
                FavoriteData(image=R.drawable.img_jjimdalk, name="두마리찜닭", score="4.9",
                    review="9,849", minute="50분"),
                FavoriteData(image=R.drawable.img_rice_noodle, name="미스사이공", score="4.8",
                    review="3,583", minute="30분"),
                FavoriteData(image=R.drawable.img_taco, name="꼰미고", score="4.9",
                    review="829", minute="30분"),
                FavoriteData(image=R.drawable.img_korean_meal, name="주막례고등어구이", score="4.4",
                    review="9,836", minute="40분")
            )
        )
    }
}
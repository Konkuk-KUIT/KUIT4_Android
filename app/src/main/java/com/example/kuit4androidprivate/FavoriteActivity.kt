package com.example.kuit4androidprivate


import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit4androidprivate.adapter.MenuFavoriteRVAdapter
import com.example.kuit4androidprivate.databinding.ActivityFavoriteBinding
import com.example.kuit4androidprivate.detail.DetailActivity
import com.example.kuit4androidprivate.model.MenuLatelyData

class FavoriteActivity : AppCompatActivity() {


    private var dummyItems = ArrayList<MenuLatelyData>()
    private lateinit var binding: ActivityFavoriteBinding
    private lateinit var favoriteRVAdapter: MenuFavoriteRVAdapter


    private fun initListener() {
        binding.ivFavoriteBackButton.setOnClickListener() {
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFavoriteBinding.inflate(layoutInflater)

        setContentView(binding.root)
        initListener()
        initFavoriteRVAdapter()
        initDummy()
    }

    private fun initFavoriteRVAdapter() {
        favoriteRVAdapter = MenuFavoriteRVAdapter(this, dummyItems) { item ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("title", item.title)
                putExtra("imageUrl", item.imageUrl)
                putExtra("score", item.score)
                putExtra("num", item.num)
            }
            startActivity(intent)
        }

        binding.rvMenuFavorites.adapter = favoriteRVAdapter
        binding.rvMenuFavorites.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun initDummy() {
        dummyItems.addAll(
            arrayListOf(
                MenuLatelyData(
                    title = "아워떡볶이", time = "30분", score = "4.9", num = "(3,849)",
                    imageUrl = "https://cdn.pixabay.com/photo/2017/09/10/14/23/toppokki-2735719_1280.jpg"
                ),
                MenuLatelyData(
                    title = "홍대돈부리", time = "33분", score = "5.0", num = "(1,356)",
                    imageUrl = "https://cdn.pixabay.com/photo/2019/12/01/15/08/salmon-plate-with-rice-4665684_1280.jpg"
                ),
                MenuLatelyData(
                    title = "가람성", time = "15분", score = "4.8", num = "(971)",
                    imageUrl = "https://cdn.pixabay.com/photo/2020/08/22/14/49/fried-rice-5508576_1280.jpg"
                ),
                MenuLatelyData(
                    title = "부리또피아", time = "23분", score = "4.9", num = "(2,252)",
                    imageUrl = "https://cdn.pixabay.com/photo/2020/06/01/15/37/tortilla-5247120_1280.jpg"
                ),
                MenuLatelyData(
                    title = "홍도초밥", time = "40분", score = "5.0", num = "(1,294)",
                    imageUrl = "https://cdn.pixabay.com/photo/2015/10/06/19/10/sushi-975075_1280.jpg"
                ),
                MenuLatelyData(
                    title = "미분당", time = "35분", score = "4.7", num = "(471)",
                    imageUrl = "https://cdn.pixabay.com/photo/2023/05/27/12/35/noodles-8021415_1280.png"
                ),
                MenuLatelyData(
                    title = "고씨네카레", time = "25분", score = "5.0", num = "(2,691)",
                    imageUrl = "https://cdn.pixabay.com/photo/2015/10/01/14/29/curry-967086_1280.jpg"
                ),
                MenuLatelyData(
                    title = "삼거리닭발", time = "20분", score = "4.6", num = "(3,482)",
                    imageUrl = "https://cdn.pixabay.com/photo/2018/05/02/03/03/food-3367643_1280.jpg"
                ), MenuLatelyData(
                    title = "장터국밥", time = "27분", score = "4.8", num = "(724)",
                    imageUrl = "https://cdn.pixabay.com/photo/2019/07/07/10/40/for-money-4322226_1280.jpg"
                ), MenuLatelyData(
                    title = "굽네치킨", time = "45분", score = "4.9", num = "(1,903)",
                    imageUrl = "https://cdn.pixabay.com/photo/2020/05/22/12/16/chicken-drumsticks-5205207_1280.jpg"
                )


            )
        )
    }

}

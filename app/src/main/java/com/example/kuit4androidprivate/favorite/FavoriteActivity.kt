package com.example.kuit4androidprivate.favorite

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit4androidprivate.adapter.Favorite_RVAdapter
import com.example.kuit4androidprivate.databinding.ActivityFavoriteBinding
import com.example.kuit4androidprivate.model.MenuData

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding
    private val items = ArrayList<MenuData>()
    private lateinit var rvAdapter: Favorite_RVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initItems()
        initRVAdapter()


        binding.ivFavoriteBack.setOnClickListener {
            finish()
        }
    }

    private fun initItems() {
        items.addAll(
            arrayListOf(
                MenuData("초밥", "35분", "https://cdn.pixabay.com/photo/2020/05/08/02/42/sushi-5143892_640.jpg", "3.9", "(1200)"),
                MenuData("족발", "45분", "https://cdn.pixabay.com/photo/2021/10/17/16/55/spicy-jokbal-6718937_640.jpg", "3.6", "(390)"),
                MenuData("쌀국수", "25분", "https://cdn.pixabay.com/photo/2023/05/27/12/35/noodles-8021415_640.png", "3.8", "(870)"),
                MenuData("돈가스", "45분", "https://cdn.pixabay.com/photo/2018/03/21/03/49/food-3245489_640.jpg", "4.0", "(1500)"),
                MenuData("칼국수", "25분", "https://cdn.pixabay.com/photo/2020/05/12/08/01/kalguksu-5161719_640.jpg", "4.1", "(290)"),
                MenuData("아워떡볶이", "30분", "https://cdn.pixabay.com/photo/2017/07/27/16/48/toppokki-2545943_640.jpg", "4.9", "(3849)"),
                MenuData("치킨", "45분", "https://cdn.pixabay.com/photo/2017/06/26/13/58/chicken-2443901_640.jpg", "4.0", "(2002)"),
                MenuData("파스타", "25분", "https://cdn.pixabay.com/photo/2018/07/18/19/12/pasta-3547078_1280.jpg", "3.8", "(500)"),
                MenuData("피자", "35분", "https://cdn.pixabay.com/photo/2017/12/09/08/18/pizza-3007395_1280.jpg", "4.1", "(380)"),
                MenuData("짜장면", "20분", "https://media.istockphoto.com/id/1468239564/ko/%EC%82%AC%EC%A7%84/jajangmyeon-%EC%A7%9C%EC%9E%A5%EB%A9%B4.jpg?s=2048x2048&w=is&k=20&c=H32zSqAiOpKb7TLYn1iQScoEUB5x-dIbrtCYSFxyueE=", "3.7", "(800)")
            )
        )
    }

    private fun initRVAdapter() {

        rvAdapter = Favorite_RVAdapter(this, items)
        binding.rvFavoriteRestaurant.adapter = rvAdapter
        binding.rvFavoriteRestaurant.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}
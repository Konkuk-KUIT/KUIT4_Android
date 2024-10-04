package com.example.kuit4androidprivate.favorite

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.adapter.RVAdapter
import com.example.kuit4androidprivate.databinding.ActivityFavoriteBinding
import com.example.kuit4androidprivate.detail.DetailActivity
import com.example.kuit4androidprivate.model.MenuData


class FavoriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavoriteBinding
    private lateinit var rvAdapter: RVAdapter
    private var dummyItems = ArrayList<MenuData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initDummy()
        initRVAdapter()

        binding.ivBack.setOnClickListener { finish() }
    }

    private fun initDummy() {
        dummyItems.addAll(
            arrayListOf(
                MenuData(
                    "https://media.istockphoto.com/id/1152570620/ko/%EC%82%AC%EC%A7%84/%EB%A7%A4%EC%9A%B4-%EB%96%A1.jpg?s=1024x1024&w=is&k=20&c=prL7yZ5TriVWZAuL5fg8I0Nyaw4stPNi6zgaA3zUBCg=",
                    "아워떡볶이",
                    "30분",
                    "4.5",
                    "(3,999)"
                ), MenuData(
                    "https://media.istockphoto.com/id/1368607122/ko/%EC%82%AC%EC%A7%84/%EB%B0%94%EC%82%AD%EB%B0%94%EC%82%AD%ED%95%9C-%EB%B9%B5%EC%9D%84-%ED%8A%80%EA%B8%B4-%EB%8B%AD%EA%B3%A0%EA%B8%B0-%EC%8A%A4%ED%8A%B8%EB%A6%BD-%EC%A0%91%EC%8B%9C%EC%97%90-%ED%86%A0%EB%A7%88%ED%86%A0-%EC%BC%80%EC%B2%A9%EC%9D%84-%EA%B3%81%EB%93%A4%EC%9D%B8-%EC%9C%A0%EB%B0%A9-%ED%95%84%EB%A0%9B-%EA%B3%A0%EA%B8%B0-%EB%82%98%EB%AC%B4-%EB%B0%B1%EA%B7%B8%EB%A3%AC-%EC%9C%84%EC%AA%BD-%EB%B3%B4%EA%B8%B0.jpg?s=612x612&w=0&k=20&c=xaB06WcG-eAjPlJTL0TDLu4FvCkDJ2FyYXfo_kPcC70=",
                    "신통치킨",
                    "25분",
                    "4.3",
                    "(3,000)"
                ), MenuData(
                    "https://media.istockphoto.com/id/1462352351/ko/%EC%82%AC%EC%A7%84/pho.jpg?s=1024x1024&w=is&k=20&c=8T2i6n1Pl2e1rw4-eeSpmmDhLNX2BAst34satRMUfhg=",
                    "미분당",
                    "13분",
                    "3.5",
                    "(1,023)"
                ), MenuData(
                    "https://media.istockphoto.com/id/1442417585/ko/%EC%82%AC%EC%A7%84/%EC%B9%98%EC%A6%88-%ED%8E%98%ED%8D%BC%EB%A1%9C%EB%8B%88-%ED%94%BC%EC%9E%90-%ED%95%9C-%EC%A1%B0%EA%B0%81%EC%9D%84-%EB%A8%B9%EB%8A%94-%EC%82%AC%EB%9E%8C.jpg?s=1024x1024&w=is&k=20&c=3DbLxIf6WkhVCoTHoOGhIThDvlfEYdP680HdcUS7ygc=",
                    "도미노피자",
                    "22분",
                    "3.7",
                    "(1,333)"
                ), MenuData(
                    "https://media.istockphoto.com/id/157640612/ko/%EC%82%AC%EC%A7%84/jajangmyeon-%EB%B8%94%EB%9E%99-bean-%EC%86%8C%EC%8A%A4-%EB%88%84%EB%93%A4%EC%8A%A4.jpg?s=1024x1024&w=is&k=20&c=LSVbtasaMTUCT9lM5ZgzeVbofybYUHulRMbgtv4OVUs=",
                    "홍콩반점",
                    "21분",
                    "2.2",
                    "(300)"
                ), MenuData(
                    "https://media.istockphoto.com/id/1189709277/ko/%EC%82%AC%EC%A7%84/%EA%B5%AC%EC%9A%B4-%ED%86%A0%EB%A7%88%ED%86%A0-%EC%86%8C%EC%8A%A4-%EB%AA%A8%EC%A7%9C%EB%A0%90%EB%9D%BC-%EC%B9%98%EC%A6%88%EB%A5%BC-%EA%B3%81%EB%93%A4%EC%9D%B8-%ED%8C%8C%EC%8A%A4%ED%83%80-%ED%8E%98%EB%84%A4-%ED%9A%8C%EC%83%89-%EB%8F%8C-%EB%B0%B0%EA%B2%BD%EC%9E%85%EB%8B%88%EB%8B%A4-%EB%A7%A8-%EC%9C%84-%EB%B3%B4%EA%B8%B0.jpg?s=1024x1024&w=is&k=20&c=j6eP1j1kgbbVd40x30kXJ7An2DFSqs8AQWvc4nan8_I=",
                    "서가앤쿡",
                    "13분",
                    "4.9",
                    "(2,143)"
                ), MenuData(
                    "https://media.istockphoto.com/id/610264540/ko/%EC%82%AC%EC%A7%84/%EC%BC%80%EC%9D%B4%EC%A4%80-%EC%83%88%EC%9A%B0%EC%9A%94.jpg?s=1024x1024&w=is&k=20&c=QvEeEC2vpA5WdinXT4E0SXygI5ysaEAe_9VZXgisxaU=",
                    "새우탕탕",
                    "26분",
                    "3.4",
                    "(1,490)"
                ), MenuData(
                    "https://media.istockphoto.com/id/694747604/ko/%EC%82%AC%EC%A7%84/curry.jpg?s=1024x1024&w=is&k=20&c=LwApGTRIzslVcssrHxdjeNq6WPU71-QLHfM_nJ9bmt8=",
                    "아비꼬카레",
                    "44분",
                    "3.3",
                    "(2,132)"
                ), MenuData(
                    "https://media.istockphoto.com/id/525528747/ko/%EC%82%AC%EC%A7%84/%EC%97%B0%EB%A3%8C%EC%A6%9D%EA%B8%B0-%EC%A1%B1%EB%B0%9C-%EA%B7%B8%EB%A0%88%EC%9D%B4%EB%B9%84.jpg?s=1024x1024&w=is&k=20&c=zZbjRFaptHPqgGWqTlXzbIx2p_HSuJT3qW7B6Vwaps0=",
                    "건대족발",
                    "25분",
                    "3.2",
                    "4,532"
                ), MenuData(
                    "https://media.istockphoto.com/id/467867830/ko/%EC%82%AC%EC%A7%84/%EC%9D%BC%EB%B3%B8-%EC%9D%8C%EC%8B%9D-gyoza.jpg?s=1024x1024&w=is&k=20&c=IiMY_sjhoIiaq3RwgXpwnaP2UVxkrMW58rvHcfalEuM=",
                    "왕손만두",
                    "11분",
                    "3.1",
                    "(9,432)"
                )
            )

        )
    }

    private fun initRVAdapter() {
        rvAdapter = RVAdapter(this, dummyItems) { item ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("title", item.title)
                putExtra("imageUrl", item.imageUrl)
                putExtra("review", item.review)
                putExtra("count", item.count)
            }
            startActivity(intent)
        }
        binding.tvFavoriteScroll.adapter = rvAdapter
        binding.tvFavoriteScroll.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}

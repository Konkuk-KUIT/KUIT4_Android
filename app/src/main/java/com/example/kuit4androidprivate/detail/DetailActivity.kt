package com.example.kuit4androidprivate.detail

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.kuit4androidprivate.databinding.ActivityDetailBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private var currentPage = 0
    private val mHandler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivDetailBack.setOnClickListener {
            finish()
        }

        val detailTopViewPageAdapter = DetailTopViewPageAdapter()
        binding.vpDetailTop.adapter = detailTopViewPageAdapter

        binding.tvDetailVp.text = "1/3"

        binding.vpDetailTop.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.tvDetailVp.text = "${position + 1}/3"
                currentPage = position
            }
        })

        //vpSwipeThread()
        vpSwipeCoroutine()

        val adapter = DetailFragmentAdapter(this)
        binding.vpDetail.adapter = adapter

        TabLayoutMediator(binding.tlDetail, binding.vpDetail) { tab, position ->
            tab.text = when (position) {
                0 -> "배달 30분"
                1 -> "포장 15분"
                else -> null
            }
        }.attach()
    }

    private fun vPSwipeThread() {
        mHandler.postDelayed({
            swipePage()
            vPSwipeThread()
        }, 3000)
    }

    private fun vpSwipeCoroutine() {
        CoroutineScope(Dispatchers.Default).launch {
            while (true) {
                delay(3000)
                withContext(Dispatchers.Main) {
                    swipePage()
                }
                Log.d("페이지 : ", "$currentPage")
            }
        }
    }

    private fun swipePage() {
        val pageCount = binding.vpDetailTop.adapter?.itemCount ?: 0
        if (pageCount > 0) {
            currentPage = (currentPage + 1) % pageCount
            binding.vpDetailTop.setCurrentItem(currentPage, true)
        }
    }

}

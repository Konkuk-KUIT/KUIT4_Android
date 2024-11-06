package com.example.kuit4androidprivate.detail

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.adapter.HomeImageRVAdapter
import com.example.kuit4androidprivate.data.MenuData
import com.example.kuit4androidprivate.data.ScrollImageData
import com.example.kuit4androidprivate.databinding.ActivityDetailBinding
import com.example.kuit4androidprivate.detail.adapter.DetailVPAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailActivity : AppCompatActivity() {

    private lateinit var binding:ActivityDetailBinding
    private lateinit var detailVPAdapter: DetailVPAdapter
    private lateinit var detailMenuVPAdapter: HomeImageRVAdapter
    private var tabItems = arrayListOf("배달", "포장")
    private var detailMenuItems = arrayListOf(
        ScrollImageData(R.drawable.img_tteokbokki_detail, 1),
        ScrollImageData(R.drawable.img_vp_tteokbokki_2, 2),
        ScrollImageData(R.drawable.img_vp_tteokbokki_3, 3)
    )
    private var currentPage = 0
    private var mHandler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Base_Theme_Kuit4AndroidPrivate2)
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ivDetailArrow.setOnClickListener{
            finish()
        }

        val menuData: MenuData = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("menuData", MenuData::class.java)!!
        }else {
            intent.getSerializableExtra("menuData") as MenuData
        }


        binding.tvDetailMenu.text = menuData.name
        binding.tvDetailScore.text = menuData.score
        binding.tvDetailReview.text = menuData.review

        detailMenuVPAdapter = HomeImageRVAdapter(this, detailMenuItems)
        binding.vpDetailMenu.adapter = detailMenuVPAdapter

        detailVPAdapter = DetailVPAdapter(this)
        binding.vpDetail.adapter = detailVPAdapter

        TabLayoutMediator(binding.tlDetail, binding.vpDetail) { tab, position->
            tab.text = tabItems[position]
        }.attach()

//        initVPSwipeThread()
        initVPSwipeCoroutine()
    }

    private fun SwipePage(){
        with(binding.vpDetailMenu) {
            setCurrentItem(currentPage, true)
            currentPage++
        }
    }

    // 스레드로 구현
    private fun initVPSwipeThread(){
        mHandler.postDelayed({
            SwipePage()
            initVPSwipeThread()
        }, 2000)
    }

    // 코루틴으로 구현
    private fun initVPSwipeCoroutine() {
        CoroutineScope(Dispatchers.Default).launch {
            while(true) {
                delay(2000)
                withContext(Dispatchers.Main) {
                    SwipePage()
                }
            }
        }
    }


}
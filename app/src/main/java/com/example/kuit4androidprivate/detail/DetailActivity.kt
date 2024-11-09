package com.example.kuit4androidprivate.detail

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.kuit4androidprivate.FavoritesOrderViewPagerFragment
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.adapter.DetailStoreVPAdapter
import com.example.kuit4androidprivate.adapter.HomeBottomVPAdapter
import com.example.kuit4androidprivate.databinding.ActivityDetailBinding
import com.example.kuit4androidprivate.databinding.MenuFavoritesItemBinding
import com.example.kuit4androidprivate.model.DetailStoreData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var favoritesItemBinding: MenuFavoritesItemBinding
    private var tabItems = arrayListOf<String>(
        "배달 30분","포장 15분"
    )
    private var itemDummys = ArrayList<DetailStoreData>()
    private var currentPosition = 0;
    private var mHandler = Handler(Looper.getMainLooper())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("title")
        val score = intent.getStringExtra("score")
        val num = intent.getStringExtra("num")

        binding.tvDetailStoreName.text = title
        binding.tvDetailScore.text = score
        binding.tvDetailNum.text = num

        val parentFragment = FavoritesOrderViewPagerFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcv_detail_page, parentFragment)
            .commit()

        binding.ivDetailBackButton.setOnClickListener() {
            finish()
        }

        initItemDummys()
        binding.vpDetailStore.adapter = DetailStoreVPAdapter().apply {
            submitList(itemDummys)
        }

        binding.vpDetailStore.currentItem = itemDummys.size * 100


        // initVPSwipe()
        initVPSwipe2()

    }

    private fun initItemDummys() {
        itemDummys.addAll(
            arrayListOf(
                DetailStoreData(
                    imageResId = R.drawable.img_detail_store,
                    id = 1
                ),
                DetailStoreData(
                    imageResId = R.drawable.img_detail_store2,
                    id = 2
                ),
                DetailStoreData(
                    imageResId = R.drawable.img_detail_store3,
                    id = 3
                )
            )
        )
    }

    private fun swipePage() {
        with(binding.vpDetailStore) {
            currentPosition = (currentPosition + 1) % itemDummys.size
            setCurrentItem(currentPosition, true);
        }
    }
    private fun initVPSwipe() {
        mHandler.postDelayed(object : Runnable{
            override fun run() {
                swipePage() // 3초마다 호출되는 작업
                // 다음실행을 3초후에 예약
                mHandler.postDelayed(this,5000)

            }
        },5000) // 첫시작 3초후에
    }

    private fun initVPSwipe2(){
        CoroutineScope(Dispatchers.Default).launch {
            while(true){
                delay(5000)
                withContext(Dispatchers.Main){
                    swipePage()
                }

            }
        }
    }

}
package com.example.kuit4androidprivate.detail

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.adapter.DetailRestaurantImageRVAdapter
import com.example.kuit4androidprivate.adapter.RestaurantImageRVAdapter
import com.example.kuit4androidprivate.databinding.ActivityDetailBinding
import com.example.kuit4androidprivate.model.MenuCategoryData
import com.example.kuit4androidprivate.model.MenuData
import com.example.kuit4androidprivate.model.RestaurantImageData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Thread.sleep
import java.util.concurrent.ThreadLocalRandom.current


class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private var restaurantImageURLItems = ArrayList<Int>()
    private var restaurantImageItems = ArrayList<RestaurantImageData>()

    private var currentPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Base_Theme_Kuit4AndroidPrivate2)
        super.onCreate(savedInstanceState)

        //window.statusBarColor = ContextCompat.getColor(this, R.color.light_blue)

        binding = ActivityDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.root

        val menuData = intent.getSerializableExtra("menuData") as? MenuData

        if (menuData != null) {
            binding.tvDetailRestaurant.text = menuData.title
            binding.tvDetailRate.text = menuData.reviewScore
            binding.tvDetailReviewcount.text = menuData.reviewCount

            /*Glide.with(this)
                .load(menuData.imageUrl)
                .into(binding.ivDetailRestaurant)*/
        }
        binding.ivDetailBack.setOnClickListener {
            finish()
        }

        initRestaurantImg()
        initdetailVP()
        //initVPSwipeThread()
        initVPSwipeCoroutine()

        binding.vpDetailRestaurant.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tvDetailIndex.text = "%d / 3".format(position%3+1)
            }
        })

    }

    private fun initRestaurantImg() {
        restaurantImageURLItems = arrayListOf(
            R.drawable.img_restaurant_detail,
            R.drawable.img_restaurant_detail2,
            R.drawable.img_restaurant_detail3
        )
        for (i in 1 until 4){
            restaurantImageItems.add(
                RestaurantImageData(
                    id = restaurantImageURLItems[i-1],
                    imgURL = "image"
                )
            )
        }
    }

    private fun initdetailVP() {
        binding.vpDetailRestaurant.adapter = DetailRestaurantImageRVAdapter().apply {
            submitList(restaurantImageItems)
        }
        binding.vpDetailRestaurant.currentItem = 0
    }


    private fun swipePage() {
        with(binding.vpDetailRestaurant){
            if(currentPosition>2) currentPosition = 0
            setCurrentItem(currentPosition, true)
            currentPosition++
        }
    }

    private fun initVPSwipeThread(){
        Thread(swipeRunnable()).start()
    }

    inner class mainHandler : Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            swipePage()
            super.handleMessage(msg)
        }
    }

    inner class swipeRunnable(): Runnable {
        override fun run() {
            while(true) {
                sleep(3000)
                mainHandler().sendEmptyMessage(0)
            }
        }

    }

    private fun initVPSwipeCoroutine() {
        CoroutineScope(Dispatchers.Default).launch {
            while(true){
                delay(3000)
                withContext(Dispatchers.Main){
                    swipePage()
                }
            }
        }
    }

}
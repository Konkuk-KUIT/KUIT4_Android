package com.example.kuit4androidprivate.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.detail.adapter.CardDetailVPAdapter
import com.example.kuit4androidprivate.detail.adapter.DetailVPAdapter
import com.example.kuit4androidprivate.databinding.ActivityDetailBinding
import com.example.kuit4androidprivate.model.CardData
import com.example.kuit4androidprivate.model.MenuData
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailActivity : AppCompatActivity() {
    private var cardDetailCardItems = ArrayList<CardData>()
    private var currentPosition=0
    private lateinit var binding: ActivityDetailBinding
    private var tabItems =arrayListOf<String>(
        "배달 30분","포장 15분"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
//        setTheme(R.style.Base_Theme_Kuit4AndroidPrivate2)
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val item = intent.getSerializableExtra("item_data") as? MenuData
        item?.let {
            binding.tvDetailStoreName.text = item.name
            binding.tvDetailVisitNumber.text = item.visitNumber
            binding.tvDetailRatingNumber.text = item.ratingNumber
        }

        initBackIconImgListener()
        initFragmentAdapter()

        initDetailCardItems()
        initDetailCardVP()
        initDetailCardIndex()
        initVPSwipe()
    }
    private fun initDetailCardItems() {
        cardDetailCardItems.addAll(
            arrayListOf(
                CardData(
                    1,"",R.drawable.home_food
                ),
                CardData(
                    2, "",R.drawable.img_detail_item_snack_food
                ),
                CardData(
                    3, "",R.drawable.img_main_snack_food
                )
            )
        )
    }

    private fun initDetailCardIndex() {
        binding.vpDetailCard.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tvHomeVpIndex.text = "${(position) % 3 + 1}/3"
            }
        })
    }


    private fun initDetailCardVP() {
        binding.vpDetailCard.adapter = CardDetailVPAdapter().apply {
            submitList(cardDetailCardItems)
        }
    }




    private fun initFragmentAdapter() {
        binding.vpDetail.adapter= DetailVPAdapter(this)
        TabLayoutMediator(binding.tlDetail,binding.vpDetail){
            tab,position->
            tab.text=tabItems[position]
        }.attach()
    }

    private fun initBackIconImgListener() {
        binding.ivDetailBack.setOnClickListener {//fragment는 context가 없음
            finish()
        }
    }

    private fun swipePage(){
        with(binding.vpDetailCard){
            setCurrentItem(currentPosition)
            currentPosition++
        }
    }
    private fun initVPSwipe(){
        CoroutineScope(Dispatchers.Default).launch {
            while(true){
                launch {
                    delay(3000)
                }.join()
                withContext(Dispatchers.Main){
                    swipePage()
                }
            }
        }
    }
}
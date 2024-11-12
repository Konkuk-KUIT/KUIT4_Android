package com.example.kuit4androidprivate.detail

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.adapter.VPAdapterDetail
import com.example.kuit4androidprivate.databinding.ActivityDetailBinding
import com.example.kuit4androidprivate.model.DetailMenuData
import com.example.kuit4androidprivate.model.MenuData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Thread.sleep

class DetailActivity: AppCompatActivity() {

    private lateinit var binding : ActivityDetailBinding
    private var vpItems = arrayListOf<DetailMenuData>()

    private var currentPosition = 0
    private var mHandler = Handler(Looper.getMainLooper())
    private var threadIsRunning = true //thread 실행 여부를 나타내는 변수
    private var job: Job? = null //coroutine이 만든 job 객체 저장할 변수

    override fun onCreate(savedInstanceState: Bundle?) {
        //setTheme으로 Activity의 theme 지정, 소속된 fragment, item들에도 적용됨
        //xml 파일에서 android:textColor="?attr/colorPrimary"와 같이 사용 가능
        setTheme(R.style.Base_Theme_Kuit4AndroidPrivate2)
        super.onCreate(savedInstanceState)

        //상태 바 색상 변경 테스트
//        window.statusBarColor = ContextCompat.getColor(this, R.color.light_blue)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val menuData: MenuData
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            menuData = intent.extras?.getParcelable("menuData",MenuData::class.java)!!
        }else{
            menuData = intent.extras?.getParcelable("menuData")!!
        }

        initVPData()
        initVPAdapterDetail()
        //thread 사용해서 swipe
//        initSwipeVPDetailThread()
        //coroutine 사용해서 swipe
        initSwipeVPDetailCoroutine()

        binding.tvDetailRestaurantName.text = menuData.restaurantName
        binding.tvDetailRating.text = menuData.rating
        binding.tvDetailTotalReview.text = menuData.totalReviews


        binding.ivDetailBack.setOnClickListener {
            finish()
        }

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.detail_frm, DetailContainerFragment())
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("end_message","thread or coroutine 종료")
        //thread 멈추도록 변수 값 설정
        threadIsRunning = false
        //coroutine 멈추는 코드
        job?.cancel()
    }

    private fun initVPAdapterDetail() {
        binding.vpDetailRestaurant.adapter = VPAdapterDetail(vpItems.size).apply{
            submitList(vpItems)
        }

        binding.vpDetailRestaurant.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                // ViewPager의 현재 페이지 번호 계산 (무한 스크롤을 고려한 % 연산)
                val currentPage = (position % vpItems.size) + 1 // 현재 페이지는 1부터 시작
                val totalPageCount = vpItems.size // 전체 페이지 수

                // TextView에 현재 페이지와 총 페이지 수 반영
                binding.tvHomeVpPage.text = "$currentPage/$totalPageCount"
            }
        })
    }


    private fun initVPData() {
        vpItems = arrayListOf(
            DetailMenuData(
                "아워떡볶이1",
                R.drawable.img_detail_restaurant,
                "5,000원"
            ),
            DetailMenuData(
                "아워떡볶이2",
                R.drawable.img_detail_restaurant2,
                "5,000원"
            ),
            DetailMenuData(
                "아워떡볶이3",
                R.drawable.img_detail_restaurant3,
                "5,000원"
            ),
        )
    }

    //클릭하면 코루틴 멈추고 떼면 그 시점의 currentPosition 받아오도록 개선?
    private fun swipePage(){
        with(binding.vpDetailRestaurant){
            if(currentPosition > 2)
                currentPosition = 0
            setCurrentItem(currentPosition,true)
            currentPosition++
        }
    }

    private fun initSwipeVPDetailThread(){
        Thread(SwipeRunnable()).start()
    }

    inner class MainHandler : Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            swipePage()
            super.handleMessage(msg)
        }
    }

    inner class SwipeRunnable: Runnable{
        var count = 0
        override fun run() {
            //threadIsRunning이 true일 때에만 실행하도록
            while(threadIsRunning){
                sleep(5000)
                MainHandler().sendEmptyMessage(0)
                count++
                Log.d("thread_test","$count")
            }
        }
    }

    private fun initSwipeVPDetailCoroutine(){
        var count = 0
        job = CoroutineScope(Dispatchers.Main).launch{
            while(true){
                delay(5000)
                withContext(Dispatchers.Main){
                    swipePage()
                    count++
                }
                Log.d("coroutine_test","$count")
            }
        }
    }
}
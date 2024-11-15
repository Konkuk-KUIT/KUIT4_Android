package com.example.kuit4androidprivate.home


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit4androidprivate.FavoriteActivity
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.adapter.HomeBottomVPAdapter
import com.example.kuit4androidprivate.adapter.MenuCategoryRVAdapter
import com.example.kuit4androidprivate.adapter.MenuDataRVAdapter
import com.example.kuit4androidprivate.databinding.FragmentHomeBinding
import com.example.kuit4androidprivate.databinding.ItemHomeBottomBinding
import com.example.kuit4androidprivate.detail.DetailActivity
import com.example.kuit4androidprivate.model.HomeBottomData
import com.example.kuit4androidprivate.model.MenuCategoryDB
import com.example.kuit4androidprivate.model.MenuCategoryData
import com.example.kuit4androidprivate.model.MenuLatelyDB
import com.example.kuit4androidprivate.model.MenuLatelyData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Thread.sleep


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var categoryRVAdapter: MenuCategoryRVAdapter
    private lateinit var latelyRVAdapter: MenuDataRVAdapter
    private val dummyItemsLately = ArrayList<MenuLatelyData>()
    private val dummyItemsCategory = ArrayList<MenuCategoryData>()
    private val dummyItemsHomeBottom = ArrayList<HomeBottomData>()
    private lateinit var itemHomeBottomBinding: ItemHomeBottomBinding

    private var currentPosition = 0
    private var mHandler = Handler(Looper.getMainLooper())

    private lateinit var menuCategoryDB: MenuCategoryDB
    private lateinit var menuLatelyDB: MenuLatelyDB

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.sivHomeButton.setOnClickListener() {
            val intent = Intent(requireActivity(), FavoriteActivity::class.java)
            startActivity(intent)
        }
        CoroutineScope(Dispatchers.IO).launch {
            initCategory()
            initLately()

            withContext(Dispatchers.Main) {
                initCategoryRVAdapter()
                initLatelyRVAdapter()
            }
        }
        initBottomData()
        initHomeBottomVP()
        initEditText()
        initVPSwipe5()
        return binding.root
    }

    private fun initEditText() {
        binding.etHomeSuggestion.setOnEditorActionListener { textView, i, keyEvent ->
            if (i == EditorInfo.IME_ACTION_SEARCH) {
                val imm =
                    requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(binding.etHomeSuggestion.windowToken, 0)

                binding.etHomeSuggestion.clearFocus()

                true
            } else {
                false
            }
        }
    }

//    override fun dispatchTouchEvent(ev : MotionEvent) : Boolean{
//        if(ev.action == MotionEvent.ACTION_DOWN){
//            val v = currentFocus
//            if(v is EditText){
//                val outRect = Rect()
//                v.getGlobalVisibleRect(outRect)
//                if(!outRect.contains(ev.rawX.toInt(), ev.rawY.toInt())){
//                    hideKeyboard(v)
//                }
//            }
//
//        }
//        return super.dispatchTouchEvent(ev)
//    }

//    private fun hideKeyboard(view : View){
//        view.clearFocus()
//        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        imm.hideSoftInputFromWindow(view.windowToken,0)
//    }

    private fun initHomeBottomVP() {
        binding.vpMainBottom.adapter = HomeBottomVPAdapter().apply {
            submitList(dummyItemsHomeBottom)
        }

        binding.vpMainBottom.currentItem = 1000

    }

    private fun initBottomData() {
        dummyItemsHomeBottom.addAll(
            arrayListOf(
                HomeBottomData(
                    imageUrl = "https://cdn.pixabay.com/photo/2017/12/10/14/47/pizza-3010062_1280.jpg",
                    id = 1
                ),
                HomeBottomData(
                    imageUrl = "https://cdn.pixabay.com/photo/2019/12/01/15/08/if-the-4665686_1280.jpg",
                    id = 2
                ),
                HomeBottomData(
                    imageUrl = "https://cdn.pixabay.com/photo/2019/08/15/09/00/pilaf-4407500_1280.jpg",
                    id = 3
                ),
                HomeBottomData(
                    imageUrl = "https://cdn.pixabay.com/photo/2019/09/05/01/08/food-4452840_1280.jpg",
                    id = 4
                ), HomeBottomData(
                    imageUrl = "https://cdn.pixabay.com/photo/2018/08/10/12/17/mohinga-3596735_1280.jpg",
                    id = 5
                )
            )
        )
    }


    private fun initLately() {
        val spf_menuLately: SharedPreferences =
            requireContext().getSharedPreferences("menu_lately", Context.MODE_PRIVATE)

        menuLatelyDB = MenuLatelyDB.getInstance(requireContext())

        // isInit 확인
        if (!spf_menuLately.getBoolean("isInit", false)) { // 아직 초기화되지 않은 경우
            with(spf_menuLately.edit()) {
                putBoolean("isInit", true) // true로 저장하여 다음에 데이터 삽입 안 되도록
                apply()
            }

            menuLatelyDB.menuLatelyDao().apply {
                insert(
                    MenuLatelyData(
                        title = "아워떡볶이", time = "30분", score = "4.9", num = "(3,849)",
                        imageUrl = "https://cdn.pixabay.com/photo/2017/09/10/14/23/toppokki-2735719_1280.jpg"
                    )
                )
                insert(
                    MenuLatelyData(
                        title = "홍대돈부리", time = "33분", score = "5.0", num = "(1,356)",
                        imageUrl = "https://cdn.pixabay.com/photo/2019/12/01/15/08/salmon-plate-with-rice-4665684_1280.jpg"
                    )
                )
                insert(
                    MenuLatelyData(
                        title = "가람성", time = "15분", score = "4.8", num = "(971)",
                        imageUrl = "https://cdn.pixabay.com/photo/2020/08/22/14/49/fried-rice-5508576_1280.jpg"
                    )
                )
                insert(
                    MenuLatelyData(
                        title = "부리또피아", time = "23분", score = "4.9", num = "(2,252)",
                        imageUrl = "https://cdn.pixabay.com/photo/2020/06/01/15/37/tortilla-5247120_1280.jpg"
                    )
                )
                insert(
                    MenuLatelyData(
                        title = "미분당", time = "35분", score = "4.7", num = "(471)",
                        imageUrl = "https://cdn.pixabay.com/photo/2023/05/27/12/35/noodles-8021415_1280.png"
                    )
                )
                insert(
                    MenuLatelyData(
                        title = "고씨네카레", time = "25분", score = "5.0", num = "(2,691)",
                        imageUrl = "https://cdn.pixabay.com/photo/2015/10/01/14/29/curry-967086_1280.jpg"
                    )
                )
                insert(
                    MenuLatelyData(
                        title = "삼거리닭발", time = "20분", score = "4.6", num = "(3,482)",
                        imageUrl = "https://cdn.pixabay.com/photo/2018/05/02/03/03/food-3367643_1280.jpg"
                    )
                )
                insert(
                    MenuLatelyData(
                        title = "장터국밥", time = "27분", score = "4.8", num = "(724)",
                        imageUrl = "https://cdn.pixabay.com/photo/2019/07/07/10/40/for-money-4322226_1280.jpg"
                    )
                )
                insert(
                    MenuLatelyData(
                        title = "굽네치킨", time = "45분", score = "4.9", num = "(1,903)",
                        imageUrl = "https://cdn.pixabay.com/photo/2020/05/22/12/16/chicken-drumsticks-5205207_1280.jpg"
                    )
                )
            }

        }
        dummyItemsLately.addAll(
            menuLatelyDB.menuLatelyDao().getAll()
        )
    }

    private fun initCategory() {

        val spf_menuCategory: SharedPreferences =
            requireContext().getSharedPreferences("menu_category", Context.MODE_PRIVATE)

        menuCategoryDB = MenuCategoryDB.getInstance(requireContext())
//        menuCategoryDB = Room.databaseBuilder(
//            requireContext(),
//            MenuCategoryDB::class.java,
//            "menu_category_database"
//        ).allowMainThreadQueries().build()

        if (!spf_menuCategory.getBoolean("isInit", false)) {  // 아직 초기화되지 않은 경우
            with(spf_menuCategory.edit()) {   // 편집모드로 전환
                putBoolean("isInit", true)   //true저장
                apply()
            }
            menuCategoryDB.menuCategoryDao().apply {
                insert(MenuCategoryData("돈까스", R.drawable.img_home_porkcutlet))
                insert(MenuCategoryData("일식", R.drawable.img_home_japanesefood))
                insert(MenuCategoryData("한식", R.drawable.img_home_koreanfood))
                insert(MenuCategoryData("치킨", R.drawable.img_home_chicken))
                insert(MenuCategoryData("분식", R.drawable.img_home_snackfood))
                insert(MenuCategoryData("족발/보쌈", R.drawable.img_home_jokbal))
                insert(MenuCategoryData("찜/탕", R.drawable.img_home_soup))
                insert(MenuCategoryData("구이", R.drawable.img_home_roast))
                insert(MenuCategoryData("피자", R.drawable.img_home_pizza))


            }
        }
        dummyItemsCategory.addAll(
            menuCategoryDB.menuCategoryDao().getAll()
        )

    }

    private fun initLatelyRVAdapter() {
        latelyRVAdapter = MenuDataRVAdapter(this, dummyItemsLately) { item ->
            val intent = Intent(requireActivity(), DetailActivity::class.java).apply {
                putExtra("title", item.title)
                putExtra("imageUrl", item.imageUrl)
                putExtra("score", item.score)
                putExtra("num", item.num)
            }
            startActivity(intent)

        }
        binding.rvMenuRecently.adapter = latelyRVAdapter
        binding.rvMenuRecently.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }

    private fun initCategoryRVAdapter() {
        categoryRVAdapter = MenuCategoryRVAdapter(this, dummyItemsCategory)
        binding.rvMenuCategory.adapter = categoryRVAdapter
        binding.rvMenuCategory.layoutManager = GridLayoutManager(requireContext(), 5)



    }


    //    private fun initVPSwipe1(){
//        while(true){
//            Thread.sleep(3000)
//            swipePage()
//        }
//    }
//    private fun initVPSwipe2(){
//        var swipeThread = SwipeThread()
//        swipeThread.start()
//    }
//    inner class  SwipeThread : Thread(){
//        override fun run() {
//            while(true){
//                sleep(3000)
//                swipePage()
//            }
//        }
//    }
    private fun swipePage() {
        with(binding.vpMainBottom) {
            if (currentPosition > 4) currentPosition = 0
            setCurrentItem(currentPosition, true);
            currentPosition++;
        }
    }

    private fun initVPSwipe3() {
        Thread(swipeRunnable()).start() // 백그라운드에서 실행
    }

    inner class mainHandler : Handler(Looper.getMainLooper()) { // 이 핸들러는 메인 루퍼와 연결됨
        override fun handleMessage(msg: Message) {
            swipePage()
            super.handleMessage(msg)
        }
    }

    inner class swipeRunnable : Runnable {
        override fun run() {
            while (true) {
                sleep(3000)
                mainHandler().sendEmptyMessage(0)
            }
        }
    }

//    private fun initVPSwipe4(){
//        mainHandler2().sendEmptyMessage(0)
//    }
//    inner class mainHandler2 : Handler(Looper.getMainLooper()){
//        override fun handleMessage(msg: Message) {
//            swipePage()
//            Thread.sleep(3000)
//            mainHandler2().sendEmptyMessage(0) // 자기 자신한테 계속 메시지 보냄
//            super.handleMessage(msg)
//        }
//    }

    private fun initVPSwipe5() {
        mHandler.postDelayed(object : Runnable {
            override fun run() {
                swipePage() // 3초마다 호출되는 작업
                // 다음실행을 3초후에 예약
                mHandler.postDelayed(this, 3000)

            }
        }, 3000) // 첫시작 3초후에
    }

    private fun initVPSwipe6() {
        mHandler.postDelayed({
            swipePage()
            initVPSwipe6()
        }, 3000)
    }

    private fun initVPSwipe7() {
        CoroutineScope(Dispatchers.Default).launch {
            while (true) {
                delay(3000)
                withContext(Dispatchers.Main) {
                    swipePage()
                }

            }
        }
    }

}
package com.example.kuit4androidprivate.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.kuit4androidprivate.DetailActivity
import com.example.kuit4androidprivate.FavoriteActivity
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.adapter.CardHomeVPAdapter
import com.example.kuit4androidprivate.adapter.GridHomeRVAdapter
import com.example.kuit4androidprivate.adapter.LinearHomeRVAdapter
import com.example.kuit4androidprivate.databinding.FragmentHomeBinding
import com.example.kuit4androidprivate.keep.KeepActivity
import com.example.kuit4androidprivate.model.HomeCardData
import com.example.kuit4androidprivate.model.MenuCategoryData
import com.example.kuit4androidprivate.model.MenuData

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var gridHomeRVAdapter: GridHomeRVAdapter
    private lateinit var linearHomeRVAdapter: LinearHomeRVAdapter
    private var gridHomeItems = ArrayList<MenuCategoryData>()
    private var linearHomeItems = ArrayList<MenuData>()
    private var cardHomeCardItems = ArrayList<HomeCardData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        initRVRecentOnClick()

        initMenuCategoryItems()
        initGridHomeRVAdapter()

        initLinearHomeItems()
        initLinearHomeRVAdapter()

        initOrderButtonOnClick(linearHomeItems)

        initHomeCardItems()
        initHomeCardVP()
        initHomeCardIndex()
        return binding.root
    }

    private fun initHomeCardIndex() {
        binding.vpHomeBottom.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tvHomeVpIndex.text = "${(position + 1) % 5 + 1}/5"
            }
        })
    }

    private fun initHomeCardVP() {
        binding.vpHomeBottom.adapter = CardHomeVPAdapter().apply {
            submitList(cardHomeCardItems)
        }
        binding.vpHomeBottom.currentItem = Int.MAX_VALUE / 2 + 1
    }

    private fun initHomeCardItems() {
        cardHomeCardItems.addAll(
            arrayListOf(
                HomeCardData(
                    1, "https://cdn.pixabay.com/photo/2021/02/08/12/40/lasagna-5994612_1280.jpg"
                ),
                HomeCardData(
                    2, "https://cdn.pixabay.com/photo/2014/05/18/11/25/pizza-346985_640.jpg"
                ),
                HomeCardData(
                    3, "https://cdn.pixabay.com/photo/2020/04/20/07/28/japan-food-5066734_640.jpg"
                ),
                HomeCardData(
                    4, "https://cdn.pixabay.com/photo/2020/10/05/19/55/hamburger-5630646_640.jpg"
                ),
                HomeCardData(
                    5, "https://cdn.pixabay.com/photo/2022/09/27/12/01/ikura-7482636_1280.jpg"
                )
            )
        )
    }

    private fun initOrderButtonOnClick(items: ArrayList<MenuData>) {
        binding.buttonMakeOrder.setOnClickListener {
            val intent = Intent(requireActivity(), FavoriteActivity::class.java)
            intent.putExtra("item_data", items)
            startActivity(intent)
        }
    }

    private fun initLinearHomeRVAdapter() {
        linearHomeRVAdapter = LinearHomeRVAdapter(requireActivity(), linearHomeItems) { item ->
            val intent = Intent(requireActivity(), DetailActivity::class.java)
            intent.putExtra("item_data", item)
            startActivity(intent)
        }
        binding.rvRecent.adapter = linearHomeRVAdapter
        binding.rvRecent.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
    }


    private fun initLinearHomeItems() {
        linearHomeItems.addAll(
            arrayListOf(
                MenuData(
                    "https://cdn.pixabay.com/photo/2016/08/20/13/06/toppokki-1607479_1280.jpg",
                    "아워떡볶이", "30분", "4.5", " (1,203)", true
                ),
                MenuData(
                    "https://cdn.pixabay.com/photo/2015/07/08/19/40/food-836806_1280.jpg",
                    "국밥생각", "35분", "4.6", " (1,303)", false
                ),
                MenuData(
                    "https://cdn.pixabay.com/photo/2018/12/04/15/20/chinese-3855829_1280.jpg",
                    "천왕성", "45분", "4.0", "(303)", false
                ),
                MenuData(
                    "https://cdn.pixabay.com/photo/2015/01/13/06/46/meat-597952_640.jpg",
                    "육회바른연어", "25분", "4.9", "(538)", false
                ),
                MenuData(
                    "https://cdn.pixabay.com/photo/2017/06/17/17/11/sashimi-2412779_640.jpg",
                    "육회한연어", "30분", "5.0", " (2,214)", false
                ),
                MenuData(
                    "https://cdn.pixabay.com/photo/2017/12/09/08/18/pizza-3007395_1280.jpg",
                    "청년피자", "39분", "4.8", " (1,586)", false
                ),
                MenuData(
                    "https://cdn.pixabay.com/photo/2017/08/06/06/43/pizza-2589575_640.jpg",
                    "더피자", "33분", "5.0", "(879)", false
                ),
                MenuData(
                    "https://cdn.pixabay.com/photo/2015/03/11/00/31/chicken-667935_640.jpg",
                    "푸라닭", "23분", "4.8", "(296)", false
                ),
                MenuData(
                    "https://cdn.pixabay.com/photo/2023/08/08/08/46/tacos-8176774_640.jpg",
                    "타코벨", "26분", "4.8", "(100)", false
                ),
                MenuData(
                    "https://cdn.pixabay.com/photo/2019/09/26/18/23/republic-of-korea-4506696_1280.jpg",
                    "노랑통닭", "32분", "4.9", "(451)", false
                )
            )
        )
    }

    private fun initGridHomeRVAdapter() {
        gridHomeRVAdapter = GridHomeRVAdapter(requireActivity(), gridHomeItems) {}
        binding.rvHomeMenuCategory.adapter = gridHomeRVAdapter
        binding.rvHomeMenuCategory.layoutManager =
            GridLayoutManager(requireActivity(), 5)
    }

    private fun initMenuCategoryItems() {
        gridHomeItems.addAll(
            arrayListOf(
                MenuCategoryData(
                    "돈까스", R.drawable.img_pork_cutlet
                ),
                MenuCategoryData(
                    "일식", R.drawable.img_japanese_food
                ),
                MenuCategoryData(
                    "한식", R.drawable.img_korean_food
                ),
                MenuCategoryData(
                    "치킨", R.drawable.chicken
                ),
                MenuCategoryData(
                    "분식", R.drawable.img_main_snack_food
                ),
                MenuCategoryData(
                    "족발/보쌈", R.drawable.img_main_jokbal
                ),
                MenuCategoryData(
                    "찜/탕", R.drawable.img_main_soup
                ),
                MenuCategoryData(
                    "구이", R.drawable.img_main_roast
                ),
                MenuCategoryData(
                    "피자", R.drawable.img_main_pizza
                ),
                MenuCategoryData(
                    "분식", R.drawable.img_main_snack_food
                ),
                MenuCategoryData(
                    "족발/보쌈", R.drawable.img_main_jokbal
                ),
                MenuCategoryData(
                    "찜/탕", R.drawable.img_main_soup
                ),
                MenuCategoryData(
                    "구이", R.drawable.img_main_roast
                ),
                MenuCategoryData(
                    "피자", R.drawable.img_main_pizza
                )

            )
        )
    }

    private fun initRVRecentOnClick() {
        binding.rvRecent.setOnClickListener {//KeepActivity
            val intent = Intent(requireActivity(), KeepActivity::class.java)
            startActivity(intent)
        }
    }
}
package com.example.kuit4androidprivate.home


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import com.example.kuit4androidprivate.model.MenuCategoryData
import com.example.kuit4androidprivate.model.MenuLatelyData


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var categoryRVAdapter: MenuCategoryRVAdapter
    private lateinit var latelyRVAdapter: MenuDataRVAdapter
    private val dummyItemsLately = ArrayList<MenuLatelyData>()
    private val dummyItemsCategory = ArrayList<MenuCategoryData>()
    private val dummyItemsHomeBottom = ArrayList<HomeBottomData>()
    private lateinit var itemHomeBottomBinding: ItemHomeBottomBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.sivHomeButton.setOnClickListener() {
            val intent = Intent(requireActivity(), FavoriteActivity::class.java)
            startActivity(intent)
        }
        initDummy()
        initCategoryRVAdapter()
        initDummy2()
        initLatelyRVAdapter()

        initBottomData()
        initHomeBottomVP()
        return binding.root
    }

    private fun initHomeBottomVP() {
        binding.vpMainBottom.adapter = HomeBottomVPAdapter().apply{
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


    private fun initDummy2() {
        dummyItemsLately.addAll(
            arrayListOf(
                MenuLatelyData(
                    title = "아워떡볶이", time = "30분", score = "4.9", num = "(3,849)",
                    imageUrl = "https://cdn.pixabay.com/photo/2017/09/10/14/23/toppokki-2735719_1280.jpg"
                ),
                MenuLatelyData(
                    title = "홍대돈부리", time = "33분", score = "5.0", num = "(1,356)",
                    imageUrl = "https://cdn.pixabay.com/photo/2019/12/01/15/08/salmon-plate-with-rice-4665684_1280.jpg"
                ),
                MenuLatelyData(
                    title = "가람성", time = "15분", score = "4.8", num = "(971)",
                    imageUrl = "https://cdn.pixabay.com/photo/2020/08/22/14/49/fried-rice-5508576_1280.jpg"
                ),
                MenuLatelyData(
                    title = "부리또피아", time = "23분", score = "4.9", num = "(2,252)",
                    imageUrl = "https://cdn.pixabay.com/photo/2020/06/01/15/37/tortilla-5247120_1280.jpg"
                ),
                MenuLatelyData(
                    title = "홍도초밥", time = "40분", score = "5.0", num = "(1,294)",
                    imageUrl = "https://cdn.pixabay.com/photo/2015/10/06/19/10/sushi-975075_1280.jpg"
                ),
                MenuLatelyData(
                    title = "미분당", time = "35분", score = "4.7", num = "(471)",
                    imageUrl = "https://cdn.pixabay.com/photo/2023/05/27/12/35/noodles-8021415_1280.png"
                ),
                MenuLatelyData(
                    title = "고씨네카레", time = "25분", score = "5.0", num = "(2,691)",
                    imageUrl = "https://cdn.pixabay.com/photo/2015/10/01/14/29/curry-967086_1280.jpg"
                ),
                MenuLatelyData(
                    title = "삼거리닭발", time = "20분", score = "4.6", num = "(3,482)",
                    imageUrl = "https://cdn.pixabay.com/photo/2018/05/02/03/03/food-3367643_1280.jpg"
                ), MenuLatelyData(
                    title = "장터국밥", time = "27분", score = "4.8", num = "(724)",
                    imageUrl = "https://cdn.pixabay.com/photo/2019/07/07/10/40/for-money-4322226_1280.jpg"
                ), MenuLatelyData(
                    title = "굽네치킨", time = "45분", score = "4.9", num = "(1,903)",
                    imageUrl = "https://cdn.pixabay.com/photo/2020/05/22/12/16/chicken-drumsticks-5205207_1280.jpg"
                )


            )
        )
    }

    private fun initDummy() {
        dummyItemsCategory.addAll(
            arrayListOf(
                MenuCategoryData(
                    title = "돈까스", image = R.drawable.img_home_porkcutlet
                ),
                MenuCategoryData(
                    title = "일식", image = R.drawable.img_home_japanesefood,
                ),
                MenuCategoryData(
                    title = "한식", image = R.drawable.img_home_koreanfood
                ),
                MenuCategoryData(
                    title = "치킨", image = R.drawable.img_home_chicken
                ),
                MenuCategoryData(
                    title = "분식", image = R.drawable.img_home_snackfood
                ),
                MenuCategoryData(
                    title = "족발/보쌈", image = R.drawable.img_home_jokbal
                ), MenuCategoryData(
                    title = "찜/탕", image = R.drawable.img_home_soup
                ),
                MenuCategoryData(
                    title = "구이", image = R.drawable.img_home_roast
                ),
                MenuCategoryData(
                    title = "피자", image = R.drawable.img_home_pizza
                )

            )
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
}
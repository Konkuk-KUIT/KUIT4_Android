package com.example.kuit4androidprivate.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.kuit4androidprivate.detail.DetailActivity
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.FavoriteActivity
import com.example.kuit4androidprivate.adapter.GridRVAdapter
import com.example.kuit4androidprivate.adapter.HomeImageRVAdapter
import com.example.kuit4androidprivate.adapter.HorizontalRVAdapter
import com.example.kuit4androidprivate.data.HomeImageData
import com.example.kuit4androidprivate.data.MenuCategoryData
import com.example.kuit4androidprivate.data.MenuData
import com.example.kuit4androidprivate.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var gridRVAdapter:GridRVAdapter
    private lateinit var horizontalRVAdapter: HorizontalRVAdapter
    private lateinit var homeImageRVAdapter: HomeImageRVAdapter
    private var menuCategoryData: ArrayList<MenuCategoryData> = ArrayList()
    private var menuData: ArrayList<MenuData> = ArrayList()
    private var homeImageData: ArrayList<HomeImageData> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.rvRecent.setOnClickListener {
            initDetail()
        }
        binding.sivHomeMid2.setOnClickListener{
            initFavorite()
        }

        addMenuCategoryData()
        addMenuData()
        initGridRVAdapter()
        initHorizontalRVAdapter()
        initEditText()
        addHomeImageData()
        initHomeImageRVAdapter()

        return binding.root
    }


    private fun initHomeImageRVAdapter() {
        homeImageRVAdapter = HomeImageRVAdapter(requireActivity(), homeImageData)

        binding.vpHomeImageScroll.adapter = homeImageRVAdapter
    }

    private fun addHomeImageData() {
        homeImageData.addAll(
            arrayListOf(
                HomeImageData(image=R.drawable.img_gukbap, index=1),
                HomeImageData(image=R.drawable.img_taco, index=2),
                HomeImageData(image=R.drawable.img_bagel, index=3)
            )
        )
    }

    private fun initFavorite() {
        val intent = Intent(requireActivity(), FavoriteActivity::class.java)
        startActivity(intent)
    }

    private fun addMenuData() {
        menuData.addAll(
            arrayListOf(
                MenuData(image=R.drawable.img_tteokbokki, name="아워떡볶이", score="4.9",
                    review="3,849", minute="30분"),
                MenuData(image=R.drawable.img_bagel, name="니커버커베이글", score="4.9",
                    review="7,079", minute="40분"),
                MenuData(image=R.drawable.img_bbq, name="BBQ", score="4.4",
                    review="5,093", minute="40분"),
                MenuData(image=R.drawable.img_donut, name="크리스피크림도넛", score="4.6",
                    review="983", minute="20분"),
                MenuData(image=R.drawable.img_burger, name="맥도날드", score="4.7",
                    review="6,849", minute="25분"),
                MenuData(image=R.drawable.img_gukbap, name="정담옥", score="4.5",
                    review="849", minute="50분"),
                MenuData(image=R.drawable.img_jjimdalk, name="두마리찜닭", score="4.9",
                    review="9,849", minute="50분"),
                MenuData(image=R.drawable.img_rice_noodle, name="미스사이공", score="4.8",
                    review="3,583", minute="30분"),
                MenuData(image=R.drawable.img_taco, name="꼰미고", score="4.9",
                    review="829", minute="30분"),
                MenuData(image=R.drawable.img_korean_meal, name="주막례고등어구이", score="4.4",
                    review="9,836", minute="40분")
            )
        )
    }

    private fun addMenuCategoryData() {
        menuCategoryData.addAll(
            arrayListOf(
                MenuCategoryData(image = R.drawable.img_pork_cutlet , name = "돈가스"),
                MenuCategoryData(image = R.drawable.img_japanese_food , name = "일식"),
                MenuCategoryData(image = R.drawable.img_korean_food, name = "한식"),
                MenuCategoryData(image = R.drawable.img_bbq , name = "치킨"),
                MenuCategoryData(image = R.drawable.img_snack_food , name = "분식"),
                MenuCategoryData(image = R.drawable.img_jokbal_bossam , name = "족발/보쌈"),
                MenuCategoryData(image = R.drawable.img_soup , name = "찜/탕"),
                MenuCategoryData(image = R.drawable.img_roast , name = "구이"),
                MenuCategoryData(image = R.drawable.img_pizza , name = "피자"),
                MenuCategoryData(image = R.drawable.img_pizza, name = "더보기")
            )
        )
    }

    private fun initHorizontalRVAdapter() {
        horizontalRVAdapter = HorizontalRVAdapter(requireActivity(), menuData)

        binding.rvRecent.adapter = horizontalRVAdapter
        binding.rvRecent.layoutManager = LinearLayoutManager(requireActivity(), HORIZONTAL, false)

    }

    private fun initGridRVAdapter() {
        gridRVAdapter = GridRVAdapter(requireActivity(), menuCategoryData)

        binding.rvMenuCategory.adapter = gridRVAdapter
        binding.rvMenuCategory.layoutManager = GridLayoutManager(requireActivity(), 5, VERTICAL, false)
    }

    private fun initDetail() {
        val intent = Intent(requireActivity(), DetailActivity::class.java)
        startActivity(intent)
    }

    private fun initEditText() {
        binding.etHomeFind.setOnEditorActionListener { textView, i, keyEvernt ->
            if(i == EditorInfo.IME_ACTION_SEARCH){
                val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(binding.etHomeFind.windowToken, 0)

                binding.etHomeFind.clearFocus()

                true
            }
            else{
                false
            }
        }
    }
}
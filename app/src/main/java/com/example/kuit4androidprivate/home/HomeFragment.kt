package com.example.kuit4androidprivate.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit4androidprivate.DetailActivity
import com.example.kuit4androidprivate.favorite.FavoriteActivity
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var foodAdapter: MenuCategoryDataAdapter
    private lateinit var menuAdapter: MenuDataAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.rvHomeSee.setOnClickListener {
            val intent = Intent(requireContext(), DetailActivity::class.java)
            startActivity(intent)
        }

        binding.btnHomeGo.setOnClickListener {
            val intent = Intent(requireContext(), FavoriteActivity::class.java)
            startActivity(intent)
        }

        val menuCategoryDataList = listOf(
            MenuCategoryData("돈까스", R.drawable.img_home_porkcutlet),
            MenuCategoryData("일식", R.drawable.img_home_japanesefood),
            MenuCategoryData("한식", R.drawable.img_home_koreanfood),
            MenuCategoryData("치킨", R.drawable.img_home_chicken),
            MenuCategoryData("분식", R.drawable.img_home_snackfood),
            MenuCategoryData("족발/보쌈", R.drawable.img_home_jokbal),
            MenuCategoryData("찜/탕", R.drawable.img_home_steampot),
            MenuCategoryData("구이", R.drawable.img_home_grill),
            MenuCategoryData("피자", R.drawable.img_home_pizza),
            MenuCategoryData("더보기", R.drawable.ic_more)
        )

        foodAdapter = MenuCategoryDataAdapter(menuCategoryDataList)

        binding.rvHomeFood.apply {
            layoutManager = GridLayoutManager(context, 5)
            adapter = foodAdapter
            addItemDecoration(GridSpacingItemDecoration(5, 30, true))
        }

        val menuCategoryList = listOf(
            MenuData("굽네치킨", "5.0", "3,949", "https://cdn.pixabay.com/photo/2019/09/26/18/23/republic-of-korea-4506696_1280.jpg"),
            MenuData("BHC", "4.8", "1,200", "https://cdn.pixabay.com/photo/2019/09/26/18/23/republic-of-korea-4506696_1280.jpg"),
            MenuData("BBQ", "4.5", "1,700", "https://cdn.pixabay.com/photo/2019/09/26/18/23/republic-of-korea-4506696_1280.jpg"),
            MenuData("처갓집양념치킨", "4.6", "800", "https://cdn.pixabay.com/photo/2019/09/26/18/23/republic-of-korea-4506696_1280.jpg"),
            MenuData("지코바", "4.9", "920", "https://cdn.pixabay.com/photo/2019/09/26/18/23/republic-of-korea-4506696_1280.jpg"),
            MenuData("네네치킨", "5.0", "704", "https://cdn.pixabay.com/photo/2019/09/26/18/23/republic-of-korea-4506696_1280.jpg"),
            MenuData("신통치킨", "4.5", "2,434", "https://cdn.pixabay.com/photo/2019/09/26/18/23/republic-of-korea-4506696_1280.jpg"),
            MenuData("순살만공격", "4.1", "799", "https://cdn.pixabay.com/photo/2019/09/26/18/23/republic-of-korea-4506696_1280.jpg"),
            MenuData("페리카나", "4.7", "2,414", "https://cdn.pixabay.com/photo/2019/09/26/18/23/republic-of-korea-4506696_1280.jpg"),
            MenuData("BBQ", "4.7", "999", "https://cdn.pixabay.com/photo/2019/09/26/18/23/republic-of-korea-4506696_1280.jpg"),

        )

        menuAdapter = MenuDataAdapter(menuCategoryList) { menuData ->
            val intent = Intent(requireContext(), DetailActivity::class.java).apply {
                putExtra("name", menuData.name)
                putExtra("score", menuData.score)
                putExtra("reviewCount", menuData.reviewCount)
                putExtra("imageUrl", menuData.imageUrl)
            }
            startActivity(intent)
        }

        binding.rvHomeSee.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = menuAdapter
            addItemDecoration(HorizontalSpacingItemDecoration(50))
        }

        return binding.root
    }
}
package com.example.kuit4androidprivate.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.adapter.Category_RVAdapter
import com.example.kuit4androidprivate.adapter.RVAdapter
import com.example.kuit4androidprivate.databinding.FragmentHomeBinding
import com.example.kuit4androidprivate.databinding.ItemHomeCategoryBinding
import com.example.kuit4androidprivate.detail.DetailActivity
import com.example.kuit4androidprivate.favorite.FavoriteActivity
import com.example.kuit4androidprivate.model.MenuCategoryData
import com.example.kuit4androidprivate.model.MenuData


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var categoryBinding: ItemHomeCategoryBinding
    private lateinit var rvAdapter: RVAdapter
    private lateinit var categoryRVAdapter: Category_RVAdapter
    private val items = ArrayList<MenuData>()
    private val categoryitems = ArrayList<MenuCategoryData>()
    private lateinit var decoration: DividerItemDecoration

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(layoutInflater)
        categoryBinding = ItemHomeCategoryBinding.inflate(layoutInflater)

        initItems()
        initRVAdapter()
        initCategory()
        initCategoryrvAdapter()

        return binding.root

    }

    private fun initItems() {
        items.addAll(
            arrayListOf(
                MenuData(
                    "아워떡볶이",
                    "30분",
                    "https://cdn.pixabay.com/photo/2017/07/27/16/48/toppokki-2545943_640.jpg",
                    "4.9",
                    "(3849)"
                ),
                MenuData(
                    "치킨",
                    "45분",
                    "https://cdn.pixabay.com/photo/2017/06/26/13/58/chicken-2443901_640.jpg",
                    "4.0",
                    "(2002)"
                ),
                MenuData(
                    "파스타",
                    "25분",
                    "https://cdn.pixabay.com/photo/2018/07/18/19/12/pasta-3547078_1280.jpg",
                    "3.8",
                    "(500)"
                ),
                MenuData(
                    "피자",
                    "35분",
                    "https://cdn.pixabay.com/photo/2017/12/09/08/18/pizza-3007395_1280.jpg",
                    "4.1",
                    "(380)"
                ),
                MenuData(
                    "짜장면",
                    "20분",
                    "https://media.istockphoto.com/id/1468239564/ko/%EC%82%AC%EC%A7%84/jajangmyeon-%EC%A7%9C%EC%9E%A5%EB%A9%B4.jpg?s=2048x2048&w=is&k=20&c=H32zSqAiOpKb7TLYn1iQScoEUB5x-dIbrtCYSFxyueE=",
                    "3.7",
                    "(800)"
                ),
                MenuData(
                    "초밥",
                    "35분",
                    "https://cdn.pixabay.com/photo/2020/05/08/02/42/sushi-5143892_640.jpg",
                    "3.9",
                    "(1200)"
                ),
                MenuData(
                    "족발",
                    "45분",
                    "https://cdn.pixabay.com/photo/2021/10/17/16/55/spicy-jokbal-6718937_640.jpg",
                    "3.6",
                    "(390)"
                ),
                MenuData(
                    "쌀국수",
                    "25분",
                    "https://cdn.pixabay.com/photo/2023/05/27/12/35/noodles-8021415_640.png",
                    "3.8",
                    "(870)"
                ),
                MenuData(
                    "돈가스",
                    "45분",
                    "https://cdn.pixabay.com/photo/2018/03/21/03/49/food-3245489_640.jpg",
                    "4.0",
                    "(1500)"
                ),
                MenuData(
                    "칼국수",
                    "25분",
                    "https://cdn.pixabay.com/photo/2020/05/12/08/01/kalguksu-5161719_640.jpg",
                    "4.1",
                    "(290)"
                ),

                )
        )
    }

    private fun initRVAdapter() {

        rvAdapter = RVAdapter(requireContext(), items)
        binding.rvHomeRecentRestaurant.adapter = rvAdapter
        binding.rvHomeRecentRestaurant.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        addDecoration()
    }

    private fun addDecoration() {
        decoration = DividerItemDecoration(context, LinearLayout.HORIZONTAL)
        val drawable = ContextCompat.getDrawable(requireContext(), R.drawable.divider_home_recent)
        if (drawable != null) {
            decoration.setDrawable(drawable)
        }
        binding.rvHomeRecentRestaurant.addItemDecoration(decoration)
    }

    private fun initCategory() {
        categoryitems.addAll(
            arrayListOf(
                MenuCategoryData(R.drawable.img_porkcutlet, "돈까스"),
                MenuCategoryData(R.drawable.img_japanesefood, "일식"),
                MenuCategoryData(R.drawable.img_koreanfood, "한식"),
                MenuCategoryData(R.drawable.img_chicken, "치킨"),
                MenuCategoryData(R.drawable.img_snackfood, "분식"),
                MenuCategoryData(R.drawable.img_jokbalbossam, "족발/보쌈"),
                MenuCategoryData(R.drawable.img_soup, "찜/탕"),
                MenuCategoryData(R.drawable.img_roast, "구이"),
                MenuCategoryData(R.drawable.img_pizza, "피자")
            )
        )
    }

    private fun initCategoryrvAdapter() {

        categoryRVAdapter = Category_RVAdapter(requireContext(), categoryitems)
        binding.rvHomeCategory.adapter = categoryRVAdapter

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvHomeRecentRestaurant.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            startActivity(intent)
        }

        binding.sivHomeGotoorder.setOnClickListener {
            val intent = Intent(context, FavoriteActivity::class.java)
            startActivity(intent)
        }
    }


}
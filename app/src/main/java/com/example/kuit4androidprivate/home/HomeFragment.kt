package com.example.kuit4androidprivate.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.adapter.RVAdapterCategory
import com.example.kuit4androidprivate.adapter.RVAdapterRecent
import com.example.kuit4androidprivate.databinding.FragmentHomeBinding
import com.example.kuit4androidprivate.detail.DetailActivity
import com.example.kuit4androidprivate.favorite.FavoriteActivity
import com.example.kuit4androidprivate.model.MenuCategoryData
import com.example.kuit4androidprivate.model.MenuData


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var rvAdapterCategory: RVAdapterCategory
    private val categoryItem = arrayListOf<MenuCategoryData>()
    private lateinit var rvAdapterRecent: RVAdapterRecent
    private val recentItem = arrayListOf<MenuData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(layoutInflater)
        initCategory()
        initRVAdapterCategory()
        initRecent()
        initRVAdapterRecent()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //KeepActivity로 전환하기 위한 함수
//        binding.clRecentlyViewedRestaurantContainer.setOnClickListener {
//            val intent = Intent(activity, DetailActivity::class.java)
//            startActivity(intent)
//        }

        binding.sivPromotionOrderButton.setOnClickListener {
            val intent = Intent(activity, FavoriteActivity::class.java)
            startActivity(intent)
        }

//        recyclerView = binding.rvHomeCategory
//        recyclerView.layoutManager = GridLayoutManager(requireContext(), 5)
    }

    private fun initCategory() {
        categoryItem.addAll(
            arrayListOf(
                MenuCategoryData(
                    "돈까스",
                    R.drawable.img_pork_cutlet
                ),
                MenuCategoryData(
                    "일식",
                    R.drawable.img_japanese_food
                ),
                MenuCategoryData(
                    "한식",
                    R.drawable.img_korean_food
                ),
                MenuCategoryData(
                    "치킨",
                    R.drawable.img_chicken
                ),
                MenuCategoryData(
                    "분식",
                    R.drawable.img_snack_food
                ),
                MenuCategoryData(
                    "족발/보쌈",
                    R.drawable.img_bossam
                ),
                MenuCategoryData(
                    "찜/탕",
                    R.drawable.img_soup
                ),
                MenuCategoryData(
                    "구이",
                    R.drawable.img_barbeque
                ),
                MenuCategoryData(
                    "피자",
                    R.drawable.img_pizza
                ),
            )
        )
    }

    private fun initRVAdapterCategory() {
        rvAdapterCategory = RVAdapterCategory(requireContext(), categoryItem) { it ->
            Toast.makeText(requireContext(), it.categoryName, Toast.LENGTH_LONG).show()
        }

        with(binding.rvHomeCategory) {
            adapter = rvAdapterCategory
            layoutManager = GridLayoutManager(requireContext(), 5)
        }
    }

    private fun initRecent() {
        recentItem.addAll(
            arrayListOf(
                MenuData(
                    restaurantName = getString(R.string.our_snacks),
                    eta = "50분",
                    imgId = R.drawable.img_favorite_our_snack,
                    rating = "2.9",
                    totalReviews = "(1149)"
                ),
                MenuData(
                    restaurantName = getString(R.string.our_snacks),
                    eta = "30분",
                    imgId = R.drawable.img_favorite_our_snack,
                    rating = "4.9",
                    totalReviews = "(3849)"
                ),
                MenuData(
                    restaurantName = getString(R.string.our_snacks),
                    eta = "30분",
                    imgId = R.drawable.img_favorite_our_snack,
                    rating = "4.9",
                    totalReviews = "(3849)"
                ),
                MenuData(
                    restaurantName = getString(R.string.our_snacks),
                    eta = "30분",
                    imgId = R.drawable.img_favorite_our_snack,
                    rating = "4.9",
                    totalReviews = "(3849)"
                ),
                MenuData(
                    restaurantName = getString(R.string.our_snacks),
                    eta = "30분",
                    imgId = R.drawable.img_favorite_our_snack,
                    rating = "4.9",
                    totalReviews = "(3849)"
                ),
                MenuData(
                    restaurantName = getString(R.string.our_snacks),
                    eta = "30분",
                    imgId = R.drawable.img_favorite_our_snack,
                    rating = "4.9",
                    totalReviews = "(3849)"
                ),
                MenuData(
                    restaurantName = getString(R.string.our_snacks),
                    eta = "30분",
                    imgId = R.drawable.img_favorite_our_snack,
                    rating = "4.9",
                    totalReviews = "(3849)"
                ),
                MenuData(
                    restaurantName = getString(R.string.our_snacks),
                    eta = "30분",
                    imgId = R.drawable.img_favorite_our_snack,
                    rating = "4.9",
                    totalReviews = "(3849)"
                ),
                MenuData(
                    restaurantName = getString(R.string.our_snacks),
                    eta = "30분",
                    imgId = R.drawable.img_favorite_our_snack,
                    rating = "4.9",
                    totalReviews = "(3849)"
                ),
                MenuData(
                    restaurantName = getString(R.string.our_snacks),
                    eta = "30분",
                    imgId = R.drawable.img_favorite_our_snack,
                    rating = "4.9",
                    totalReviews = "(3849)"
                ),
            )
        )
    }

    private fun initRVAdapterRecent() {
        rvAdapterRecent = RVAdapterRecent(requireContext(), recentItem) { it ->
            val intent = Intent(requireContext(), DetailActivity::class.java)
            //menuData를 intent에 넘김
            intent.putExtra("menuData",it)
            startActivity(intent)
        }

        with(binding.rvHomeRecent) {
            adapter = rvAdapterRecent
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }
}
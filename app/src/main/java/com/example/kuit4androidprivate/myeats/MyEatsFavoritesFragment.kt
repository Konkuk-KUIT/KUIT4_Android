package com.example.kuit4androidprivate.myeats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.adapter.Myeats_Favorite_RVAdapter
import com.example.kuit4androidprivate.adapter.Review_RVAdapter
import com.example.kuit4androidprivate.databinding.FragmentMyeatsFavoritesBinding
import com.example.kuit4androidprivate.databinding.FragmentMyeatsReviewBinding
import com.example.kuit4androidprivate.databinding.ItemDetailRestaurantBinding
import com.example.kuit4androidprivate.model.MenuData


class MyEatsFavoritesFragment : Fragment() {

    private lateinit var binding: FragmentMyeatsFavoritesBinding
    private lateinit var rvAdapter: Myeats_Favorite_RVAdapter
    private val items = ArrayList<MenuData>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMyeatsFavoritesBinding.inflate(layoutInflater)

        initFavoriteRestaurantItems()
        initMyeatsFavoriteRVAdapter()


        return binding.root


    }

    private fun initFavoriteRestaurantItems() {
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
                    "아워떡볶이",
                    "30분",
                    "https://cdn.pixabay.com/photo/2017/07/27/16/48/toppokki-2545943_640.jpg",
                    "4.9",
                    "(3849)"
                ),
                MenuData(
                    "아워떡볶이",
                    "30분",
                    "https://cdn.pixabay.com/photo/2017/07/27/16/48/toppokki-2545943_640.jpg",
                    "4.9",
                    "(3849)"
                )
            )
        )
    }

    private fun initMyeatsFavoriteRVAdapter() {
        rvAdapter = Myeats_Favorite_RVAdapter(requireContext(), items)
        binding.rvMyeatsFavorite.adapter = rvAdapter
        binding.rvMyeatsFavorite.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }
}

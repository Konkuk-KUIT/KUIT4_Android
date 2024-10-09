package com.example.kuit4androidprivate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit4androidprivate.adapter.MyEatsFavoritesRVAdapter
import com.example.kuit4androidprivate.databinding.FragmentFavoritesViewPageBinding
import com.example.kuit4androidprivate.model.MenuLatelyData


class FavoritesViewPageFragment : Fragment() {

    lateinit var binding: FragmentFavoritesViewPageBinding
    private var dummyItems = ArrayList<MenuLatelyData>()
    private lateinit var favoritesRVAdapter: MyEatsFavoritesRVAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritesViewPageBinding.inflate(layoutInflater)

        initDummys()
        initRVAdapter()
        return binding.root
    }

    private fun initRVAdapter() {
        favoritesRVAdapter = MyEatsFavoritesRVAdapter(this, dummyItems)
        binding.rvMyEatsFavorite.adapter = favoritesRVAdapter
        binding.rvMyEatsFavorite.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
    }

    private fun initDummys() {
        dummyItems.addAll(
            arrayListOf(
                MenuLatelyData(
                    title = "아워떡볶이",
                    score = "4.9",
                    num = "(3,245)",
                    imageUrl = "https://cdn.pixabay.com/photo/2022/12/29/01/01/image-7683986_1280.jpg",
                    time = ""
                ),
                MenuLatelyData(
                    title = "아워떡볶이",
                    score = "4.9",
                    num = "(3,245)",
                    imageUrl = "https://cdn.pixabay.com/photo/2022/12/29/01/01/image-7683986_1280.jpg",
                    time = ""
                ),
                MenuLatelyData(
                    title = "아워떡볶이",
                    score = "4.9",
                    num = "(3,245)",
                    imageUrl = "https://cdn.pixabay.com/photo/2022/12/29/01/01/image-7683986_1280.jpg",
                    time = ""
                )
            )
        )
    }

}
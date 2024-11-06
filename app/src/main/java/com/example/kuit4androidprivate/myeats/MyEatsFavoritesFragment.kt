package com.example.kuit4androidprivate.myeats

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit4androidprivate.adapter.RVAdapterMyEatsFavorite
import com.example.kuit4androidprivate.databinding.FragmentMyEatsFavoritesBinding
import com.example.kuit4androidprivate.model.MenuData

class MyEatsFavoritesFragment: Fragment() {
    private lateinit var binding : FragmentMyEatsFavoritesBinding
    private lateinit var rvAdapterMyEatsFavorite: RVAdapterMyEatsFavorite
    private val favoriteItem = arrayListOf<MenuData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyEatsFavoritesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initFavorite()
        initRVAdaterMyEatsFavorite()
    }

    private fun initRVAdaterMyEatsFavorite() {
        rvAdapterMyEatsFavorite = RVAdapterMyEatsFavorite(requireContext(), favoriteItem)

        with(binding.rvFavoriteRestaurants) {
            adapter = rvAdapterMyEatsFavorite
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun initFavorite(){
        favoriteItem.addAll(
            arrayListOf(
                MenuData(
                    restaurantName = "모터시티",
                    eta = "30분",
                    imgUrl = "https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20240306_55%2F1709683905690CRcjK_JPEG%2FIMG_3105.jpeg",
                    rating = "4.9",
                    totalReviews = "(3149)"
                ),
                MenuData(
                    restaurantName = "지노스 피자",
                    eta = "31분",
                    imgUrl = "https://ldb-phinf.pstatic.net/20240421_108/1713677860549T8AzD_JPEG/KakaoTalk_20240418_210511163_03.jpg",
                    rating = "4.9",
                    totalReviews = "(3249)"
                ),
                MenuData(
                    restaurantName = "우래옥",
                    eta = "32분",
                    imgUrl = "https://search.pstatic.net/common/?src=https%3A%2F%2Fpup-review-phinf.pstatic.net%2FMjAyNDA5MjlfMTU3%2FMDAxNzI3NTg5MTI1Mjkz.rn45W-mYbs-LflYbvnFQHCV2uZmyo1j7RmmbFXVMUYIg.tBOf99kd04i8Cdtr7Z9-6Cyer73lANZy_IdDKM1HxcMg.JPEG%2F11D3207C-F9F0-4C0D-A6B8-48F855E8C8AE.jpeg%3Ftype%3Dw1500_60_sharpen",
                    rating = "4.9",
                    totalReviews = "(3349)"
                ),
            )
        )
    }
}
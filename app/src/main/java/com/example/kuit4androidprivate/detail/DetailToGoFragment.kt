package com.example.kuit4androidprivate.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.adapter.RVAdapterDetailToGo
import com.example.kuit4androidprivate.databinding.FragmentDetailTogoBinding
import com.example.kuit4androidprivate.model.DetailMenuData

class DetailToGoFragment: Fragment(){
    private lateinit var binding : FragmentDetailTogoBinding
    private lateinit var rvAdapterDetailToGo: RVAdapterDetailToGo
    private val favoriteItem = arrayListOf<DetailMenuData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailTogoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initFavorite()
        initRVAdapterDetailDelivery()
    }

    private fun initRVAdapterDetailDelivery() {
        rvAdapterDetailToGo= RVAdapterDetailToGo(requireContext(), favoriteItem)

        with(binding.rvDetailTogo) {
            adapter = rvAdapterDetailToGo
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun initFavorite(){
        favoriteItem.addAll(
            arrayListOf(
                DetailMenuData(
                    "떡볶이",
                    R.drawable.img_detail_menu_ddeokbokki,
                    "5,000원"
                ),
                DetailMenuData(
                    "김말이",
                    R.drawable.img_detail_menu_kimmari,
                    "5,000원"
                ),
                DetailMenuData(
                    "김밥",
                    R.drawable.img_detail_menu_kimbap,
                    "5,000원"
                ),
                DetailMenuData(
                    "돈까스",
                    R.drawable.img_detail_menu_pork_cutlet,
                    "5,000원"
                ),
            )
        )
    }
}
package com.example.kuit4androidprivate.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.detail.data.DetailMenuData
import com.example.kuit4androidprivate.databinding.FragmentDetailTogoBinding
import com.example.kuit4androidprivate.detail.adapter.DetailRVAdapter


class DetailTogoFragment : Fragment() {

    private lateinit var binding: FragmentDetailTogoBinding
    private lateinit var detailRVAdapter: DetailRVAdapter
    private var detailMenuList = arrayListOf(
        DetailMenuData(name = "떡볶이", price = "5,000원", image =R.drawable.img_detail_menu_tteokbokki),
        DetailMenuData(name = "김말이", price = "3,000원", image =R.drawable.img_detail_menu_gimmali),
        DetailMenuData(name = "김밥", price = "3,500원", image =R.drawable.img_detail_menu_gimbap),
        DetailMenuData(name = "돈가스", price = "9,000원", image =R.drawable.img_detail_menu_pork_cutlet)
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailTogoBinding.inflate(layoutInflater)

        detailRVAdapter = DetailRVAdapter(requireActivity(), detailMenuList)
        binding.rvDetailTogo.adapter = detailRVAdapter
        binding.rvDetailTogo.layoutManager = LinearLayoutManager(requireActivity())

        return binding.root
    }


}
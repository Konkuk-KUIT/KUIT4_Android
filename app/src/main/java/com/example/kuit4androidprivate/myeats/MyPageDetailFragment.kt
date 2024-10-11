package com.example.kuit4androidprivate.myeats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kuit4androidprivate.adapter.MyPageDetailVPAdapter
import com.example.kuit4androidprivate.databinding.FragmentMyPageDetailBinding
import com.example.kuit4androidprivate.databinding.FragmentMyPageReviewBinding
import com.google.android.material.tabs.TabLayoutMediator

class MyPageDetailFragment : Fragment() {

    private lateinit var binding: FragmentMyPageDetailBinding

    private var tabItems = arrayListOf<String>(
        "리뷰", "즐겨찾기"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyPageDetailBinding.inflate(layoutInflater)

        initFragmentViewPager2()

        return binding.root
    }

    private fun initFragmentViewPager2() {
        binding.vpMyPage.adapter = MyPageDetailVPAdapter(this)
        TabLayoutMediator(binding.tlMyPage, binding.vpMyPage) { tab, position ->
            tab.text = tabItems[position]
        }.attach()
    }
}
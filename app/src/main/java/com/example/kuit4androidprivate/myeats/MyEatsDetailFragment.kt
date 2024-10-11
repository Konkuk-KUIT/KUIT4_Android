package com.example.kuit4androidprivate.myeats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kuit4androidprivate.adapter.MyeatsFragment_RVAdapter
import com.example.kuit4androidprivate.databinding.FragmentMyeatsDetailBinding
import com.google.android.material.tabs.TabLayoutMediator


class MyEatsDetailFragment : Fragment() {

    private lateinit var binding : FragmentMyeatsDetailBinding
    private var tabItems = arrayListOf<String>("리뷰", "즐겨찾기")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMyeatsDetailBinding.inflate(layoutInflater)

        initMyEatsFragmentViewPager2()

        return binding.root
    }

    private fun initMyEatsFragmentViewPager2() {
        binding.vpMyeatsDetail.adapter = MyeatsFragment_RVAdapter(this)

        TabLayoutMediator(binding.tlMyeatsDetail, binding.vpMyeatsDetail) { tab, position ->
            tab.text = tabItems[position]
        }.attach()
    }

}
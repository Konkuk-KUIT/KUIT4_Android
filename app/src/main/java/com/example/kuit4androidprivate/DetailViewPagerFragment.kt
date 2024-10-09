package com.example.kuit4androidprivate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kuit4androidprivate.adapter.MyEatsFragmentVPAdatper
import com.example.kuit4androidprivate.databinding.FragmentDetailViewPagerBinding
import com.google.android.material.tabs.TabLayoutMediator


class DetailViewPagerFragment : Fragment() {
        lateinit var binding : FragmentDetailViewPagerBinding
        private var tabItems = arrayListOf<String>(
            "리뷰","즐겨찾기"
        )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailViewPagerBinding.inflate(layoutInflater)

        initFragmentViewPager()
        return binding.root
    }

    private fun initFragmentViewPager() {
       binding.vpDetailView.adapter = MyEatsFragmentVPAdatper(requireActivity())
        TabLayoutMediator(binding.tlDetailViewTab, binding.vpDetailView){tab, position ->
            tab.text = tabItems[position]
        }.attach()
    }


}
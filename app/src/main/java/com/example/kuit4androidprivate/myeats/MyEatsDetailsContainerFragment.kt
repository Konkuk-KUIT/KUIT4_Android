package com.example.kuit4androidprivate.myeats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kuit4androidprivate.adapter.FragmentVPAdapter
import com.example.kuit4androidprivate.databinding.FragmentMyEatsDetailsContainerBinding
import com.google.android.material.tabs.TabLayoutMediator

class MyEatsDetailsContainerFragment: Fragment() {
    private lateinit var binding :FragmentMyEatsDetailsContainerBinding
    private var tabItems = arrayListOf<String>(
        "리뷰", "즐겨찾기"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyEatsDetailsContainerBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initFragmentViewPager2()
    }

    private fun initFragmentViewPager2(){
        binding.vpMyEats.adapter = FragmentVPAdapter(this)

        TabLayoutMediator(binding.tlMyEats, binding.vpMyEats){tab, position ->
            tab.text = tabItems[position]
        }.attach()
    }


}
package com.example.kuit4androidprivate.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kuit4androidprivate.adapter.FragmentVPAdapterDetail
import com.example.kuit4androidprivate.databinding.FragmentDetailContainerBinding
import com.google.android.material.tabs.TabLayoutMediator

class DetailContainerFragment: Fragment() {
    private lateinit var binding : FragmentDetailContainerBinding
    private var tabItems = arrayListOf<String>(
        "배달 30분", "포장 15분"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailContainerBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initFragmentViewPager2()
    }

    private fun initFragmentViewPager2(){
        binding.vpDetail.adapter = FragmentVPAdapterDetail(this)

        TabLayoutMediator(binding.tlDetailTab, binding.vpDetail){tab, position ->
            tab.text = tabItems[position]
        }.attach()
    }


}
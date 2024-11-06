package com.example.kuit4androidprivate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kuit4androidprivate.adapter.FavoritesOrderVPAdapter
import com.example.kuit4androidprivate.databinding.FragmentDetailViewPagerBinding
import com.example.kuit4androidprivate.databinding.FragmentFavoritesOrderViewPagerBinding
import com.example.kuit4androidprivate.databinding.FragmentFavoritesViewPageBinding
import com.example.kuit4androidprivate.databinding.FragmentMyEatsBinding
import com.google.android.material.tabs.TabLayoutMediator

class FavoritesOrderViewPagerFragment : Fragment() {
    lateinit var binding: FragmentFavoritesOrderViewPagerBinding
    private var tabItems = arrayListOf<String>(
        "배달 30분", "포장 15분"
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritesOrderViewPagerBinding.inflate(layoutInflater)

        initFragmentViewPager()
        return binding.root
    }

    private fun initFragmentViewPager() {

        binding.vpOrderView.adapter = FavoritesOrderVPAdapter(requireActivity())
        TabLayoutMediator(binding.tlOrderSelect, binding.vpOrderView) { tab, position ->
            tab.text = tabItems[position]
        }.attach()
    }


}

package com.example.kuit4androidprivate.myeats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kuit4androidprivate.myeats.adapter.FragmentMyEatsVPAdapter
import com.example.kuit4androidprivate.databinding.FragmentMyEatsReviewLikeBinding
import com.google.android.material.tabs.TabLayoutMediator

class MyEatsReviewLikeFragment : Fragment() {

    private lateinit var binding: FragmentMyEatsReviewLikeBinding
    private var tabItems = arrayListOf<String>(
        "리뷰", "즐겨찾기"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentMyEatsReviewLikeBinding.inflate(layoutInflater)
        initFragmentAdapter()
        return binding.root

    }

    private fun initFragmentAdapter() {
        binding.vpEatsReviewLike.adapter = FragmentMyEatsVPAdapter(this)
        TabLayoutMediator(binding.tlEatsReviewLike, binding.vpEatsReviewLike) { tab, position ->
            tab.text = tabItems[position]
        }.attach()
    }

}
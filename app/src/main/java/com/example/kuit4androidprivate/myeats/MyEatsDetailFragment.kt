package com.example.kuit4androidprivate.myeats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kuit4androidprivate.databinding.FragmentMyEatsDetailBinding
import com.google.android.material.tabs.TabLayoutMediator

class MyEatsDetailFragment : Fragment() {

    private lateinit var binding: FragmentMyEatsDetailBinding
    private lateinit var adapter: MyEatsPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyEatsDetailBinding.inflate(layoutInflater)

        adapter = MyEatsPagerAdapter(this)
        binding.vpMyeats.adapter = adapter

        TabLayoutMediator(binding.tlMyeats, binding.vpMyeats) { tab, position ->
            when (position) {
                0 -> tab.text = "리뷰"
                1 -> tab.text = "즐겨찾기"
            }
        }.attach()

        return binding.root
    }
}

package com.example.kuit4androidprivate.detail

import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.adapter.DetailFragmentRVAdapter
import com.example.kuit4androidprivate.databinding.FragmentDetailMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class DetailMainFragment : Fragment() {

    private lateinit var binding: FragmentDetailMainBinding
    private var tabItems = arrayListOf<String>("배달 30분", "포장 15분")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        inflater.cloneInContext(ContextThemeWrapper(activity, R.style.Base_Theme_Kuit4AndroidPrivate2))

        binding = FragmentDetailMainBinding.inflate(layoutInflater)

        initDetailViewPager2()

        return binding.root
    }

    private fun initDetailViewPager2() {
        binding.vpDetailMain.adapter = DetailFragmentRVAdapter(this)

        TabLayoutMediator(binding.tlDetailMain, binding.vpDetailMain) { tab, position ->
            tab.text = tabItems[position]
        }.attach()

    }
}
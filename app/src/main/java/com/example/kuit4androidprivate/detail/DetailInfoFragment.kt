package com.example.kuit4androidprivate.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kuit4androidprivate.databinding.FragmentDetailInfoBinding
import com.example.kuit4androidprivate.detail.adapter.DetailVPAdapter
import com.google.android.material.tabs.TabLayoutMediator

class DetailInfoFragment : Fragment() {

    private lateinit var binding:FragmentDetailInfoBinding
    private lateinit var detailVPAdapter:DetailVPAdapter
    private var tabItems = arrayListOf("배달", "포장")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailInfoBinding.inflate(layoutInflater)

        detailVPAdapter = DetailVPAdapter(requireActivity())
        binding.vpDetail.adapter = detailVPAdapter

        TabLayoutMediator(binding.tlDetail, binding.vpDetail) { tab, position ->
            tab.text = tabItems[position]
        }.attach()

        return binding.root
    }

}
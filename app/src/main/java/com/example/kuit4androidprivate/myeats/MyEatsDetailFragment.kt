package com.example.kuit4androidprivate.myeats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kuit4androidprivate.adapter.MyEatsDetailVPAdapter
import com.example.kuit4androidprivate.databinding.FragmentMyEatsDetailBinding
import com.google.android.material.tabs.TabLayoutMediator


class MyEatsDetailFragment : Fragment() {

    private lateinit var binding: FragmentMyEatsDetailBinding
    private lateinit var myEatsDetailRVAdapter: MyEatsDetailVPAdapter
    private var tabItems = arrayListOf("리뷰", "즐겨찾기")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyEatsDetailBinding.inflate(layoutInflater)

        myEatsDetailRVAdapter = MyEatsDetailVPAdapter(requireActivity())
        binding.vpMyEatsReview.adapter = myEatsDetailRVAdapter

        TabLayoutMediator(binding.tlMyEatsDetail, binding.vpMyEatsReview){ tab, position ->
            tab.text = tabItems[position]
        }.attach()

        return binding.root
    }

    companion object {
        fun newInstance(): MyEatsDetailFragment{
            return MyEatsDetailFragment()
        }
    }

}
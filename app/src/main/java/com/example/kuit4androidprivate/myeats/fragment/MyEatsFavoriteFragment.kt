package com.example.kuit4androidprivate.myeats.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.myeats.adapter.MyEatsFavoriteRVAdapter
import com.example.kuit4androidprivate.data.MyEatsFavoriteData
import com.example.kuit4androidprivate.databinding.FragmentMyEatsFavoriteBinding


class MyEatsFavoriteFragment : Fragment() {

    private lateinit var binding: FragmentMyEatsFavoriteBinding
    private lateinit var myEatsFavoriteRVAdapter: MyEatsFavoriteRVAdapter
    private var FavoriteList = arrayListOf(
        MyEatsFavoriteData("아워떡볶이", "4.9 (3,849)", R.drawable.img_tteokbokki ),
        MyEatsFavoriteData("아워떡볶이", "4.9 (3,849)", R.drawable.img_tteokbokki ),
        MyEatsFavoriteData("아워떡볶이", "4.9 (3,849)", R.drawable.img_tteokbokki )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyEatsFavoriteBinding.inflate(layoutInflater)

        myEatsFavoriteRVAdapter = MyEatsFavoriteRVAdapter(requireActivity(), FavoriteList)
        binding.rvMyEatsFavorite.adapter = myEatsFavoriteRVAdapter
        binding.rvMyEatsFavorite.layoutManager = LinearLayoutManager(requireActivity())

        return binding.root
    }

}
package com.example.kuit4androidprivate.myeats

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.adapter.RVAdapter
import com.example.kuit4androidprivate.adapter.Review_RVAdapter
import com.example.kuit4androidprivate.databinding.FragmentMyeatsReviewBinding
import com.example.kuit4androidprivate.model.MenuData
import com.example.kuit4androidprivate.model.ReviewData


class MyEatsReviewFragment : Fragment() {

    private lateinit var binding : FragmentMyeatsReviewBinding
    private lateinit var rvAdapter: Review_RVAdapter
    private val items = ArrayList<ReviewData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyeatsReviewBinding.inflate(layoutInflater)

        initReviewItems()
        initReviewRVAdapter()


        return binding.root
    }


    private fun initReviewItems() {
        items.addAll(
            arrayListOf(
                ReviewData("아워떡볶이", 5, "2024-04-11", "맛있게 잘 먹었습니다" ),
                ReviewData("아워떡볶이", 5, "2024-04-11", "맛있게 잘 먹었습니다" ),
                ReviewData("아워떡볶이", 5, "2024-04-11", "맛있게 잘 먹었습니다" ),
                ReviewData("아워떡볶이", 5, "2024-04-11", "맛있게 잘 먹었습니다" ),
                ReviewData("아워떡볶이", 5, "2024-04-11", "맛있게 잘 먹었습니다" )
            )
        )
    }

    private fun initReviewRVAdapter() {
        rvAdapter = Review_RVAdapter(requireContext(), items)
        binding.rvMyeatsReview.adapter = rvAdapter
        binding.rvMyeatsReview.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }


}
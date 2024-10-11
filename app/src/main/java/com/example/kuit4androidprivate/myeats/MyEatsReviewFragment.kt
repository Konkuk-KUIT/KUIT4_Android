package com.example.kuit4androidprivate.myeats

import android.graphics.Rect
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.adapter.LinearMyEatsReviewRVAdapter
import com.example.kuit4androidprivate.databinding.FragmentMyEatsReviewBinding
import com.example.kuit4androidprivate.model.ReviewData

class MyEatsReviewFragment : Fragment() {
    private lateinit var binding: FragmentMyEatsReviewBinding
    private var reviewDataItems = ArrayList<ReviewData>()
    private lateinit var linearMyEatsReviewRVAdapter: LinearMyEatsReviewRVAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyEatsReviewBinding.inflate(layoutInflater)
        initReviewData()
//        initLastMarginDecoration()
        initRVAdapter()
        return binding.root
    }

    private fun initRVAdapter() {
        linearMyEatsReviewRVAdapter =
            LinearMyEatsReviewRVAdapter(requireActivity(), reviewDataItems)
        binding.rvMyEatsReview.apply {
            adapter = linearMyEatsReviewRVAdapter
            layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        }
    }


    private fun initReviewData() {
        reviewDataItems.addAll(
            arrayListOf(
                ReviewData(
                    1, "아워떡볶이", 5, "2024-10-08", "맛있어요"
                ),
                ReviewData(
                    2, "아워떡볶이", 5, "2024-10-08", "정말맛있어요"
                ),
                ReviewData(
                    3, "아워떡볶이", 5, "2024-10-08", "맛있어요"
                ),
                ReviewData(
                    4, "아워떡볶이", 5, "2024-10-08", "맛있어요"
                ),
                ReviewData(
                    5, "아워떡볶이", 5, "2024-10-08", "맛있어요"
                ),
                ReviewData(
                    6, "아워떡볶이", 5, "2024-10-08", "맛있어요"
                ),
                ReviewData(
                    7, "아워떡볶이", 5, "2024-10-08", "맛있어요"
                ),
                ReviewData(
                    8, "아워떡볶이", 5, "2024-10-08", "맛있어요"
                ), ReviewData(
                    9, "아워떡볶이", 5, "2024-10-08", "맛있어요"
                ), ReviewData(
                    10, "아워떡볶이", 5, "2024-10-08", "맛있어요"
                )
            )
        )
    }


}
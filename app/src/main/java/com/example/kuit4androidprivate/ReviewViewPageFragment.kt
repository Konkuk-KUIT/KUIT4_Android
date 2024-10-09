package com.example.kuit4androidprivate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit4androidprivate.adapter.ReviewRVAdapter
import com.example.kuit4androidprivate.databinding.FragmentReviewViewPageBinding
import com.example.kuit4androidprivate.model.ReviewData


class ReviewViewPageFragment : Fragment() {

    lateinit var binding : FragmentReviewViewPageBinding
    var dummyItems = ArrayList<ReviewData>()
    private lateinit var reviewRVAdapter: ReviewRVAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentReviewViewPageBinding.inflate(layoutInflater)
        initDummys()
        initRVAdapter()
        return binding.root
    }

    private fun initDummys() {
        dummyItems.addAll(
            arrayListOf(
                ReviewData(
                    storeName = "아워떡볶이",
                    date = "2024-09-17",
                    comment = "정말 맛있어요"
                ),
                ReviewData(
                    storeName = "아워떡볶이",
                    date = "2024-09-17",
                    comment = "정말 맛있어요"
                ),
                ReviewData(
                    storeName = "아워떡볶이",
                    date = "2024-09-17",
                    comment = "정말 맛있어요"
                ),
                ReviewData(
                    storeName = "아워떡볶이",
                    date = "2024-09-17",
                    comment = "정말 맛있어요"
                ),
                ReviewData(
                    storeName = "아워떡볶이",
                    date = "2024-09-17",
                    comment = "정말 맛있어요"
                )
            )
        )
    }

    private fun initRVAdapter() {
        reviewRVAdapter = ReviewRVAdapter(this,dummyItems)
        binding.rvReview.adapter = reviewRVAdapter
        binding.rvReview.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
    }


}
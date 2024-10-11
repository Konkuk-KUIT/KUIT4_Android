package com.example.kuit4androidprivate.myeats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit4androidprivate.adapter.MyEatsReviewRVAdapter
import com.example.kuit4androidprivate.data.MyEatsReviewData
import com.example.kuit4androidprivate.databinding.FragmentMyEatsReviewBinding
import com.example.kuit4androidprivate.databinding.ItemMyReviewBinding


class MyEatsReviewFragment : Fragment() {

    private lateinit var binding: FragmentMyEatsReviewBinding
    private lateinit var myEatsReviewRVAdapter: MyEatsReviewRVAdapter
    private var MyReviews = arrayListOf(
        MyEatsReviewData("아워떡볶이", "잘 먹었습니다.", "2024-04-11"),
        MyEatsReviewData("아워떡볶이", "잘 먹었습니다.", "2024-04-11"),
        MyEatsReviewData("아워떡볶이", "잘 먹었습니다.", "2024-04-11"),
        MyEatsReviewData("아워떡볶이", "잘 먹었습니다.", "2024-04-11"),
        MyEatsReviewData("아워떡볶이", "잘 먹었습니다.", "2024-04-11")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyEatsReviewBinding.inflate(layoutInflater)

        myEatsReviewRVAdapter = MyEatsReviewRVAdapter(requireActivity(), MyReviews)
        binding.rvMyEatsReview.adapter = myEatsReviewRVAdapter
        binding.rvMyEatsReview.layoutManager = LinearLayoutManager(requireActivity())

        return binding.root

    }

}
package com.example.kuit4androidprivate.myeats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit4androidprivate.adapter.MyPageReviewRVAdapter
import com.example.kuit4androidprivate.databinding.FragmentMyPageReviewBinding
import com.example.kuit4androidprivate.dataclasss.MyPageReviewData


class MyPageReviewFragment : Fragment() {

    private lateinit var binding: FragmentMyPageReviewBinding
    private lateinit var rvAdapter: MyPageReviewRVAdapter
    private val dummyItems = ArrayList<MyPageReviewData>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyPageReviewBinding.inflate(layoutInflater)

        initDummyReview()
        initRVAdapter()

        return  binding.root
    }

    private fun initRVAdapter() {
        rvAdapter = MyPageReviewRVAdapter(requireContext(),dummyItems)

        with(binding.rvMyPageReview){
            adapter = rvAdapter
            layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL,false)
        }
    }

    private fun initDummyReview() {
        dummyItems.addAll(
            arrayListOf(
                MyPageReviewData(
                    name = "아워떡볶이", date = "2024-04-11", review ="맛있게 잘 먹었습니다"
                ),
                MyPageReviewData(
                    name = "아워떡볶이", date = "2024-04-11", review ="맛있게 잘 먹었습니다"
                ),
                MyPageReviewData(
                    name = "아워떡볶이", date = "2024-04-11", review ="맛있게 잘 먹었습니다"
                ),
                MyPageReviewData(
                    name = "아워떡볶이", date = "2024-04-11", review ="맛있게 잘 먹었습니다"
                ),
                MyPageReviewData(
                    name = "아워떡볶이", date = "2024-04-11", review ="맛있게 잘 먹었습니다"
                )
            )
        )
    }

}
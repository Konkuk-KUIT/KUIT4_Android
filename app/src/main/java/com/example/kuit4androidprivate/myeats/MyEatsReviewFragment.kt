package com.example.kuit4androidprivate.myeats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit4androidprivate.databinding.FragmentMyEatsReviewBinding

class MyEatsReviewFragment : Fragment() {

    private lateinit var binding: FragmentMyEatsReviewBinding
    private lateinit var reviewAdapter: MyEatsReviewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyEatsReviewBinding.inflate(inflater, container, false)

        initData()

        binding.rvMyEatsReview.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMyEatsReview.adapter = reviewAdapter

        return binding.root
    }

    private fun initData() {
        val reviewList = listOf(
            MyEatsReviewItem("요아정", "초코쉘 추가 무조건", "2024-10-11", 5),
            MyEatsReviewItem("요아정", "큐브치즈케이크 추가 무조건", "2024-10-10", 4),
            MyEatsReviewItem("요아정", "팝핑초코 추가 무조건", "2024-10-09", 5),
            MyEatsReviewItem("요아정", "냠냠", "2024-10-08", 5),
            MyEatsReviewItem("요아정", "굿", "2024-10-07", 5)
        )

        reviewAdapter = MyEatsReviewAdapter(reviewList)
    }
}

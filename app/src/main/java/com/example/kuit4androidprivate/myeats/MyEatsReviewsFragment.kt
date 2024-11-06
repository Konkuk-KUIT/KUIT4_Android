package com.example.kuit4androidprivate.myeats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit4androidprivate.adapter.RVAdapterMyEatsFavorite
import com.example.kuit4androidprivate.adapter.RVAdapterMyEatsReview
import com.example.kuit4androidprivate.databinding.FragmentMyEatsReviewsBinding
import com.example.kuit4androidprivate.model.MenuData
import com.example.kuit4androidprivate.model.ReviewData

class MyEatsReviewsFragment: Fragment() {
    private lateinit var binding : FragmentMyEatsReviewsBinding
    private lateinit var rvAdapterMyEatsReview: RVAdapterMyEatsReview
    private val reviewItem = arrayListOf<ReviewData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyEatsReviewsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initReviews()
        initRVAdaterMyEatsReview()
    }

    private fun initRVAdaterMyEatsReview() {
        rvAdapterMyEatsReview= RVAdapterMyEatsReview(requireContext(), reviewItem)

        with(binding.rvReviews) {
            adapter = rvAdapterMyEatsReview
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun initReviews() {
        reviewItem.addAll(
            arrayListOf(
                ReviewData(
                    restaurantName = "모터시티",
                    review = "맛있게 잘 먹었습니다",
                    date = "2024-04-11"
                ),
                ReviewData(
                    restaurantName = "지노스 피자",
                    review = "맛있게 잘 먹었습니다",
                    date = "2024-04-12"
                ),
                ReviewData(
                    restaurantName = "우래옥",
                    review = "맛있게 잘 먹었습니다",
                    date = "2024-04-13"
                ),
                ReviewData(
                    restaurantName = "부산안면옥",
                    review = "맛있게 잘 먹었습니다",
                    date = "2024-04-14"
                ),
                ReviewData(
                    restaurantName = "소원반점",
                    review = "맛있게 잘 먹었습니다",
                    date = "2024-04-15"
                ),
            )
        )

    }

}
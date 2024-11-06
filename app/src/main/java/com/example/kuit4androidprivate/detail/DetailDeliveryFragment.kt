package com.example.kuit4androidprivate.detail

import android.content.Context
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.adapter.DetailDeliveryRVAdapter
import com.example.kuit4androidprivate.databinding.FragmentDetailDeliveryBinding
import com.example.kuit4androidprivate.model.DishData

class DetailDeliveryFragment : Fragment() {


    private lateinit var binding : FragmentDetailDeliveryBinding
    private lateinit var rvAdapter: DetailDeliveryRVAdapter
    private val items = ArrayList<DishData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        inflater.cloneInContext(ContextThemeWrapper(activity, R.style.Base_Theme_Kuit4AndroidPrivate2))

        binding = FragmentDetailDeliveryBinding.inflate(layoutInflater)

        initMenu()
        initDetailDeliveryRVAdapter()


        return binding.root


    }

    private fun initMenu() {
        items.addAll(
            arrayListOf(
                DishData("떡볶이", "5,000원", R.drawable.image1),
                 DishData("김말이", "3,000원", R.drawable.image2),
                 DishData("김밥", "3,500원", R.drawable.image3),
                DishData("돈가스", "9,000원", R.drawable.image4)
            )
        )
    }

    private fun initDetailDeliveryRVAdapter() {
        rvAdapter = DetailDeliveryRVAdapter(requireContext(), items)
        binding.rvDetailDelivery.adapter = rvAdapter
        binding.rvDetailDelivery.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

    }
}
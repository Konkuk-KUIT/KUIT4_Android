package com.example.kuit4androidprivate.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.detail.adapter.LinearDetailRVAdapter
import com.example.kuit4androidprivate.databinding.FragmentDetailPackingBinding
import com.example.kuit4androidprivate.model.DetailData

class DetailPackingFragment : Fragment() {
    private lateinit var binding: FragmentDetailPackingBinding
    private var detailDataItems = ArrayList<DetailData>()
    private lateinit var linearDetailRVAdapter: LinearDetailRVAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailPackingBinding.inflate(layoutInflater)
        initDeliveryData()
        initRVAdapter()
        return binding.root
    }

    private fun initDeliveryData() {
        detailDataItems.addAll(
            arrayListOf(
                DetailData(
                    "떢볶이", R.drawable.img_detail_item_snack_food, "5,000원"
                ),
                DetailData(
                    "김말이", R.drawable.img_detail_item_kim, "3,000원"
                ),
                DetailData(
                    "김밥", R.drawable.img_detail_item_kim_bap, "3,500원"
                ),
                DetailData(
                    "돈까스", R.drawable.img_detail_item_cutlet, "9,000원"
                ),
            )
        )
    }

    private fun initRVAdapter() {
        linearDetailRVAdapter =
            LinearDetailRVAdapter(requireActivity(), detailDataItems)
        binding.rvDetailPacking.apply {
            adapter = linearDetailRVAdapter
            layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        }
    }

}

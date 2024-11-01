package com.example.kuit4androidprivate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit4androidprivate.adapter.MenuOrderDeliveryRVAdapter
import com.example.kuit4androidprivate.databinding.FragmentFavoritesOrderPackageBinding
import com.example.kuit4androidprivate.model.OrderData


class FavoritesOrderPackageFragment : Fragment() {
    private lateinit var binding: FragmentFavoritesOrderPackageBinding
    private lateinit var rvAdapter: MenuOrderDeliveryRVAdapter
    val dummyItems = ArrayList<OrderData>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritesOrderPackageBinding.inflate(layoutInflater)
        initDummyItems()
        initRVAdapter()
        return binding.root
    }

    private fun initRVAdapter() {
        rvAdapter = MenuOrderDeliveryRVAdapter(requireContext(), dummyItems)
        binding.rvPackageRecyclerView.adapter = rvAdapter
        binding.rvPackageRecyclerView.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL, false
        )
    }

    private fun initDummyItems() {

        dummyItems.addAll(
            arrayListOf(
                OrderData(
                    name = "떡볶이", image = R.drawable.img_order_1, price = "5,000원"
                ),
                OrderData(
                    name = "김말이", image = R.drawable.img_order_2, price = "3,000원"
                ),
                OrderData(
                    name = "김밥", image = R.drawable.img_order_3, price = "3,500원"
                ),
                OrderData(
                    name = "돈까스", image = R.drawable.img_order_4, price = "9,000원"
                )


            )
        )
    }


}
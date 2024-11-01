package com.example.kuit4androidprivate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit4androidprivate.adapter.MenuOrderDeliveryRVAdapter
import com.example.kuit4androidprivate.databinding.FragmentFavoritesOrderDeliveryBinding
import com.example.kuit4androidprivate.model.OrderData


class FavoritesOrderDeliveryFragment : Fragment() {
    lateinit var binding: FragmentFavoritesOrderDeliveryBinding
    lateinit var menuOrderRVAdapter : MenuOrderDeliveryRVAdapter
    val dummyItems =  ArrayList<OrderData>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritesOrderDeliveryBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDummyItems()
        initRVAdapter()
    }

    private fun initRVAdapter() {
        menuOrderRVAdapter = MenuOrderDeliveryRVAdapter(requireContext(),dummyItems)

        binding.rvDeliveryRecyclerView.adapter = menuOrderRVAdapter
        binding.rvDeliveryRecyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)

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
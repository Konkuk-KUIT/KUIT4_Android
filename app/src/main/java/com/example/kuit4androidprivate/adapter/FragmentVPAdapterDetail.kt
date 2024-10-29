package com.example.kuit4androidprivate.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kuit4androidprivate.detail.DetailDeliveryFragment
import com.example.kuit4androidprivate.detail.DetailToGoFragment
import com.example.kuit4androidprivate.myeats.MyEatsReviewsFragment

class FragmentVPAdapterDetail(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int{
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> DetailDeliveryFragment()
            1 -> DetailToGoFragment()
            else -> DetailDeliveryFragment()
        }
    }
}
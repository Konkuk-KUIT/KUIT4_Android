package com.example.kuit4androidprivate.detail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class DetailFragmentAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> DetailDeliveryFragment()
            1 -> DetailPackagingFragment()
            else -> throw IllegalArgumentException("Invalid position")
        }
    }
}

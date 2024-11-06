package com.example.kuit4androidprivate.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kuit4androidprivate.FavoritesOrderDeliveryFragment
import com.example.kuit4androidprivate.FavoritesOrderPackageFragment


class FavoritesOrderVPAdapter (fragmentActivity: FragmentActivity) :FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> FavoritesOrderDeliveryFragment()
            1 -> FavoritesOrderPackageFragment()
            else -> throw IllegalArgumentException("$position")
        }
    }
}
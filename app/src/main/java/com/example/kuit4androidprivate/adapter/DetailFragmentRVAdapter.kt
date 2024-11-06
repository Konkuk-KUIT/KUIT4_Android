package com.example.kuit4androidprivate.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kuit4androidprivate.detail.DetailDeliveryFragment
import com.example.kuit4androidprivate.detail.DetailMainFragment
import com.example.kuit4androidprivate.detail.DetailTogoFragment

class DetailFragmentRVAdapter(fragment: DetailMainFragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> DetailDeliveryFragment()
            else  -> DetailTogoFragment()
        }
    }

}
package com.example.kuit4androidprivate.detail.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kuit4androidprivate.detail.DetailDeliverFragment
import com.example.kuit4androidprivate.detail.DetailTogoFragment

class DetailVPAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> DetailDeliverFragment()
            else -> DetailTogoFragment()
        }
    }
}
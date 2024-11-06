package com.example.kuit4androidprivate.myeats.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kuit4androidprivate.myeats.fragment.MyEatsFavoriteFragment
import com.example.kuit4androidprivate.myeats.fragment.MyEatsReviewFragment

class MyEatsDetailVPAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> MyEatsReviewFragment()
            else -> MyEatsFavoriteFragment()
        }
    }
}
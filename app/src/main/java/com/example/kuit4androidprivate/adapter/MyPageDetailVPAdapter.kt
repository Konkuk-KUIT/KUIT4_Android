package com.example.kuit4androidprivate.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kuit4androidprivate.myeats.MyPageFavoriteFragment
import com.example.kuit4androidprivate.myeats.MyPageReviewFragment

class MyPageDetailVPAdapter(fragment : Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> MyPageReviewFragment()
            else -> MyPageFavoriteFragment()
        }

    }
}
package com.example.kuit4androidprivate.myeats

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyEatsPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MyEatsReviewFragment()
            1 -> MyEatsFavoriteFragment()
            else -> MyEatsReviewFragment()
        }
    }
}

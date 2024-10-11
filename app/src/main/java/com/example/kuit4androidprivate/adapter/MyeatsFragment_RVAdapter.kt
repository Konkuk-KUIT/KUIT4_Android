package com.example.kuit4androidprivate.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kuit4androidprivate.myeats.MyEatsDetailFragment
import com.example.kuit4androidprivate.myeats.MyEatsFavoritesFragment
import com.example.kuit4androidprivate.myeats.MyEatsReviewFragment

class MyeatsFragment_RVAdapter(fragmentActivity: MyEatsDetailFragment) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> MyEatsReviewFragment()
            else  -> MyEatsFavoritesFragment()
        }
    }
}
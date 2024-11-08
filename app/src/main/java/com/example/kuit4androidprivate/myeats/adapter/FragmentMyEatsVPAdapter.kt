package com.example.kuit4androidprivate.myeats.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kuit4androidprivate.myeats.MyEatsLikeFragment
import com.example.kuit4androidprivate.myeats.MyEatsReviewFragment

class FragmentMyEatsVPAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MyEatsReviewFragment()
            else -> MyEatsLikeFragment()
        }
    }

}
package com.example.kuit4androidprivate.myeats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kuit4androidprivate.DetailViewPagerFragment
import com.example.kuit4androidprivate.MyEatsDetailFragment
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.databinding.FragmentMyEatsBinding

class MyEatsFragment : Fragment() {

    private lateinit var binding: FragmentMyEatsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyEatsBinding.inflate(layoutInflater)
        return binding.root
    }

    fun showBackButton() {
        // 현재 버튼의 가시성을 가져옴
        val visibility = binding.ivMyEatsBackButton.visibility
        binding.ivMyEatsBackButton.visibility = if (visibility == View.VISIBLE) {
            View.GONE
        } else {
            View.VISIBLE
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val detailFragment = MyEatsDetailFragment()
        childFragmentManager.beginTransaction()
            .replace(R.id.fcv_my_eats, detailFragment)
            .addToBackStack(null)
            .commit()

        binding.ivMyEatsBackButton.setOnClickListener {
            val detailViewPagerFragment = DetailViewPagerFragment()
            childFragmentManager.beginTransaction()
                .replace(R.id.fcv_my_eats, MyEatsDetailFragment())
                .addToBackStack(null)
                .commit()
            showBackButton()

        }


    }



}
package com.example.kuit4androidprivate.myeats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.databinding.FragmentMyEatsBinding

class MyEatsFragment : Fragment() {

    private lateinit var binding: FragmentMyEatsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyEatsBinding.inflate(layoutInflater)

        initReadLikeFragment()
        initBackListener()
        return binding.root
    }

    private fun initBackListener() {
        binding.ivEatsBack.setOnClickListener {
            visibilityBack()
            initReadLikeFragment()
        }
    }


    public fun initReadLikeFragment() {
        val childFragment = ReadMoreFragment()
        childFragmentManager.beginTransaction()
            .replace(R.id.frm_my_eat, childFragment)
            .commit()
    }

    public fun visibilityBack() {
        if (binding.ivEatsBack.visibility == View.VISIBLE) {
            binding.ivEatsBack.visibility = View.INVISIBLE
        } else {
            binding.ivEatsBack.visibility = View.VISIBLE
        }
    }

    public fun initReviewLikeFragment() {//MyEatsReviewLikeFragment
        val childFragment = MyEatsReviewLikeFragment()
        childFragmentManager.beginTransaction()
            .replace(R.id.frm_my_eat, childFragment)
            .commit()
    }

}

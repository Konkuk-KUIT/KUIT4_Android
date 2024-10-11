package com.example.kuit4androidprivate.myeats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.databinding.FragmentMyPageBinding

class MyPageFragment : Fragment() {

    private lateinit var binding : FragmentMyPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyPageBinding.inflate(layoutInflater)
        binding.whiteblueBox.setOnClickListener {
            initMyPageReviewFragment()
            initShowButton()
        }
        return binding.root
    }


    private fun initShowButton() {
        // MyPageFragment에서 MyEatsFragment 외부에 있는 iv_myeats_back의 가시성 변경
        val ivMyeatsBack = requireActivity().findViewById<ImageView>(R.id.iv_myeats_back)
        ivMyeatsBack.visibility = View.VISIBLE
    }



    private fun initMyPageReviewFragment(){
        val newfragment = MyPageDetailFragment()
        parentFragmentManager.beginTransaction()
            .replace(R.id.fcv_myeats_page, newfragment)
            .commit()
    }


}
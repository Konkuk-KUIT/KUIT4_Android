package com.example.kuit4androidprivate.myeats

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kuit4androidprivate.databinding.FragmentMyEatsBinding
import com.example.kuit4androidprivate.keep.KeepActivity

class MyEatsFragment : Fragment() {

    private lateinit var binding : FragmentMyEatsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyEatsBinding.inflate(layoutInflater)
        initListener()
        return binding.root
    }

    private fun initListener() {
        binding.likeLayout.setOnClickListener{//fragment는 context가 없음
            val intent = Intent(requireActivity(), KeepActivity::class.java)
            startActivity(intent)
        }
    }


}

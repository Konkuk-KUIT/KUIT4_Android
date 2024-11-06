package com.example.kuit4androidprivate.myeats

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.databinding.ActivityKeepBinding
import com.example.kuit4androidprivate.databinding.FragmentMyEatsBinding
import com.example.kuit4androidprivate.home.HomeFragment
import com.example.kuit4androidprivate.keep.KeepActivity

class MyEatsFragment : Fragment() {

    private lateinit var binding : FragmentMyEatsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyEatsBinding.inflate(layoutInflater)
        return binding.root
    }

    //UI 생성후에 실행되는 함수, fragment에서만 사용
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        childFragmentManager
            .beginTransaction()
            .replace(R.id.my_eats_frm, MyEatsDefaultFragment())
            .addToBackStack(null)
            .commit()

        backVisibilityCheck()

        childFragmentManager.addOnBackStackChangedListener {
            backVisibilityCheck()
        }

        binding.ivMyEatsBack.setOnClickListener{
            childFragmentManager
                .beginTransaction()
                .replace(R.id.my_eats_frm, MyEatsDefaultFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    private fun backVisibilityCheck(){
        //binding을 사용하면 어떤 Fragment인지는 알지 못하므로 findFragmentById 사용
//        var currentFragment = binding.myEatsFrm
        val currentFragment = childFragmentManager.findFragmentById(R.id.my_eats_frm)
        if (currentFragment is MyEatsDefaultFragment) {
            binding.ivMyEatsBack.visibility = View.GONE
        }else{
            binding.ivMyEatsBack.visibility = View.VISIBLE
        }
    }
}
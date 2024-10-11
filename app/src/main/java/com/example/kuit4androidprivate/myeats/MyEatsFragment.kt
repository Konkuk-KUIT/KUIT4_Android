package com.example.kuit4androidprivate.myeats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.databinding.FragmentMyEatsBinding

class MyEatsFragment : Fragment() {

    private lateinit var binding : FragmentMyEatsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyEatsBinding.inflate(layoutInflater)

        val mainFragment = MyEatsMainFragment.newInstance()

        binding.ivMyEatsArrow.visibility = View.GONE
        arrowVisibilityCheck()

        childFragmentManager.addOnBackStackChangedListener {
            arrowVisibilityCheck()
        }

        binding.ivMyEatsArrow.setOnClickListener{
            childFragmentManager.beginTransaction()
                .replace(R.id.fcv_my_eats, mainFragment)
                .addToBackStack(null)
                .commit()
        }

        return binding.root
    }

    private fun arrowVisibilityCheck() {
        val currentFragment = childFragmentManager.findFragmentById(R.id.fcv_my_eats)
        if(currentFragment is MyEatsMainFragment) {
            binding.ivMyEatsArrow.visibility = View.GONE
        }
        else {
            binding.ivMyEatsArrow.visibility = View.VISIBLE
        }
    }

}
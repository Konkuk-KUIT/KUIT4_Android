package com.example.kuit4androidprivate.myeats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.databinding.FragmentMyEatsMainBinding


class MyEatsMainFragment : Fragment() {

    private lateinit var binding: FragmentMyEatsMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyEatsMainBinding.inflate(layoutInflater)

        val fragmentManager = childFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.fcv_my_eats, MyEatsDetailFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()

        return binding.root
    }

}
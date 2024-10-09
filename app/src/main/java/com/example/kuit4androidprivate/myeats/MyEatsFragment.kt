package com.example.kuit4androidprivate.myeats

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kuit4androidprivate.MyEatsDetailFragment
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.databinding.FragmentMyEatsBinding
import kotlin.math.log

class MyEatsFragment : Fragment() {

    private lateinit var binding: FragmentMyEatsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("a","d")
        binding = FragmentMyEatsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val detailFragment = MyEatsDetailFragment()
        childFragmentManager.beginTransaction()
            .replace(R.id.fcv_my_eats, detailFragment)
            .addToBackStack(null)
            .commit()

    }

    fun showBackButton(){
        binding.ivMyEatsBackButton.visibility = View.VISIBLE
    }



}
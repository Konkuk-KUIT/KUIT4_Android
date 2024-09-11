package com.example.kuit4androidprivate.myeats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kuit4androidprivate.databinding.FragmentMyEatsBinding

class MyEatsFragment : Fragment() {

    private lateinit var binding : FragmentMyEatsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyEatsBinding.inflate(layoutInflater)
        return binding.root
    }

}
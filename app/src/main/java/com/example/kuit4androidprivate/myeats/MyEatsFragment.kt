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

        binding.clMykeep.setOnClickListener {
            val intent = Intent(requireContext(), KeepActivity::class.java)
        startActivity(intent)
        }

        return binding.root
    }

}
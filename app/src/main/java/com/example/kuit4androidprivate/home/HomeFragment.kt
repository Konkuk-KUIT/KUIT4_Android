package com.example.kuit4androidprivate.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kuit4androidprivate.DetailActivity
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.clRecentTteokbokki.setOnClickListener {
            initDetail()
        }
        return binding.root
    }

    private fun initDetail() {
        val intent = Intent(requireActivity(), DetailActivity::class.java)
        startActivity(intent)
    }
}
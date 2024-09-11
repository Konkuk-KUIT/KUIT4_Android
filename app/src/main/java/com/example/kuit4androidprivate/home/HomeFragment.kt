package com.example.kuit4androidprivate.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.databinding.FragmentHomeBinding
import com.example.kuit4androidprivate.detail.DetailActivity
import com.example.kuit4androidprivate.favorite.FavoriteActivity


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.clOurrickcake.setOnClickListener {
            val intent = Intent(activity, DetailActivity::class.java)
            startActivity(intent)


        }

        binding.sivOrderButton.setOnClickListener {
            val intent = Intent(activity, FavoriteActivity::class.java)
            startActivity(intent)
        }
    }
}
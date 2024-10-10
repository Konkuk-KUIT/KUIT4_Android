package com.example.kuit4androidprivate.myeats

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.databinding.FragmentMyEatsFavoriteBinding

class MyEatsFavoriteFragment : Fragment() {

    private lateinit var binding: FragmentMyEatsFavoriteBinding
    private lateinit var favoriteAdapter: MyEatsFavoriteAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyEatsFavoriteBinding.inflate(inflater, container, false)

        val favoriteList = listOf(
            MyEatsFavoriteItem("아워떡볶이", "5.0", "(4,444)", R.drawable.img_home_food),
            MyEatsFavoriteItem("아워떡볶이", "4.5", "(3,320)", R.drawable.img_home_food),
            MyEatsFavoriteItem("아워떡볶이", "4.7", "(2,100)", R.drawable.img_home_food)
        )
        Log.d("MyEatsFavoriteFragment", "사이즈확인: ${favoriteList.size}")

        favoriteAdapter = MyEatsFavoriteAdapter(favoriteList)
        binding.rvMyEatsFavorite.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMyEatsFavorite.adapter = favoriteAdapter
        favoriteAdapter.notifyDataSetChanged()

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        Log.d("MyEatsFavoriteFragment", "onResume확인")
    }
}

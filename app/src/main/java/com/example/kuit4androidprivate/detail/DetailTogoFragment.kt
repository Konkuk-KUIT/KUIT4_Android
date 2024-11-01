package com.example.kuit4androidprivate.detail

import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.adapter.DetailTogoRVAdapter
import com.example.kuit4androidprivate.databinding.FragmentDetailTogoBinding
import com.example.kuit4androidprivate.model.DishData

class DetailTogoFragment : Fragment() {

    private lateinit var binding : FragmentDetailTogoBinding
    private lateinit var rvAdapter: DetailTogoRVAdapter
    private val items = ArrayList<DishData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        inflater.cloneInContext(ContextThemeWrapper(activity, R.style.Base_Theme_Kuit4AndroidPrivate2))
        binding = FragmentDetailTogoBinding.inflate(layoutInflater)

        initMenu()
        initDetailTogoRVAdapter()


        return binding.root


    }

    private fun initMenu() {
        items.addAll(
            arrayListOf(
                DishData("떡볶이", "5,000원", R.drawable.image1),
                DishData("김말이", "3,000원", R.drawable.image2),
                DishData("김밥", "3,500원", R.drawable.image3),
                DishData("돈가스", "9,000원", R.drawable.image4)
            )
        )
    }

    private fun initDetailTogoRVAdapter() {
        rvAdapter = DetailTogoRVAdapter(requireContext(), items)
        binding.rvDetailTogo.adapter = rvAdapter
        binding.rvDetailTogo.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

    }

}
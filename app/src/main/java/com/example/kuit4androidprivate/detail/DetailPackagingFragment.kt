package com.example.kuit4androidprivate.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.databinding.FragmentDetailPackagingBinding

class DetailPackagingFragment : Fragment() {

    private var _binding: FragmentDetailPackagingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailPackagingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = listOf(
            DetailItem("떡볶이", "5,000원", R.drawable.img_snackfood),
            DetailItem("김말이", "3,000원", R.drawable.img_snackfood),
            DetailItem("김밥", "3,500원", R.drawable.img_snackfood),
            DetailItem("돈까스", "9,000원", R.drawable.img_snackfood)
        )

        binding.rvDetailDelivery.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = DetailItemAdapter(items)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

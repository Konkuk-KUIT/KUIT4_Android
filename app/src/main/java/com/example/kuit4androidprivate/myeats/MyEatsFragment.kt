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

override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    // context와 Toast 사용
    binding.btnHome.setOnClickListener {
        Toast.makeText(requireContext(), "홈 버튼 클릭됨", Toast.LENGTH_SHORT).show()
    }

    binding.btnSearch.setOnClickListener {
        Toast.makeText(requireContext(), "검색 버튼 클릭됨", Toast.LENGTH_SHORT).show()
    }

    binding.btnFavorite.setOnClickListener {
        Toast.makeText(requireContext(), "즐겨찾기 버튼 클릭됨", Toast.LENGTH_SHORT).show()
    }

    binding.btnOrderHistory.setOnClickListener {
        Toast.makeText(requireContext(), "주문내역 버튼 클릭됨", Toast.LENGTH_SHORT).show()
    }

    binding.btnMyEats.setOnClickListener {
        Toast.makeText(requireContext(), "My 이츠 버튼 클릭됨", Toast.LENGTH_SHORT).show()
    }
}

override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
}
}
class MyEatsFragment : Fragment() {

    private var _binding: FragmentMyEatsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyEatsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnFavorite.setOnClickListener {
            val intent = Intent(activity, activity_keep::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}





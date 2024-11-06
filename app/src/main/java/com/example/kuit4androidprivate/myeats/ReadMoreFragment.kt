package com.example.kuit4androidprivate.myeats

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kuit4androidprivate.databinding.FragmentMyEatsReadMoreBinding
import com.example.kuit4androidprivate.keep.KeepActivity

class ReadMoreFragment : Fragment() {

    private lateinit var binding: FragmentMyEatsReadMoreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyEatsReadMoreBinding.inflate(layoutInflater)


        initLookChangeFragmentListener()
        initLikeListener()

        return binding.root
    }

    private fun initLookChangeFragmentListener() {
        binding.ivEatsFragmentLook
            .setOnClickListener {
                val parentFragment = parentFragment as? MyEatsFragment
                parentFragment?.let {
                    it.visibilityBack()
                    it.initReviewLikeFragment()
                }
                //프래그먼트 교체 + 부모에 있는 뒤로가기 버튼 다시 나오게
            }
    }

    private fun initLikeListener() {
        binding.LLEatsFragmentLike
            .setOnClickListener {//fragment는 context가 없음
                val intent = Intent(requireActivity(), KeepActivity::class.java)
                startActivity(intent)
            }
    }

}
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
        //이 부분은 나중에 onViewCreated 에 넣어주는게 좋다.
        // 왜? onCreateView는 inflate 의 역할을 하는거라서 추가적인 기능을 구현하는 장소는 아니긴 한데 사용가능하긴해서 지금처럼 써도 됨
        binding.layoutMyeatLike.setOnClickListener{
            initKeepFragment()
        }

        return binding.root
    }
    //중요 !!! MyEatsFragment 에서 KeepActivity 로 이동하기 위한 방법

    private fun initKeepFragment() {
        val intent = Intent(requireActivity(),KeepActivity::class.java)
        startActivity(intent)
    }


}
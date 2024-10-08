package com.example.kuit4androidprivate.myeats

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.databinding.ActivityKeepBinding
import com.example.kuit4androidprivate.databinding.FragmentMyEatsBinding
import com.example.kuit4androidprivate.home.HomeFragment
import com.example.kuit4androidprivate.keep.KeepActivity

class MyEatsFragment : Fragment() {

    private lateinit var binding : FragmentMyEatsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyEatsBinding.inflate(layoutInflater)
        return binding.root
    }

    //UI 생성후에 실행되는 함수, fragment에서만 사용
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //KeepActivity로 전환하기 위한 함수
//        binding.clMyEatsLikeContainer.setOnClickListener {
////            fragment는 context를 상속받지 않아서 this를 인자로 주면 안되고,
////            requireContext() 나 activity를 인자로 줘야한다
//            val intent = Intent(activity, KeepActivity::class.java)
//            startActivity(intent)
//        }

//        myeats 화면에서 뒤로가기 버튼 삭제
//        binding.ivMyEatsBack.setOnClickListener{
//           requireActivity().onBackPressedDispatcher.onBackPressed()
//        }

        parentFragmentManager
            .beginTransaction()
            .replace(R.id.my_eats_frm, MyEatsDefaultFragment())
            .commitAllowingStateLoss()

        binding.ivMyEatsBack.visibility = View.GONE


    }
}
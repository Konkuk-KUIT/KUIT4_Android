package com.example.kuit4androidprivate.myeats

import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.databinding.FragmentMyeatsMainBinding

class MyEatsMainFragment : Fragment() {

    lateinit var binding : FragmentMyeatsMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyeatsMainBinding.inflate(layoutInflater)

        binding.btnMyeatsDetail.setOnClickListener{
            val parentFragment = parentFragment as? MyEatsFragment
            parentFragment?.changeBackButttomVisibility(View.VISIBLE)

            parentFragmentManager
                .beginTransaction()
                .replace(R.id.fcv_myeats, MyEatsDetailFragment())
                .commit()
        }

        return binding.root
    }

}
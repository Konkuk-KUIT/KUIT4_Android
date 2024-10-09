package com.example.kuit4androidprivate.myeats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.databinding.FragmentMyEatsDefaultBinding

class MyEatsDefaultFragment: Fragment() {
    private lateinit var binding: FragmentMyEatsDefaultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyEatsDefaultBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnMyEatsSeeDetail.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.my_eats_frm, MyEatsDetailsContainerFragment())
                .addToBackStack(null)
                .commitAllowingStateLoss()
        }
    }
}
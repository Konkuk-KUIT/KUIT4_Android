package com.example.kuit4androidprivate.myeats

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentManager
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.databinding.FragmentMyEatsBinding
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.clMyeatsFav.setOnClickListener{
            val intent = Intent(context, KeepActivity::class.java)
            startActivity(intent)
        }

        binding.ivMyeatsBack.setOnClickListener{
            changeBackButttomVisibility(View.GONE)
            childFragmentManager
                .beginTransaction()
                .replace(R.id.fcv_myeats, MyEatsMainFragment())
                .commit()
        }

    }

    fun changeBackButttomVisibility(visible: Int) {
        view?.findViewById<ImageView>(R.id.iv_myeats_back)?.visibility = visible
    }
}
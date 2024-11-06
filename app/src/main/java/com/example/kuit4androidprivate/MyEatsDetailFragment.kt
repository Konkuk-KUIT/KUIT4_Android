package com.example.kuit4androidprivate

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kuit4androidprivate.adapter.MyEatsFragmentVPAdatper
import com.example.kuit4androidprivate.databinding.FragmentDetailViewPagerBinding
import com.example.kuit4androidprivate.databinding.FragmentMyEatsBinding
import com.example.kuit4androidprivate.databinding.FragmentMyEatsDetailBinding
import com.example.kuit4androidprivate.detail.DetailActivity
import com.example.kuit4androidprivate.keep.KeepActivity
import com.example.kuit4androidprivate.myeats.MyEatsFragment

class MyEatsDetailFragment : Fragment() {
    lateinit var binding: FragmentMyEatsDetailBinding
    lateinit var viewPagerBinding : FragmentDetailViewPagerBinding
    lateinit var myEatsBinding : FragmentMyEatsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMyEatsDetailBinding.inflate(layoutInflater)
        intentToKeepActivity()
        return binding.root
    }

    private fun intentToKeepActivity() {
        binding.btnMyEatsMoveKeep.setOnClickListener {
            val intent = Intent(requireActivity(), KeepActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.btnMyEatsMoveKeep.setOnClickListener {

            val parentFragment = parentFragment as? MyEatsFragment
            parentFragment?.showBackButton()

            val viewFragment = DetailViewPagerFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fcv_my_eats, viewFragment)
                .addToBackStack(null)
                .commit()

        }



    }
}
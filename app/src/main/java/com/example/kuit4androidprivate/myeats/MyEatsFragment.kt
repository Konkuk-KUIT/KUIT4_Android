package com.example.kuit4androidprivate.myeats

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kuit4androidprivate.databinding.FragmentMyEatsBinding
import com.example.kuit4androidprivate.keep.KeepActivity
import com.example.kuit4androidprivate.R

class MyEatsFragment : Fragment() {

    private lateinit var binding: FragmentMyEatsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyEatsBinding.inflate(layoutInflater)

        binding.clMyeatsLove.setOnClickListener {
            val intent = Intent(requireContext(), KeepActivity::class.java)
            startActivity(intent)
        }

        binding.clMyeatsDetail.setOnClickListener {
            binding.clMyeatsDetail.visibility = View.GONE
            binding.clMyeatsLove.visibility = View.GONE
            binding.clMyeatsEvent.visibility = View.GONE
            binding.ivMyeatsBack.visibility = View.VISIBLE
            binding.fcMyeats.visibility = View.VISIBLE

            parentFragmentManager.beginTransaction()
                .replace(R.id.fc_myeats, MyEatsDetailFragment())
                .commit()
        }

        binding.ivMyeatsBack.setOnClickListener {
            binding.clMyeatsDetail.visibility = View.VISIBLE
            binding.clMyeatsLove.visibility = View.VISIBLE
            binding.clMyeatsEvent.visibility = View.VISIBLE
            binding.fcMyeats.visibility = View.GONE
            binding.ivMyeatsBack.visibility = View.GONE
        }

        return binding.root
    }
}

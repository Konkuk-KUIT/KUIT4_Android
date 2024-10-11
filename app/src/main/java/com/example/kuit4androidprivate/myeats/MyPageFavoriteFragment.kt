package com.example.kuit4androidprivate.myeats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit4androidprivate.adapter.MyFavoriteRVAdapter
import com.example.kuit4androidprivate.adapter.MyPageReviewRVAdapter
import com.example.kuit4androidprivate.dataClass.MenuData
import com.example.kuit4androidprivate.databinding.FragmentMyPageFavoriteBinding
class MyPageFavoriteFragment : Fragment() {

    private lateinit var binding: FragmentMyPageFavoriteBinding
    private lateinit var rvAdapter: MyFavoriteRVAdapter
    private val dummyItems = ArrayList<MenuData>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyPageFavoriteBinding.inflate(layoutInflater)

        initDummyFavorite()
        initRVAdapter()
        // RecyclerView 설정
        binding.rvMyPageFavorite.adapter = rvAdapter

        return binding.root
    }

    private fun initRVAdapter() {
        rvAdapter = MyFavoriteRVAdapter(requireContext(),dummyItems)

        with(binding.rvMyPageFavorite){
            adapter = rvAdapter
            layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL,false)
        }
    }

    private fun initDummyFavorite() {
        dummyItems.addAll(

            arrayListOf(
                MenuData(
                    title = "벌집피자", time = "40분", rate = "4.0", number = "(3,001)",
                    imageUrl = "https://cdn.pixabay.com/photo/2017/12/10/14/47/pizza-3010062_1280.jpg"
                ),
                MenuData(
                    title = "열정국밥", time = "50분", rate = "4.1", number = "(3,881)",
                    imageUrl = "https://cdn.pixabay.com/photo/2015/07/08/19/40/food-836806_1280.jpg"
                ),
                MenuData(
                    title = "철수파스타", time = "35분", rate = "4.2", number = "(3,456)",
                    imageUrl ="https://cdn.pixabay.com/photo/2018/07/18/19/12/pasta-3547078_1280.jpg"
                )
            )
        )
    }
}

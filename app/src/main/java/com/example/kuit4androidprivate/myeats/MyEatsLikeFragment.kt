package com.example.kuit4androidprivate.myeats

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.adapter.LinearMyEatsLikeRVAdapter
import com.example.kuit4androidprivate.databinding.FragmentMyEatsLikeBinding
import com.example.kuit4androidprivate.model.MenuData

class MyEatsLikeFragment : Fragment() {
    private lateinit var binding: FragmentMyEatsLikeBinding
    private lateinit var linearMyEatsLikeRVAdapter: LinearMyEatsLikeRVAdapter
    private var linearHomeItems = ArrayList<MenuData>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyEatsLikeBinding.inflate(layoutInflater)

        initLinearHomeItems()
        initLinearHomeRVAdapter()
        initLastMarginDecoration()

        return binding.root
    }

    private fun initLastMarginDecoration() {
        binding.rvMyEatsLike.addItemDecoration(LastItemMarginDecoration(30))
    }

    private fun initLinearHomeRVAdapter() {
        linearMyEatsLikeRVAdapter = LinearMyEatsLikeRVAdapter(requireActivity(), linearHomeItems) {
            //클릭시
        }
        binding.rvMyEatsLike.adapter = linearMyEatsLikeRVAdapter
        binding.rvMyEatsLike.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
    }

    private fun initLinearHomeItems() {
        linearHomeItems.addAll(
            arrayListOf(
                MenuData(
                    "https://cdn.pixabay.com/photo/2016/08/20/13/06/toppokki-1607479_1280.jpg",
                    "아워떡볶이", "30분", "4.5", " (1,203)", true
                ),
                MenuData(
                    "https://cdn.pixabay.com/photo/2015/07/08/19/40/food-836806_1280.jpg",
                    "국밥생각", "35분", "4.6", " (1,303)", false
                ),
                MenuData(
                    "https://cdn.pixabay.com/photo/2018/12/04/15/20/chinese-3855829_1280.jpg",
                    "천왕성", "45분", "4.0", "(303)", false
                ),
                MenuData(
                    "https://cdn.pixabay.com/photo/2015/01/13/06/46/meat-597952_640.jpg",
                    "육회바른연어", "25분", "4.9", "(538)", false
                ),
                MenuData(
                    "https://cdn.pixabay.com/photo/2017/06/17/17/11/sashimi-2412779_640.jpg",
                    "육회한연어", "30분", "5.0", " (2,214)", false
                ),
                MenuData(
                    "https://cdn.pixabay.com/photo/2017/12/09/08/18/pizza-3007395_1280.jpg",
                    "청년피자", "39분", "4.8", " (1,586)", false
                ),
                MenuData(
                    "https://cdn.pixabay.com/photo/2017/08/06/06/43/pizza-2589575_640.jpg",
                    "더피자", "33분", "5.0", "(879)", false
                ),
                MenuData(
                    "https://cdn.pixabay.com/photo/2015/03/11/00/31/chicken-667935_640.jpg",
                    "푸라닭", "23분", "4.8", "(296)", false
                ),
                MenuData(
                    "https://cdn.pixabay.com/photo/2023/08/08/08/46/tacos-8176774_640.jpg",
                    "타코벨", "26분", "4.8", "(100)", false
                ),
                MenuData(
                    "https://cdn.pixabay.com/photo/2019/09/26/18/23/republic-of-korea-4506696_1280.jpg",
                    "노랑통닭", "32분", "4.9", "(451)", false
                )
            )
        )
    }
    inner class LastItemMarginDecoration(private val bottomMargin: Int) :
        RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            val position = parent.getChildLayoutPosition(view)
            val itemCount = state.itemCount

            if (position == itemCount - 1) {
                outRect.bottom = bottomMargin
            }
        }
    }
}

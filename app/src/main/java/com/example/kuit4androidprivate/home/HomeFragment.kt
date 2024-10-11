package com.example.kuit4androidprivate.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.adapter.HomeVPAdapter
import com.example.kuit4androidprivate.adapter.RVAdapter
import com.example.kuit4androidprivate.adapter.RVAdapterGrid
import com.example.kuit4androidprivate.databinding.FragmentHomeBinding
import com.example.kuit4androidprivate.dataClass.MenuCategoryData
import com.example.kuit4androidprivate.dataClass.MenuData
import com.example.kuit4androidprivate.dataClass.HomeVPData
import com.example.kuit4androidprivate.detail.DetailActivity
import com.example.kuit4androidprivate.detail.FavoriteActivity
import com.example.kuit4androidprivate.myeats.MyEatsFragment


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var rvAdapter: RVAdapter
    private lateinit var foodAdapter: RVAdapterGrid
    private lateinit var vpAdapter: HomeVPAdapter// 어댑터 선언

    private lateinit var imgitems:ArrayList<String>
    private lateinit var txtitems:ArrayList<String>

    private val dummyItems = ArrayList<MenuData>()
    private val dummyItems2 = ArrayList<MenuCategoryData>()
    private val VPitems = ArrayList<HomeVPData>()





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.tvHomeRecent.setOnClickListener{
            initmyeatFragment()
        }
        binding.sivMainOrder.setOnClickListener{
            initFavoriteActivity()
        }
        initDummyFood()
        initDummy()
        initRVAdapter()
        initFoodAdapter()

        initVPData()
        initVP()
        return binding.root

    }

    private fun initVP() {
        vpAdapter = HomeVPAdapter()
        binding.vpHome.adapter = vpAdapter
        vpAdapter.submitList(VPitems)
        binding.vpHome.currentItem = 1000

        // ViewPager의 페이지가 변경될 때 호출되는 콜백을 추가
        binding.vpHome.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                // 페이지가 변경될 때 tv_home_vp_present 값을 변경
                val currentPage = (position % VPitems.size) + 1 // 1부터 시작하도록 설정
                binding.tvHomeVpPresent.text = currentPage.toString() // 현재 페이지 설정
            }
        })
    }


    private fun initVPData() {
        imgitems = arrayListOf(
            "https://cdn.pixabay.com/photo/2023/08/08/15/15/strawberries-8177601_640.jpg",
            "https://cdn.pixabay.com/photo/2017/12/10/14/47/pizza-3010062_640.jpg",
            "https://cdn.pixabay.com/photo/2021/11/09/07/21/pastry-6780834_640.jpg",
            "https://cdn.pixabay.com/photo/2017/01/30/13/49/pancakes-2020863_640.jpg",
            "https://cdn.pixabay.com/photo/2017/03/23/19/57/asparagus-2169305_640.jpg"
        )



        for (i in 1 until 6){
            VPitems.add(
                HomeVPData(
                    id = i,
                    imgUrl = imgitems[i - 1]
                )
            )
        }


    }


    private fun initDummyFood() {
        dummyItems2.addAll(
            arrayListOf(
                MenuCategoryData(
                    name = "돈까스",
                    image = R.drawable.pork
                ),
                MenuCategoryData(
                    name = "일식",
                    image = R.drawable.japanese
                ),
                MenuCategoryData(
                    name = "한식",
                    image = R.drawable.korean
                ),
                MenuCategoryData(
                    name = "치킨",
                    image = R.drawable.chicken
                ),
                MenuCategoryData(
                    name = "족발",
                    image = R.drawable.jokbal
                ),
                MenuCategoryData(
                    name = "피자",
                    image = R.drawable.pizza
                ),
                MenuCategoryData(
                    name = "구이",
                    image = R.drawable.roast
                ),
                MenuCategoryData(
                    name = "찜/탕",
                    image = R.drawable.soup
                ),
                MenuCategoryData(
                    name = "돈까스",
                    image = R.drawable.pork
                )
            )
        )
    }

    private fun initFavoriteActivity() {
        val intent = Intent(requireActivity(), FavoriteActivity::class.java)
        startActivity(intent)
    }

    private fun initDummy() {
        dummyItems.addAll(
            arrayListOf(
                MenuData(
                    title = "아워떡볶이", time = "30분", rate = "4.9", number = "(3,850)",
                    imageUrl = "https://media.istockphoto.com/id/1152570620/ko/%EC%82%AC%EC%A7%84/%EB%A7%A4%EC%9A%B4-%EB%96%A1.jpg?s=1024x1024&w=is&k=20&c=prL7yZ5TriVWZAuL5fg8I0Nyaw4stPNi6zgaA3zUBCg="
                ),
                MenuData(
                    title = "신통치킨", time = "20분", rate = "4.8", number = "(3,899)",
                    imageUrl = "https://media.istockphoto.com/id/1826839810/ko/%EC%82%AC%EC%A7%84/%ED%94%84%EB%9D%BC%EC%9D%B4%EB%93%9C-%EC%B9%98%ED%82%A8-%EA%B8%B8%EA%B1%B0%EB%A6%AC-%EC%9D%8C%EC%8B%9D.jpg?s=1024x1024&w=is&k=20&c=LM8eiXpHraE19WyvHwFqceC2gjgP-JSInEFb6r79NaI="
                ),
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
                ),
                MenuData(
                    title = "유리김치찜", time = "25분", rate = "4.3", number = "(3,129)",
                    imageUrl ="https://cdn.pixabay.com/photo/2022/12/29/01/01/food-7683985_640.jpg"
                ),
                MenuData(
                    title = "짱구디저트", time = "45분", rate = "4.4", number = "(3,123)",
                    imageUrl = "https://cdn.pixabay.com/photo/2016/10/31/18/14/dessert-1786311_1280.jpg"
                ),
                MenuData(
                    title = "훈이족발", time = "55분", rate = "4.5", number = "(3,444)",
                    imageUrl = "https://cdn.pixabay.com/photo/2019/04/22/18/53/pork-4147339_640.jpg"
                ),
                MenuData(
                    title = "미선잡채", time = "60분", rate = "3.9", number = "(3,987)",
                    imageUrl = "https://cdn.pixabay.com/photo/2020/10/19/01/32/chop-suey-5666461_1280.jpg"
                ),
                MenuData(
                    title = "형만삼겹살", time = "70분", rate = "2.2", number = "(3,845)",
                    imageUrl = "https://cdn.pixabay.com/photo/2014/01/24/04/36/roasted-250875_1280.jpg"
                )
            )

        )
    }

    private fun initFoodAdapter() {
        foodAdapter = RVAdapterGrid(requireContext(),dummyItems2)

        with(binding.rvFood){
            adapter = foodAdapter
            layoutManager = GridLayoutManager(requireContext(),5)
        }
    }
    private fun initRVAdapter() {

       rvAdapter = RVAdapter(requireContext(), dummyItems)

        with(binding.rvHome2){
            adapter = rvAdapter
            layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL,false)
        }
    }

    // MyEatsFragment로 전환하는 함수
    private fun initmyeatFragment() {
        // MyEatsFragment로 전환하는 트랜잭션
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.main_frm, MyEatsFragment()) // ID에 프래그먼트 교체
            .commit()
    }



}


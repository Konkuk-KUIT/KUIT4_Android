package com.example.kuit4androidprivate.home

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.adapter.RVAdapterCategory
import com.example.kuit4androidprivate.adapter.RVAdapterRecent
import com.example.kuit4androidprivate.adapter.VPAdapterHome
import com.example.kuit4androidprivate.databinding.FragmentHomeBinding
import com.example.kuit4androidprivate.detail.DetailActivity
import com.example.kuit4androidprivate.favorite.FavoriteActivity
import com.example.kuit4androidprivate.model.MenuCategoryData
import com.example.kuit4androidprivate.model.MenuData


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var rvAdapterCategory: RVAdapterCategory
    private val categoryItem = arrayListOf<MenuCategoryData>()
    private lateinit var rvAdapterRecent: RVAdapterRecent
    private val recentItem = arrayListOf<MenuData>()
    private lateinit var vpAdapterHome: VPAdapterHome
    private var vpItems = arrayListOf<MenuData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    private fun initVPAdapterHome() {
        binding.vpHome.adapter = VPAdapterHome(vpItems.size).apply{
            submitList(vpItems)
        }
    }

    private fun initVPData() {
        vpItems = arrayListOf(

            MenuData(
                restaurantName = "모터시티",
                eta = "30분",
                imgUrl = "https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20240306_55%2F1709683905690CRcjK_JPEG%2FIMG_3105.jpeg",
                rating = "4.9",
                totalReviews = "(3149)"
            ),
            MenuData(
                restaurantName = "지노스 피자",
                eta = "31분",
                imgUrl = "https://ldb-phinf.pstatic.net/20240421_108/1713677860549T8AzD_JPEG/KakaoTalk_20240418_210511163_03.jpg",
                rating = "4.9",
                totalReviews = "(3249)"
            ),
            MenuData(
                restaurantName = "우래옥",
                eta = "32분",
                imgUrl = "https://search.pstatic.net/common/?src=https%3A%2F%2Fpup-review-phinf.pstatic.net%2FMjAyNDA5MjlfMTU3%2FMDAxNzI3NTg5MTI1Mjkz.rn45W-mYbs-LflYbvnFQHCV2uZmyo1j7RmmbFXVMUYIg.tBOf99kd04i8Cdtr7Z9-6Cyer73lANZy_IdDKM1HxcMg.JPEG%2F11D3207C-F9F0-4C0D-A6B8-48F855E8C8AE.jpeg%3Ftype%3Dw1500_60_sharpen",
                rating = "4.9",
                totalReviews = "(3349)"
            ),
            MenuData(
                restaurantName = "파이브가이즈",
                eta = "33분",
                imgUrl = "https://ldb-phinf.pstatic.net/20240911_26/1726021704778F3qK5_PNG/%B8%DE%B4%BA_%C7%DC%B9%F6%B0%C5.png",
                rating = "4.9",
                totalReviews = "(3449)"
            ),
            MenuData(
                restaurantName = "고든램지버거",
                eta = "34분",
                imgUrl = "https://ldb-phinf.pstatic.net/20230726_13/16903611564251FjFA_JPEG/1-2%C7%EF%BD%BA%C5%B0%C4%A3_%282%29.jpg",
                rating = "4.9",
                totalReviews = "(3549)"
            ),
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //KeepActivity로 전환하기 위한 함수
//        binding.clRecentlyViewedRestaurantContainer.setOnClickListener {
//            val intent = Intent(activity, DetailActivity::class.java)
//            startActivity(intent)
//        }

        binding.sivPromotionOrderButton.setOnClickListener {
            val intent = Intent(activity, FavoriteActivity::class.java)
            startActivity(intent)
        }

        initCategory()
        initRVAdapterCategory()
        initRecent()
        initRVAdapterRecent()
        initVPData()
        initVPAdapterHome()
    }

    private fun initCategory() {
        categoryItem.addAll(
            arrayListOf(
                MenuCategoryData(
                    getString(R.string.pork_cutlet),
                    R.drawable.img_pork_cutlet
                ),
                MenuCategoryData(
                    getString(R.string.japanese_food),
                    R.drawable.img_japanese_food
                ),
                MenuCategoryData(
                    getString(R.string.korean_food),
                    R.drawable.img_korean_food
                ),
                MenuCategoryData(
                    getString(R.string.chicken),
                    R.drawable.img_chicken
                ),
                MenuCategoryData(
                    getString(R.string.snack_food),
                    R.drawable.img_snack_food
                ),
                MenuCategoryData(
                    getString(R.string.bossam),
                    R.drawable.img_bossam
                ),
                MenuCategoryData(
                    getString(R.string.soup),
                    R.drawable.img_soup
                ),
                MenuCategoryData(
                    getString(R.string.barbeque),
                    R.drawable.img_barbeque
                ),
                MenuCategoryData(
                    getString(R.string.pizza),
                    R.drawable.img_pizza
                ),
            )
        )
    }

    private fun initRVAdapterCategory() {
        rvAdapterCategory = RVAdapterCategory(
            requireContext(),
            items = categoryItem,
            categoryClickListener = {
                Toast.makeText(requireContext(), it.categoryName, Toast.LENGTH_LONG).show()
            },
            showMoreClickListener = {
                Toast.makeText(requireContext(), "더보기", Toast.LENGTH_LONG).show()
            })

        val itemDecoration = object: RecyclerView.ItemDecoration(){
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                // 좌우 및 상하 간격 설정
                outRect.bottom = 7
            }
        }

        with(binding.rvHomeCategory) {
            adapter = rvAdapterCategory
            layoutManager = GridLayoutManager(requireContext(), 5)
            addItemDecoration(itemDecoration)
        }

    }

    private fun initRecent() {
        recentItem.addAll(
            arrayListOf(
                MenuData(
                    restaurantName = "모터시티",
                    eta = "30분",
                    imgUrl = "https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20240306_55%2F1709683905690CRcjK_JPEG%2FIMG_3105.jpeg",
                    rating = "4.9",
                    totalReviews = "(3149)"
                ),
                MenuData(
                    restaurantName = "지노스 피자",
                    eta = "31분",
                    imgUrl = "https://ldb-phinf.pstatic.net/20240421_108/1713677860549T8AzD_JPEG/KakaoTalk_20240418_210511163_03.jpg",
                    rating = "4.9",
                    totalReviews = "(3249)"
                ),
                MenuData(
                    restaurantName = "우래옥",
                    eta = "32분",
                    imgUrl = "https://search.pstatic.net/common/?src=https%3A%2F%2Fpup-review-phinf.pstatic.net%2FMjAyNDA5MjlfMTU3%2FMDAxNzI3NTg5MTI1Mjkz.rn45W-mYbs-LflYbvnFQHCV2uZmyo1j7RmmbFXVMUYIg.tBOf99kd04i8Cdtr7Z9-6Cyer73lANZy_IdDKM1HxcMg.JPEG%2F11D3207C-F9F0-4C0D-A6B8-48F855E8C8AE.jpeg%3Ftype%3Dw1500_60_sharpen",
                    rating = "4.9",
                    totalReviews = "(3349)"
                ),
                MenuData(
                    restaurantName = "파이브가이즈",
                    eta = "33분",
                    imgUrl = "https://ldb-phinf.pstatic.net/20240911_26/1726021704778F3qK5_PNG/%B8%DE%B4%BA_%C7%DC%B9%F6%B0%C5.png",
                    rating = "4.9",
                    totalReviews = "(3449)"
                ),
                MenuData(
                    restaurantName = "고든램지버거",
                    eta = "34분",
                    imgUrl = "https://ldb-phinf.pstatic.net/20230726_13/16903611564251FjFA_JPEG/1-2%C7%EF%BD%BA%C5%B0%C4%A3_%282%29.jpg",
                    rating = "4.9",
                    totalReviews = "(3549)"
                ),
                MenuData(
                    restaurantName = "낙원타코",
                    eta = "35분",
                    imgUrl = "https://ldb-phinf.pstatic.net/20220928_273/166435807855170eC8_PNG/42.%B9%CC%C6%AE%C4%DE%BA%B8%C6%C4%C8%F7%C5%B8_.png",
                    rating = "4.9",
                    totalReviews = "(3649)"
                ),
                MenuData(
                    restaurantName = "부산안면옥",
                    eta = "36분",
                    imgUrl = "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyNDA4MDZfMTYg%2FMDAxNzIyOTUxMzA0NzI3.XUiTiP-njBpiBCz_hCRllY2wWwmURckNRaRwqE_brTUg.YxLCT9DUrLnKonEJTp-3ReUR4y9LYUfFWCJMc-l_qsgg.JPEG%2FKakaoTalk_20240805_224239008_08.jpg",
                    rating = "4.9",
                    totalReviews = "(3749)"
                ),
                MenuData(
                    restaurantName = "소원반점",
                    eta = "37분",
                    imgUrl = "https://ldb-phinf.pstatic.net/20230323_178/1679549207633VXs4F_JPEG/2CB0EDF0-91AA-4AC6-B656-F2C1D19347C0.jpeg",
                    rating = "4.9",
                    totalReviews = "(3849)"
                ),
                MenuData(
                    restaurantName = "소금집",
                    eta = "38분",
                    imgUrl = "https://ldb-phinf.pstatic.net/20240417_120/1713343933033v1Hvq_JPEG/%B7%E7%BA%A5_%B4%DC%B5%B6.jpg",
                    rating = "4.9",
                    totalReviews = "(3949)"
                ),
                MenuData(
                    restaurantName = "bhc",
                    eta = "39분",
                    imgUrl = "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDA0MDNfMjA0%2FMDAxNTg1OTExNjM2MjIy.-TUFGBHW_mMmjYGL0X4VHHeuY8nj6Gll9n-fQlLwrzYg.jHPnNRWnB6Dwpvc7bY3mwFhtpWujdk51gpHX4JlRk_gg.JPEG.tldbs2814%2FIMG_0323.JPG&type=sc960_832",
                    rating = "4.9",
                    totalReviews = "(3119)"
                ),
            )
        )
    }

    private fun initRVAdapterRecent() {
        rvAdapterRecent = RVAdapterRecent(requireContext(), recentItem) { it ->
            val intent = Intent(requireContext(), DetailActivity::class.java)
            //menuData를 intent에 넘김
            intent.putExtra("menuData", it)
            startActivity(intent)
        }

        with(binding.rvHomeRecent) {
            adapter = rvAdapterRecent
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }
}
package com.example.kuit4androidprivate.favorite

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.adapter.RVAdapterCategory
import com.example.kuit4androidprivate.adapter.RVAdapterFavorite
import com.example.kuit4androidprivate.databinding.ActivityFavoriteBinding
import com.example.kuit4androidprivate.databinding.ActivityKeepBinding
import com.example.kuit4androidprivate.detail.DetailActivity
import com.example.kuit4androidprivate.model.MenuCategoryData
import com.example.kuit4androidprivate.model.MenuData

class FavoriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavoriteBinding
    private lateinit var rvAdapterFavorite: RVAdapterFavorite
    private val favoriteItem = arrayListOf<MenuData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivActivityFavoriteBack.setOnClickListener{
            finish()
        }

        initFavorite()
        initRVAdapterFavorite()
    }

    private fun initRVAdapterFavorite() {
        rvAdapterFavorite= RVAdapterFavorite(this, favoriteItem) { it ->
            val intent = Intent(this, DetailActivity::class.java)
            //menuData를 intent에 넘김
            intent.putExtra("menuData",it)
            startActivity(intent)
        }

        with(binding.rvFavoriteRestaurants) {
            adapter = rvAdapterFavorite
            layoutManager =
                LinearLayoutManager(this@FavoriteActivity, LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun initFavorite(){
        favoriteItem.addAll(
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
                    restaurantName = getString(R.string.our_snacks),
                    eta = "39분",
                    imgId = R.drawable.img_favorite_our_snack,
                    rating = "4.9",
                    totalReviews = "(3119)"
                ),
            )
        )
    }
}
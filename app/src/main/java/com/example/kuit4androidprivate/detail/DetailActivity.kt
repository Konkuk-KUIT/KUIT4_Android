package com.example.kuit4androidprivate.detail

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.databinding.ActivityDetailBinding
import com.example.kuit4androidprivate.model.MenuData
import com.example.kuit4androidprivate.myeats.MyEatsDefaultFragment

class DetailActivity: AppCompatActivity() {

    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        //setTheme으로 Activity의 theme 지정, 소속된 fragment, item들에도 적용됨
        //xml 파일에서 android:textColor="?attr/colorPrimary"와 같이 사용 가능
        setTheme(R.style.Base_Theme_Kuit4AndroidPrivate2)
        super.onCreate(savedInstanceState)

        //상태 바 색상 변경 테스트
//        window.statusBarColor = ContextCompat.getColor(this, R.color.light_blue)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val menuData: MenuData
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            menuData = intent.extras?.getParcelable("menuData",MenuData::class.java)!!
        }else{
            menuData = intent.extras?.getParcelable("menuData")!!
        }

        if (menuData.imgId != null){
            binding.ivDetailRestaurant.setImageResource(menuData.imgId)
        }else if (menuData.imgUrl != null){
            Glide.with(this)
                .load(menuData.imgUrl)
                .into(binding.ivDetailRestaurant)
        }

        binding.tvDetailRestaurantName.text = menuData.restaurantName
        binding.tvDetailRating.text = menuData.rating
        binding.tvDetailTotalReview.text = menuData.totalReviews


        binding.ivDetailBack.setOnClickListener {
            finish()
        }

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.detail_frm, DetailContainerFragment())
            .addToBackStack(null)
            .commit()
    }

}
package com.example.kuit4androidprivate

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kuit4androidprivate.adapter.LinearFavoriteRVAdapter
import com.example.kuit4androidprivate.adapter.LinearHomeRVAdapter
import com.example.kuit4androidprivate.databinding.ActivityFavoriteBinding
import com.example.kuit4androidprivate.model.MenuData

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding
    private lateinit var linearHomeRVAdapter: LinearFavoriteRVAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        val items = intent.getSerializableExtra("item_data") as? ArrayList<MenuData>
        items?.let {
            initLinearHomeRVAdapter(it)
        }

        setContentView(binding.root)
        initBackIconImgListener()
    }

    private fun initLinearHomeRVAdapter(items: ArrayList<MenuData>) {
        linearHomeRVAdapter = LinearFavoriteRVAdapter(this, items) {}
        binding.rvFavorite.adapter = linearHomeRVAdapter
        binding.rvFavorite.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }


    private fun initBackIconImgListener() {
        binding.imgBack.setOnClickListener {
            finish()
        }
    }
}
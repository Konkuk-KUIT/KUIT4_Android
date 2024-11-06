package com.example.kuit4androidprivate

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kuit4androidprivate.adapter.LinearFavoriteRVAdapter
import com.example.kuit4androidprivate.databinding.ActivityFavoriteBinding
import com.example.kuit4androidprivate.model.MenuData

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding
    private lateinit var linearHomeRVAdapter: LinearFavoriteRVAdapter

    private val bottomMargin = 33

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        val items = intent.getSerializableExtra("item_data") as? ArrayList<MenuData>
        items?.let {
            initLinearHomeRVAdapter(it)
        }

        setContentView(binding.root)
        initBackIconImgListener()
        initLastMarginDecoration()
    }

    private fun initLastMarginDecoration() {
        binding.rvFavorite.addItemDecoration(LastItemMarginDecoration(bottomMargin))
    }

    private fun initLinearHomeRVAdapter(items: ArrayList<MenuData>) {
        linearHomeRVAdapter = LinearFavoriteRVAdapter(this, items) {}
        binding.rvFavorite.adapter = linearHomeRVAdapter
        binding.rvFavorite.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }


    private fun initBackIconImgListener() {
        binding.ivFavoriteBack.setOnClickListener {
            finish()
        }
    }
    inner class LastItemMarginDecoration(private val bottomMargin: Int) :
        RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            val position = parent.getChildAdapterPosition(view)
            val itemCount = state.itemCount

            if (position == itemCount - 1) {
                outRect.bottom = bottomMargin
            }
        }
    }
}

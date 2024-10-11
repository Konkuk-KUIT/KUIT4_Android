package com.example.kuit4androidprivate

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.example.kuit4androidprivate.databinding.ActivityMainBinding
import com.example.kuit4androidprivate.history.HistoryFragment
import com.example.kuit4androidprivate.home.HomeFragment
import com.example.kuit4androidprivate.keep.KeepActivity
import com.example.kuit4androidprivate.myEats.MyEatsFragment
import com.example.kuit4androidprivate.search.SearchFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navItem: NavigationItem
    private var backPressedTime: Long = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initOnBackPressedDispatcher()
        initBottomNavigation()

    }

    private fun initOnBackPressedDispatcher() {
        val onBackPressedCallback = object : OnBackPressedCallback(true) {

            override fun handleOnBackPressed() {
                when (binding.mainBottomNav.selectedItemId) {
                    R.id.home -> {
                        if (System.currentTimeMillis() - backPressedTime <= 2000) finishAffinity()
                        else backPressedTime = System.currentTimeMillis()
                    }

                    else ->
                        binding.mainBottomNav.selectedItemId = R.id.home
                }
            }
        }

        onBackPressedDispatcher.addCallback(onBackPressedCallback)
    }

    private fun initBottomNavigation() {
        binding.mainBottomNav.selectedItemId = R.id.home
        navItem = NavigationItem.HOME

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_frm, HomeFragment())
            .commitAllowingStateLoss()

        binding.mainBottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    navItem = NavigationItem.HOME

                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.main_frm, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.search -> {
                    navItem = NavigationItem.SEARCH

                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.main_frm, SearchFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.keep -> {
                    binding.mainBottomNav.selectedItemId = navItem.setSelectedItemId()

                    val intent = Intent(this, KeepActivity::class.java)
                    startActivity(intent)
                }

                R.id.history -> {
                    navItem = NavigationItem.HISTORY

                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.main_frm, HistoryFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.myeats -> {
                    navItem = NavigationItem.MYEATS

                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.main_frm, MyEatsFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }

    enum class NavigationItem {
        HOME, SEARCH, KEEP, HISTORY, MYEATS;

        fun setSelectedItemId(): Int {
            return when (this) {
                HOME -> R.id.home
                SEARCH -> R.id.search
                KEEP -> R.id.keep
                HISTORY -> R.id.history
                MYEATS -> R.id.myeats
            }
        }
    }
}
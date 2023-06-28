package com.elhacene.pixwall.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.elhacene.pixwall.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var toolbar : Toolbar
    lateinit var mViewPager : ViewPager2
    lateinit var mTabLayout : TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup Toobar and tabs
        toolbar = findViewById<Toolbar>(R.id.toolbar)
        mViewPager = findViewById<ViewPager2>(R.id.tab_viewpager)
        mTabLayout = findViewById<TabLayout>(R.id.tab_tablayout)

        setSupportActionBar(toolbar)
        var mPagerAdapter = PagerAdapter(
            supportFragmentManager,
            lifecycle
        )
        mPagerAdapter.addFragment(NewFragment(), "Test")
        mPagerAdapter.addFragment(BlankFragment(), "Test")
        mPagerAdapter.addFragment(BlankFragment(), "Test")
        mViewPager.adapter = mPagerAdapter;
        mViewPager.offscreenPageLimit = 3;
         TabLayoutMediator(mTabLayout, mViewPager) { tab, position ->
            when (position) {
                0 -> { tab.text = "NEW"}
                1 -> { tab.text = "Featured"}
                2 -> { tab.text = "COLLECTIONS"}
            }
        }.attach()
    }
}
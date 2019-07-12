package com.extmkv.circularviewpager.example

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class CircularPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount() = Integer.MAX_VALUE

    /**
     * Create the fragment based on the position
     */
    override fun createFragment(position: Int) = HomePagerScreens.values()[position % HomePagerScreens.values().size].fragment.java.newInstance()

    /**
     * Returns the same id for the same Fragment.
     */
    override fun getItemId(position: Int): Long = (position % HomePagerScreens.values().size).toLong()

    fun getCenterPage(position: Int = 0) = Integer.MAX_VALUE / 2 + position
}
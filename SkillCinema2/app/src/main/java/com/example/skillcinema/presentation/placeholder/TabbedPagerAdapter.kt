package com.example.skillcinema.presentation.placeholder

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.FragmentViewHolder
import com.example.skillcinema.presentation.FilmFragment
import com.example.skillcinema.presentation.ListCategoryFragment
import com.example.skillcinema.presentation.placeholder.homeFragment.HomeFragment
import java.util.*

open class TabbedPagerAdapter(
    val fragment: Fragment,
    val onFrameChangeListener: OnFrameChangeListener



) : FragmentStateAdapter(fragment) {



    val fragments = arrayListOf(
        HomeFragment(),
        SearchFragment(),
        ProfileFragment(),
      ListCategoryFragment(),
        FilmFragment()
    )
    val pageIds= fragments.map { it.hashCode().toLong() }.toMutableList()


    override fun getItemCount(): Int = fragments.size

    fun changeFragment(position: Int) {
        onFrameChangeListener.onFragmentChange(position)
    }


    override fun getItemId(position: Int): Long {
        return pageIds[position]

    }

    override fun containsItem(itemId: Long): Boolean {
        return pageIds.contains(itemId)
    }


    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }







}


package com.example.skillcinema.presentation.placeholder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getDrawable
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OffscreenPageLimit
import com.example.skillcinema.R
import com.example.skillcinema.data.*
import com.example.skillcinema.databinding.PlaceholderFragmentBinding
import com.example.skillcinema.presentation.BaseViewModel
import com.example.skillcinema.presentation.placeholder.homeFragment.HomeFragment
import com.google.android.material.tabs.TabLayout.Tab
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.launch
import java.util.*


class PlaceHolderFragment: Fragment(), OnFrameChangeListener {
    private var _binding: PlaceholderFragmentBinding? = null
    private val binding get() = _binding!!
    private val baseViewModel: BaseViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = PlaceholderFragmentBinding.inflate(inflater)
        baseViewModel.onFrameChangeListener = activity as? OnFrameChangeListener

        println("create PlaceHolder")

        goToPlaceHolder()
        return binding.root }

    fun requireViewPager2Adapter(): RecyclerView.Adapter<*>? {
        return binding.viewPagerPlaceholder.adapter
    }


    private fun goToPlaceHolder() {
        val  adapter = TabbedPagerAdapter(this, this)
        val viewPager = binding.viewPagerPlaceholder
        val tabLayout = binding.tabLayoutPlaceholder
        viewPager.isSaveEnabled = true
        viewPager.adapter = adapter
        viewPager.isUserInputEnabled = false
        viewPager.setPageTransformer { page, position ->
        }
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->

            when (position) {
                0 -> {

                    tab.icon = getDrawable(requireContext(), R.drawable.home_black)
                }
                1 -> {
                    tab.icon = getDrawable(requireContext(), R.drawable.search_black)
                }
                2 -> {
                    tab.icon = getDrawable(requireContext(), R.drawable.profil_black)
                }
                3 -> {
                    tab.view.visibility = View.GONE
                }
                4 -> {
                    tab.view.visibility = View.GONE
                }

            }
        }.attach()
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                currentPosition = position
                baseViewModel.currentPosition
                when (position) {
                    HOME_FRAGMENT_POSITION -> {
                        baseViewModel.stack.removeAllElements()
                        baseViewModel.stack.add(0)
                    }
                    SEARCH_FRAGMENT_POSITION -> {
                        baseViewModel.stack.removeAllElements()
                        baseViewModel.stack.add(0)
                    }
                    PROFILE_FRAGMENT_POSITION -> {
                        baseViewModel.stack.removeAllElements()
                        baseViewModel.stack.add(0)
                    }
                    LIST_FRAGMENT_POSITION -> {
                    }
                    FILM_FRAGMENT_POSITION -> {

                    }
                }
                println("Acum suntem la  $position , avewm stackul ${baseViewModel.stack}")
                println(" ;;;;;;;;;           ${baseViewModel.stack.lastElement()}")


                super.onPageSelected(position)
            }
        })


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }



    override var currentPosition: Int? = null

    override fun onFragmentChange(position: Int) {
        println("hier on frama placeholder")
        when (currentPosition) {
            HOME_FRAGMENT_POSITION -> {
                baseViewModel.stack.removeAllElements()
                baseViewModel.stack.add(binding.viewPagerPlaceholder.currentItem)
                binding.viewPagerPlaceholder.setCurrentItem(position, false)

            }
            SEARCH_FRAGMENT_POSITION -> {
                baseViewModel.stack.removeAllElements()

                baseViewModel.stack.add(binding.viewPagerPlaceholder.currentItem)
                binding.viewPagerPlaceholder.setCurrentItem(position, false)

            }
            PROFILE_FRAGMENT_POSITION -> {
                baseViewModel.stack.removeAllElements()

                baseViewModel.stack.add(binding.viewPagerPlaceholder.currentItem)
                binding.viewPagerPlaceholder.setCurrentItem(position, false)
            }
            LIST_FRAGMENT_POSITION -> {
                if (position == FILM_FRAGMENT_POSITION) {
                    baseViewModel.stack.add(binding.viewPagerPlaceholder.currentItem)
                    binding.viewPagerPlaceholder.setCurrentItem(position, true)
                }
                binding.viewPagerPlaceholder.setCurrentItem(position, false)

            }
            FILM_FRAGMENT_POSITION -> {
                if (position == LIST_FRAGMENT_POSITION){
                    binding.viewPagerPlaceholder.setCurrentItem(position, true)
                    baseViewModel.stack.removeLast()
                }
                binding.viewPagerPlaceholder.setCurrentItem(position, false)




            }
        }
    }


}

interface OnFrameChangeListener {

    var currentPosition: Int?
    fun onFragmentChange(position: Int)

}

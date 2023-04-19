package com.example.skillcinema.presentation.placeholder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.activityViewModels
import com.example.skillcinema.R
import com.example.skillcinema.data.HOME_FRAGMENT_POSITION
import com.example.skillcinema.databinding.FragmentHomeBinding
import com.example.skillcinema.databinding.FragmentSearchBinding
import com.example.skillcinema.presentation.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import java.util.*

class SearchFragment (
): Fragment(){
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    val baseViewModel : BaseViewModel by activityViewModels()
    private var viewPager2Adapter: TabbedPagerAdapter? = null




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater)
        println("---------------------------------------sa initializat searchFragment")

        val callback = object : OnBackPressedCallback(true /* enabled by default */) {
            override fun handleOnBackPressed() {
              viewPager2Adapter?.changeFragment(HOME_FRAGMENT_POSITION)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this.viewLifecycleOwner, callback)
        return binding.root



    }
    override fun onResume() {
        val parentFragment = parentFragment
        if (parentFragment is PlaceHolderFragment) {
            viewPager2Adapter = parentFragment.requireViewPager2Adapter() as TabbedPagerAdapter
        }
        super.onResume()
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
package com.example.skillcinema.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.skillcinema.data.FILM_FRAGMENT_POSITION
import com.example.skillcinema.databinding.FragmentFilmBinding
import com.example.skillcinema.presentation.placeholder.PlaceHolderFragment
import com.example.skillcinema.presentation.placeholder.TabbedPagerAdapter
import kotlinx.coroutines.launch

class FilmFragment() : Fragment() {

    private var _binding: FragmentFilmBinding? = null
    private val binding get() = _binding!!
    private val baseViewModel: BaseViewModel by activityViewModels()
    private var currentFilm = ""
    private var viewPager2Adapter: TabbedPagerAdapter? = null

    private val callback = object : OnBackPressedCallback(true /* enabled by default */) {
        override fun handleOnBackPressed() {
            println("_________  buton back stack ist : ${baseViewModel.stack} ")

            viewPager2Adapter?.changeFragment(baseViewModel.stack.lastElement())

        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFilmBinding.inflate(inflater)
        lifecycleScope.launch {
            baseViewModel.nameFilm.collect {
                currentFilm = it

            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(this.viewLifecycleOwner, callback)

        binding.ButtonBack.setOnClickListener {
            println("_________  buton back Up stack ist : ${baseViewModel.stack} ")

            viewPager2Adapter?.changeFragment(baseViewModel.stack.lastElement())
        }
        return binding.root
    }

    override fun onPause() {
        super.onPause()
        callback.isEnabled = false
    }
    override fun onResume() {
        val parentFragment = parentFragment
        if (parentFragment is PlaceHolderFragment) {
            viewPager2Adapter = parentFragment.requireViewPager2Adapter() as TabbedPagerAdapter
            callback.isEnabled = true

        }
        super.onResume()
    }

    fun onClickBack() {
        viewPager2Adapter?.changeFragment(FILM_FRAGMENT_POSITION)


    }


    override fun onDestroy() {
        super.onDestroy()
        callback.isEnabled = false
        _binding = null
    }


}
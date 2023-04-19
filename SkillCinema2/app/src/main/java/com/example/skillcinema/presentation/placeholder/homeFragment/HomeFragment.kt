package com.example.skillcinema.presentation.placeholder.homeFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.skillcinema.data.FILM_FRAGMENT_POSITION
import com.example.skillcinema.data.LIST_FRAGMENT_POSITION
import com.example.skillcinema.databinding.FragmentHomeBinding
import com.example.skillcinema.presentation.BaseViewModel
import com.example.skillcinema.presentation.placeholder.PlaceHolderFragment
import com.example.skillcinema.presentation.placeholder.TabbedPagerAdapter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


class HomeFragment() : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    val viewModel: HomeFragmentViewModel by activityViewModels()
    val baseViewModel: BaseViewModel by activityViewModels()
    var adapter: AdapterRecyclerViewHome? = null
    private var viewPager2Adapter: TabbedPagerAdapter? = null



    override fun onResume() {
        val parentFragment = parentFragment
        if (parentFragment is PlaceHolderFragment) {
            viewPager2Adapter = parentFragment.requireViewPager2Adapter() as TabbedPagerAdapter
        }
        super.onResume()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        _binding = FragmentHomeBinding.inflate(inflater)
        println("create HomeFragment")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (viewModel.filmsFlow.value.isEmpty()) {
            viewModel.loadFilms()
        }
        viewModel.isLoading.onEach {
            binding.swipeHomeFragment.isRefreshing = it
        }.launchIn(viewLifecycleOwner.lifecycleScope)
        binding.swipeHomeFragment.setOnRefreshListener {
            viewModel.loadFilms()


        }
        adapter = AdapterRecyclerViewHome(
            { string -> clickItem(string) },
            { item -> clickList(item) },
        )

        binding.containerFilmVertical.adapter = adapter
        binding.containerFilmVertical.layoutManager = LinearLayoutManager(context)
        viewModel.filmsFlow.onEach { list ->
            println("  new list_____________________")
            println(list.toString())

            adapter = AdapterRecyclerViewHome(
                { string -> clickItem(string) },
                { item -> clickList(item) },
            )

            binding.containerFilmVertical.adapter = adapter
            binding.containerFilmVertical.layoutManager = LinearLayoutManager(context)
            adapter!!.submitList(list)


        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun clickItem(
        string: String
    ): String {
        println("ÖÖÖÖ;;:;::;:::::::::___________:::::::::::::::;;;;;;;;;__________")
        viewPager2Adapter?.changeFragment(FILM_FRAGMENT_POSITION)
        baseViewModel.setNameFilm(string)
        return string
    }

    private fun clickList(
        listName: String

    ) {
        baseViewModel.setNameCategory(listName)
        viewPager2Adapter?.changeFragment(LIST_FRAGMENT_POSITION)


    }



    override fun onDestroy() {
        super.onDestroy()
        println("____________________ dead Home Fragment ${baseViewModel.state.value}")
        binding
    }

}

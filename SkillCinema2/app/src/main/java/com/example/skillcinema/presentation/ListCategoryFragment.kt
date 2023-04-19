package com.example.skillcinema.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.*
import com.example.skillcinema.data.FILM_FRAGMENT_POSITION
import com.example.skillcinema.data.films.ItemDto
import com.example.skillcinema.databinding.FragmentListCategoryBinding
import com.example.skillcinema.presentation.placeholder.PagingSourceFilms
import com.example.skillcinema.presentation.placeholder.PlaceHolderFragment
import com.example.skillcinema.presentation.placeholder.TabbedPagerAdapter
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


class ListCategoryFragment() : Fragment() {

    private var _binding: FragmentListCategoryBinding? = null
    private val binding get() = _binding!!
    val baseViewModel : BaseViewModel by activityViewModels()
    private var viewPager2Adapter: TabbedPagerAdapter? = null


    private val currentCategory = MutableStateFlow("")
    var adapter = AllFilmsTopRecyclerViewAdapter() { string -> onClickItem(string) }
   private val callback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            println("_________  buton back stack ist : ${baseViewModel.stack} ")

            viewPager2Adapter?.changeFragment(baseViewModel.stack.lastElement())
        }


   }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListCategoryBinding.inflate(inflater)
        lifecycleScope.launch {
            baseViewModel.nameCategory.collect { newCategory ->
                adapter = AllFilmsTopRecyclerViewAdapter() { string -> onClickItem(string) }
                currentCategory.value = newCategory
                binding.text3.text = newCategory
                binding.containerAllFilm.adapter = adapter
                adapter.submitData(PagingData.empty<ItemDto>())
                getPagedDataFlow(newCategory).onEach { pagingData ->
                    adapter.submitData(pagingData)
                }.launchIn(lifecycleScope)
            } }

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
    private fun getPagedDataFlow(name:String): Flow<PagingData<ItemDto>> {
        return Pager(
            config = PagingConfig(pageSize = 6),
            pagingSourceFactory = { PagingSourceFilms(name) }
        ).flow.cachedIn(lifecycleScope)
    }
   private fun onClickItem(string: String) {
        baseViewModel.setNameFilm(string)
       viewPager2Adapter?.changeFragment(FILM_FRAGMENT_POSITION)


    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        callback.isEnabled = false

    }


}
package com.example.skillcinema.presentation.firstpartpresentation

import android.app.Activity
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.skillcinema.App
import com.example.skillcinema.R
import com.example.skillcinema.data.Repository
import com.example.skillcinema.data.database.categoriesundcountry.CountryForDataBase
import com.example.skillcinema.data.database.categoriesundcountry.GenreForDataBase
import com.example.skillcinema.databinding.FragmentFirstBinding
import com.example.skillcinema.presentation.firstpartpresentation.recycleciewfirstpresentation.AdapterProbe
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class ViewModelFirstFragment:
    ViewModel() {
    suspend fun showLoad(binding: FragmentFirstBinding, fragment: FirstFragment ) {
        binding.viewPager.visibility = View.GONE
        binding.customLoadView.visibility = View.VISIBLE
        binding.tabLayout.visibility = View.GONE
        binding.idSkip.visibility = View.GONE
        fragment.findNavController().navigate(R.id.action_firstFragment_to_placeHolderFragment)
      delay(2000)

    }

   suspend fun showPresentation(binding: FragmentFirstBinding, fragment: FirstFragment) {
        val viewPager2 = binding.viewPager
        val adapter = AdapterProbe()
        viewPager2.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { _, _ -> }
            .attach()
        binding.idSkip.setOnClickListener {
            viewModelScope.launch{
                showLoad(binding, fragment)
            }
        }


    }



}
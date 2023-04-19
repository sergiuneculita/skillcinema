package com.example.skillcinema.presentation

import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.skillcinema.App
import com.example.skillcinema.databinding.ActivityMainBinding
import com.example.skillcinema.presentation.placeholder.homeFragment.HomeFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val baseViewModel: BaseViewModel by viewModels()
    val viewModelHomeFragment: HomeFragmentViewModel by viewModels()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        baseViewModel.saveCountryAndGenresDB(this)
        setContentView(binding.root)

    }

}
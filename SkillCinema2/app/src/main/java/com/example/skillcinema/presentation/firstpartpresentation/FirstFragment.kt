package com.example.skillcinema.presentation.firstpartpresentation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import androidx.navigation.fragment.findNavController
import com.example.skillcinema.R
import com.example.skillcinema.databinding.FragmentFirstBinding
import com.example.skillcinema.presentation.firstpartpresentation.recycleciewfirstpresentation.AdapterProbe
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ViewModelFirstFragment by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater)
        val sharedPreferences =
            requireActivity().getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE)
        val firstTime = sharedPreferences.getString("FirstTimeInstall", "")

        lifecycle.coroutineScope.launch {
            if (firstTime.equals("Yes")){
                viewModel.showLoad(binding, this@FirstFragment)
            } else {
                viewModel.showPresentation(binding, this@FirstFragment)
                val editor = sharedPreferences.edit()
                editor.putString("FirstTimeInstall", "Yes").apply()
            }

        }


        return binding.root
    }



override fun onDestroy() {
    super.onDestroy()
    _binding = null
}


}
package com.example.skillcinema.presentation.placeholder.homeFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skillcinema.data.LoadAndConvertFilms
import com.example.skillcinema.presentation.FilmsWithCategory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeFragmentViewModel : ViewModel() {


    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()
    private var _filmsFlow = MutableStateFlow<List<FilmsWithCategory?>>(emptyList())
    val filmsFlow = _filmsFlow.asStateFlow()
    private val loadFilms = LoadAndConvertFilms(_filmsFlow)





    fun loadFilms() {

            _isLoading.value = true

            viewModelScope.launch {
                loadFilms.loadTopFilms()

        }
        _isLoading.value = false


    }

    override fun onCleared() {
        println("dead home view :::::::::::::")
        super.onCleared()
    }



}
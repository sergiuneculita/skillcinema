package com.example.skillcinema.presentation

import android.app.Activity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skillcinema.App
import com.example.skillcinema.data.Repository
import com.example.skillcinema.data.database.categoriesundcountry.CountryForDataBase
import com.example.skillcinema.data.database.categoriesundcountry.GenreForDataBase
import com.example.skillcinema.presentation.firstpartpresentation.StateForPresentation
import com.example.skillcinema.presentation.placeholder.OnFrameChangeListener
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.*

class BaseViewModel() : ViewModel() {

  private  val _state = MutableStateFlow<BaseState>(BaseState.Presentation)
    var state: StateFlow<BaseState> = _state.asStateFlow()
   private val _nameCategory = MutableStateFlow<String>("")
    val nameCategory = _nameCategory.asStateFlow()
   private val _nameFilm = MutableStateFlow<String>("")
    val nameFilm = _nameFilm.asStateFlow()
    var currentPosition: Int = 0
    val repository = Repository()
    val stack: Stack<Int> = Stack()
    var onFrameChangeListener: OnFrameChangeListener? = null


    fun changeFragment(position: Int) {
        println(":......................... $onFrameChangeListener")

        onFrameChangeListener?.onFragmentChange(position)
    }

    fun setNameCategory(string: String){
        _nameCategory.value = string
    }
    fun setNameFilm(string: String){
        _nameFilm.value = string
    }

    fun saveCountryAndGenresDB(activity: Activity) {
        val app = (activity.application as App)
        val genreDao = app.genreDataBase.genreDao()
        val countryDao = app.countryDataBase.countryDao()
        viewModelScope.launch {
            if ((genreDao.getAll().size + countryDao.getAll().size) <= 250) {
                val response = repository.searchFilms.getCountryIdAndGenreId()
                val code = response.code()
                if (response.code() == 200) {
                    println(response.body()!!.genres)
                    val listResponseGenre = response.body()!!.genres
                    val listResponseCountry = response.body()!!.countries
                    listResponseGenre.forEach { genre ->
                        genreDao.insert(GenreForDataBase(genre.id, genre.genre))
                    }
                    listResponseCountry.forEach { country ->
                        countryDao.insert(CountryForDataBase(country.id, country.country))
                    }
                } else {
                    val error = StateForPresentation.ErrorText
                    error.message = code.toString()
                }
            }

        }
    }


}
package com.example.skillcinema.domain

import com.example.skillcinema.data.Repository
import com.example.skillcinema.data.films.ItemDto
import com.example.skillcinema.data.filmstop.FilmTopDto

class GetListFilms {
    var topList = listOf<FilmTopDto>()
    suspend fun execute(string: String) {
        val result = Repository().searchFilms.getTopList(string)
        if (result.isSuccessful) topList = result.body()!!.films
    }



}
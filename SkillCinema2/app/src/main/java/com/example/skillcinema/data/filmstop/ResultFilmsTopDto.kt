package com.example.skillcinema.data.filmstop

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass

data class ResultFilmsTopDto(
    val films: List<FilmTopDto>,
    val pagesCount: Int
)
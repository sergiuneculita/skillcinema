package com.example.skillcinema.data.filmstop

import com.example.skillcinema.data.films.CountryDto
import com.example.skillcinema.data.films.GenreDto
import com.example.skillcinema.data.films.ItemDto
import com.example.skillcinema.entity.Films
import com.example.skillcinema.entity.Item
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass

data class FilmTopDto(
     val countries: List<CountryDto>,
    val filmId: Int,
    val filmLength: String? = null,
     val genres: List<GenreDto>,
     val nameEn: String? = null,
     val nameRu: String? = null,
     val posterUrl: String,
     val posterUrlPreview: String,
    val rating: String,
    val ratingChange: Any? = null,
    val ratingVoteCount: Int,
     val year: String


)
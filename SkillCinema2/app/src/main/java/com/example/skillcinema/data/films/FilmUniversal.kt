package com.example.skillcinema.data.films

import com.google.gson.annotations.SerializedName

data class FilmUniversal (
     val genres: List<GenreDto>,
     val imdbId: String? = null,
     val kinopoiskId: Int? ,
     val nameEn: Any? = null,
     val nameOriginal: String? = null,
     val nameRu: String? = null,
     val posterUrl: String,
     val posterUrlPreview: String,
     val ratingImdb: Double? = null,
     val ratingKinopoisk: Double? = null,
     val type: String? = null,

)
package com.example.skillcinema.data.films

import com.example.skillcinema.entity.Item
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass

data class ItemDto(
    override val countries: List<CountryDto>,
  override  val genres: List<GenreDto>,
    override val imdbId: String? = null,
    override val kinopoiskId: Int? ,
    override val nameEn: String? = null,
    override val nameOriginal: String? = null,
    override val nameRu: String? = null,
    override val posterUrl: String,
    override val posterUrlPreview: String,
    override val ratingImdb: String? = null,
    override val ratingKinopoisk: String? = null,
    override val type: String? = null,
    override val year: Int,
     val premiereRu: String? = null



) : Item

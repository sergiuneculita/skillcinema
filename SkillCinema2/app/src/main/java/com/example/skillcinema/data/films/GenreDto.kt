package com.example.skillcinema.data.films

import com.example.skillcinema.entity.Genre
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass

data class GenreDto(
    override val genre: String
): Genre
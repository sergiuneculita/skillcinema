package com.example.skillcinema.data.idcountryandgenre

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass

data class GenreIdDto(
    val genre: String,
    val id: Int
)
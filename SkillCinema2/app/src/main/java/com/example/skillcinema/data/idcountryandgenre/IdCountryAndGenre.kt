package com.example.skillcinema.data.idcountryandgenre

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass

data class IdCountryAndGenre(
    val countries: List<CountryIdDto>,
    val genres: List<GenreIdDto>
    )

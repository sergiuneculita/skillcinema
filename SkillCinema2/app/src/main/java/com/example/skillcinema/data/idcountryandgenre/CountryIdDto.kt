package com.example.skillcinema.data.idcountryandgenre

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass

data class CountryIdDto(
    val country: String,
    val id: Int
)
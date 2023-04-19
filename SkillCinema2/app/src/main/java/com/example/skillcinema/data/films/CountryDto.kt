package com.example.skillcinema.data.films

import com.example.skillcinema.entity.Country
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass

data class CountryDto(
    override val country: String
):Country
package com.example.skillcinema.data.films

import com.example.skillcinema.entity.Films
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass

data class ResultFilmsDto(
    override val items: List<ItemDto>,
    override val total: Int,
    override val totalPages: Int? = null,

) : Films
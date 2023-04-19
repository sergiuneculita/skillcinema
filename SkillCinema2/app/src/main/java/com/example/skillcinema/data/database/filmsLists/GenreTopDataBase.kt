package com.example.skillcinema.data.database.filmsLists

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.skillcinema.entity.Genre
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass
data class GenreTopDataBase(
    override val genre: String
): Genre
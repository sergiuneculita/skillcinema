package com.example.skillcinema.data.database.filmsLists

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.skillcinema.data.films.CountryDto
import com.example.skillcinema.data.films.GenreDto
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass
@Entity(tableName = "FilmTop")
data class FilmTopDataBase(
    @ColumnInfo
    val countries: List<CountryDto>,
    @PrimaryKey
    @ColumnInfo
    val filmId: Int,
    @ColumnInfo
    val filmLength: String,
    @ColumnInfo
    val genres: List<GenreDto>,
    @ColumnInfo
    val nameEn: String? = null,
    @ColumnInfo
    val nameRu: String? = null,
    @ColumnInfo
    val posterUrl: String,
    @ColumnInfo
    val posterUrlPreview: String,
    @ColumnInfo
    val rating: String,
    @ColumnInfo
    val ratingChange: Any? = null,
    @ColumnInfo
    val ratingVoteCount: Int,
    @ColumnInfo
    val year: String
    )
package com.example.skillcinema.presentation

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.skillcinema.data.films.ItemDto

class FilmsWithCategory(
    val listFilms : List<ItemDto>,
    val nameCategory : String
    ) {
}
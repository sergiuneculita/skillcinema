package com.example.skillcinema.data.database.filmsLists

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.skillcinema.data.filmstop.FilmTopDto
@Entity(tableName = "FilmTop")
data class TopFilmsForDataBase(
    @PrimaryKey
    @ColumnInfo
    val id : String,
    @ColumnInfo
    val films : List<FilmTopDataBase>,
    ){

}
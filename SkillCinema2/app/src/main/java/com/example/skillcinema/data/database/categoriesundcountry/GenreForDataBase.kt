package com.example.skillcinema.data.database.categoriesundcountry

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "genreForFilter")
data class GenreForDataBase(
    @PrimaryKey
    @ColumnInfo
    val id : Int,
    @ColumnInfo
    val genre :String

)

package com.example.skillcinema.data.database.films

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.skillcinema.data.films.ItemDto

@Entity(tableName = "filmWithCategory")
data class FilmWithCategoryForDB(
    @ColumnInfo(name = "listFilms")
val listFilms: List<ItemDto>,
@PrimaryKey
@ColumnInfo(name = "nameCategory")
val nameCategory: String

) {
}


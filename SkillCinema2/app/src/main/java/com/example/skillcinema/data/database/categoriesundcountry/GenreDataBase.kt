package com.example.skillcinema.data.database.categoriesundcountry

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [GenreForDataBase::class ], version = 1)
abstract class GenreDataBase  : RoomDatabase() {
    abstract fun genreDao(): GenreDao
}
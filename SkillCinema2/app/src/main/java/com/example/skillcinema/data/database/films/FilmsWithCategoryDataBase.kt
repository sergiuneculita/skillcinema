package com.example.skillcinema.data.database.films

import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.skillcinema.data.database.categoriesundcountry.CountryDao
import com.example.skillcinema.data.database.categoriesundcountry.CountryForDataBase
import com.example.skillcinema.presentation.FilmsWithCategory
@TypeConverters(ConverterFilmsInJson::class)
@Database(entities = [FilmWithCategoryForDB::class], version = 1)
abstract class FilmsWithCategoryDataBase :RoomDatabase(){
    abstract fun filmsWithCategoryDao(): FilmWithCategoryDao

}
package com.example.skillcinema.data.database.films

import androidx.room.*
import com.example.skillcinema.data.database.categoriesundcountry.GenreForDataBase
import com.example.skillcinema.presentation.FilmsWithCategory

@Dao
interface FilmWithCategoryDao {
    @Query(value = "SELECT * FROM filmWithCategory ")
    fun getAll(): List<FilmWithCategoryForDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(film: FilmWithCategoryForDB)

    @Delete
    fun delete(film: FilmWithCategoryForDB)

    @Update
    fun update(film: FilmWithCategoryForDB)

}
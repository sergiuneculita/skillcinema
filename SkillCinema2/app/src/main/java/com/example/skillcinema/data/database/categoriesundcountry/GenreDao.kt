package com.example.skillcinema.data.database.categoriesundcountry

import androidx.room.*

@Dao
interface GenreDao {
    @Query(value = "SELECT * FROM genreForFilter ")
    fun getAll(): List<GenreForDataBase>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(genre: GenreForDataBase)

    @Delete
    fun delete(genre: GenreForDataBase)

    @Update
    fun update(genre: GenreForDataBase)



}
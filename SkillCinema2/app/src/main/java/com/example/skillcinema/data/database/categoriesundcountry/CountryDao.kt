package com.example.skillcinema.data.database.categoriesundcountry

import androidx.room.*

@Dao
interface CountryDao{
    @Query(value = "SELECT * FROM countryForFilter ")
    fun getAll(): List<CountryForDataBase>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(country: CountryForDataBase)

    @Delete
    fun delete(country: CountryForDataBase)

    @Update
    fun update(country: CountryForDataBase)
}
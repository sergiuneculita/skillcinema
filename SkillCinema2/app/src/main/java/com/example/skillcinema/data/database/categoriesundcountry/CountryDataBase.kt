package com.example.skillcinema.data.database.categoriesundcountry

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CountryForDataBase::class], version = 1)
abstract class CountryDataBase : RoomDatabase() {
    abstract fun countryDao(): CountryDao
}
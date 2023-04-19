package com.example.skillcinema.data.database.categoriesundcountry

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "countryForFilter")
data class CountryForDataBase(
    @PrimaryKey
    @ColumnInfo
    val id : Int,
    @ColumnInfo
    val country: String
)

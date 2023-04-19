package com.example.skillcinema.data.database.filmsLists

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.skillcinema.entity.Country

data class CountryTopDataBase(
    override val country: String
) : Country
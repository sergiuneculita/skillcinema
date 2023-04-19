package com.example.skillcinema

import android.app.Application
import androidx.room.Room
import com.example.skillcinema.data.database.categoriesundcountry.CountryDataBase
import com.example.skillcinema.data.database.categoriesundcountry.GenreDataBase
import com.example.skillcinema.data.database.films.FilmsWithCategoryDataBase
import com.example.skillcinema.presentation.FilmsWithCategory
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject
class App : Application() {
    lateinit var genreDataBase: GenreDataBase
    lateinit var countryDataBase: CountryDataBase
    lateinit var filmsWithCategoryDataBase: FilmsWithCategoryDataBase

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        genreDataBase = Room.databaseBuilder(
            applicationContext,
            GenreDataBase::class.java,
            "genreDataBase"
        )
            .allowMainThreadQueries()
            .build()

        countryDataBase = Room.databaseBuilder(
            applicationContext,
            CountryDataBase::class.java,
            "countryDataBase"
        )
            .allowMainThreadQueries()
            .build()

        filmsWithCategoryDataBase = Room.databaseBuilder(
            applicationContext,
            FilmsWithCategoryDataBase::class.java,
            "filmWithCategoryDataBase"
        )
            .allowMainThreadQueries()
            .build()
    }






    companion object {
        lateinit var INSTANCE: App
            private set
    }


}
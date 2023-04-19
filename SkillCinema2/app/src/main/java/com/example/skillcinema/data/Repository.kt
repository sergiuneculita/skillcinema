package com.example.skillcinema.data

import android.annotation.SuppressLint
import com.example.skillcinema.data.films.ResultFilmsDto
import com.example.skillcinema.data.filmstop.ResultFilmsTopDto
import com.example.skillcinema.data.idcountryandgenre.IdCountryAndGenre
import com.example.skillcinema.data.queryparam.CurrentDate
import com.squareup.moshi.Moshi
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import java.util.*
import javax.inject.Inject

class Repository @Inject constructor() {
    private val retrofit = Retrofit.Builder()
        .baseUrl(URL_KINOPOISK)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val searchFilms = retrofit.create(SearchFilms::class.java)

    interface SearchFilms {
        @Headers("X-API-KEY: $API_KEY_KINOPOISK")
        @GET("/api/v2.2/films?")
        suspend fun getFilmsWithFilterElement(
            @Query("order") order: String? = null,
            @Query("type") type: String? = null,
            @Query("ratingFrom") ratingFrom:String? = null,
            @Query("ratingTo") ratingTo:String? = null,
            @Query("yearFrom") yearFrom:String? = null,
            @Query("yearTo") yearTo:String? = null,
            @Query("countries") countries:String? = null,
            @Query("genres") genres:String? = null,
            @Query("page") page:String? = null
        ): Response<ResultFilmsDto>


        @Headers("X-API-KEY: $API_KEY_KINOPOISK")
        @GET("/api/v2.2/films/top/")
        suspend fun getTopListElemnt(
            @Query("type") type: String? = null,
            @Query("page") page:String? = null
        ):ResultFilmsTopDto



        @Headers("X-API-KEY: $API_KEY_KINOPOISK")
        @GET("/api/v2.2/films?")
        suspend fun getFilmsWithFilter(
            @Query("order") order: String? = null,
            @Query("type") type: String? = null,
            @Query("ratingFrom") ratingFrom:String? = null,
            @Query("ratingTo") ratingTo:String? = null,
            @Query("yearFrom") yearFrom:String? = null,
            @Query("yearTo") yearTo:String? = null,
            @Query("countries") countries:String? = null,
            @Query("genres") genres:String? = null,
            @Query("page") page:String? = null
        ): Response<ResultFilmsDto>


        @Headers("X-API-KEY: $API_KEY_KINOPOISK")
        @GET("/api/v2.2/films/top/")
        suspend fun getTopList(
            @Query("type") type: String? = null,
            @Query("page") page:String? = null
        ):Response<ResultFilmsTopDto>


        @Headers("X-API-KEY: $API_KEY_KINOPOISK")
        @GET("/api/v2.2/films/filters")
        suspend fun getCountryIdAndGenreId():Response<IdCountryAndGenre>

        @Headers("X-API-KEY: $API_KEY_KINOPOISK")
        @GET("/api/v2.2/films/premieres")
        suspend fun  getPremieres(
            @SuppressLint("SimpleDateFormat") @Query("year") year:String = CurrentDate.year,
            @SuppressLint("SimpleDateFormat") @Query("month") month:String =  "JANUARY",
            @Query("page") page:String? = null
        ): Response<ResultFilmsDto>


        @Headers("X-API-KEY: $API_KEY_KINOPOISK")
        @GET("/api/v2.2/films/premieres")
        suspend fun  getPremieresElement(
            @SuppressLint("SimpleDateFormat") @Query("year") year:String = CurrentDate.year,
            @SuppressLint("SimpleDateFormat") @Query("month") month:String =  "JANUARY",
            @Query("page") page:String? = null
        ): ResultFilmsDto









    }

}


    fun main()=runBlocking{
        val c = Repository().searchFilms.getPremieresElement("2023")
        println(c.items)


}


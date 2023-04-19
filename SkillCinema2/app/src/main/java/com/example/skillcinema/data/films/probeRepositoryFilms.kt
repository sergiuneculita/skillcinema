package com.example.skillcinema.data.films

import android.annotation.SuppressLint
import com.example.skillcinema.R
import com.example.skillcinema.data.Repository
import com.example.skillcinema.data.queryparam.TypeTopQuery
import kotlinx.coroutines.runBlocking
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun main() = runBlocking {
println((R.drawable.image_for_first_page_presentation))

   // val films = Repository().searchFilms.getFilmsWithFilter()
    //println(films.body())

   // val idCountryAndGenre = Repository().searchFilms.getCountryIdAndGenreId()
    //println(idCountryAndGenre.body()?.countries)

    // val top250 = Repository().searchFilms.getTopList()
   //println(top250.body())


  // val premieres = Repository().searchFilms.getPremieres()
  // println(premieres.body())
    println( " countries = \"44\",\n" +
            "                genres = \"4\"" )


}
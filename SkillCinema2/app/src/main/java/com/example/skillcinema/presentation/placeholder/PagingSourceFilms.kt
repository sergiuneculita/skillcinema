package com.example.skillcinema.presentation.placeholder

import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.skillcinema.data.Repository
import com.example.skillcinema.data.films.ItemDto
import com.example.skillcinema.data.filmstop.FilmTopDto
import com.example.skillcinema.data.queryparam.TypeQuery
import com.example.skillcinema.data.queryparam.TypeTopQuery
import com.example.skillcinema.domain.GetListFilms
import com.example.skillcinema.presentation.FilmsWithCategory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PagingSourceFilms(private val nameList: String) : PagingSource<Int, ItemDto>() {
    val repository =  Repository()


    override fun getRefreshKey(state: PagingState<Int, ItemDto>): Int = FIRST_PAGE
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ItemDto> {
        println("____________________-  se incarca ${nameList}")
        val page = params.key ?: 1
        return kotlin.runCatching {
            loadWithName(nameList,page)
        }.fold(
            onSuccess = {
                println("+++  succescccccc      ${it}")
                LoadResult.Page(
                    data = it,
                    prevKey = null,
                    nextKey = if (it.isEmpty()) null else page + 1

                )

            },
            onFailure = { LoadResult.Error(it)}
        )
    }

   suspend fun loadWithName(nameList: String, page : Int):List<ItemDto>{
   return  when(nameList){
            "Премьеры" -> { repository.searchFilms.getPremieresElement(year = "2023").items
            }
            "Топ-250" -> {  topFilmToNormalFilm( repository.searchFilms.getTopList(type = TypeTopQuery.typeTop250, page = page.toString()).body()!!.films)}
            "Топ-100 Популярные" -> {  topFilmToNormalFilm( repository.searchFilms.getTopList(type = TypeTopQuery.typeTop100, page = page.toString()).body()!!.films)}
            "Топ ожидаемые фильмы" -> {   topFilmToNormalFilm(repository.searchFilms.getTopList(type = TypeTopQuery.typeTopAwaitFilms, page = page.toString()).body()!!.films)}
       "Топ Франция" -> {
           repository.searchFilms.getFilmsWithFilterElement(
               countries = "5", page = page.toString()
           ).body()!!.items
       }
       "Сериалы" -> {
           repository.searchFilms.getFilmsWithFilterElement(
               type = TypeQuery.typeTvSeries, page = page.toString()
           ).body()!!.items

       }
       "Боевики США" -> {
           repository.searchFilms.getFilmsWithFilterElement(
               genres = "11", countries = "1" , page = page.toString()
           ).body()!!.items


       }
       "Сериалы комедия" -> {
           repository.searchFilms.getFilmsWithFilterElement(
               type = TypeQuery.typeTvSeries, genres = "13", page = page.toString()
           ).body()!!.items

       }
       "Германия фильмы" -> {
           repository.searchFilms.getFilmsWithFilterElement(
               type = TypeQuery.typeFilm, countries = "9", page = page.toString()
           ).body()!!.items
       }
       "Испанские мелодрамы" -> {
           repository.searchFilms.getFilmsWithFilterElement(
               countries = "8", genres = "4", page = page.toString()
           ).body()!!.items
       }
       "Tурецкие мелодрамы" -> {
           repository.searchFilms.getFilmsWithFilterElement(
               countries ="44",genres = "4", page = page.toString()
           ).body()!!.items
       }
       "Румыния фильмы" -> {
           repository.searchFilms.getFilmsWithFilterElement(
               countries = "37", page = page.toString()
           ).body()!!.items
       }
       else ->{  repository.searchFilms.getPremieresElement(year = "2023").items
       }

   }


    }
    fun topFilmToNormalFilm(list: List<FilmTopDto>): List<ItemDto> {
        val newList = mutableListOf<ItemDto>()
        list.forEach {
            newList.add(
                ItemDto(
                    countries = it.countries,
                    genres = it.genres,
                    kinopoiskId = it.filmId,
                    imdbId = it.filmId.toString(),
                    posterUrl = it.posterUrl,
                    nameEn = it.nameEn,
                    nameRu = it.nameRu,
                    nameOriginal = null,
                    year = it.year.toInt(),
                    ratingImdb = it.rating,
                    ratingKinopoisk = it.rating,
                    posterUrlPreview = it.posterUrlPreview,
                    premiereRu = it.rating,
                    type = null
                )
            )
        }
        return newList
    }
    private companion object {
        private val FIRST_PAGE = 1
    }
}


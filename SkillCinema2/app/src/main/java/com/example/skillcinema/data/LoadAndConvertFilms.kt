package com.example.skillcinema.data

import com.example.skillcinema.data.films.ItemDto
import com.example.skillcinema.data.filmstop.FilmTopDto
import com.example.skillcinema.data.queryparam.TypeQuery
import com.example.skillcinema.data.queryparam.TypeTopQuery
import com.example.skillcinema.presentation.FilmsWithCategory
import kotlinx.coroutines.flow.MutableStateFlow

class LoadAndConvertFilms(val listFilms: MutableStateFlow<List<FilmsWithCategory?>>) {
    val repository = Repository()
    val listFailure = mutableListOf<Boolean>()


    suspend fun getRestSixList() {

       /* val newListCategory = listCategoryUseful.shuffled()
        newListCategory.forEach {
            when (it) {
                "Премьеры" -> {
                    list.add(loadFilms(isPremier = true, nameCategory = it))
                }
                "Топ Франция " -> {
                    list.add(loadFilms(country = "3", nameCategory = it))

                }
                "Сериалы" -> {
                    list.add(loadFilms(type = TypeQuery.typeTvSeries, nameCategory = it)?
                }
                "Боевики США" -> {
                    list.add(loadFilms(genre = "11", country = "1", nameCategory = it))
                }
                "Сериалы комедия" -> {
                    list.add(
                        loadFilms(
                            type = TypeQuery.typeTvSeries,
                            genre = "13",
                            nameCategory = it
                        )
                    )
                }
                "Германия фильмы" -> {
                    list.add(
                        loadFilms(
                            type = TypeQuery.typeFilm,
                            country = "9",
                            nameCategory = it
                        )
                    )
                }
                "Испанские мелодрамы" -> {
                    list.add(loadFilms(country = "8", genre = "4", nameCategory = it))
                }
                "Tурецкие мелодрамы" -> {
                    list.add(
                        loadFilms(
                            country = "44",
                            genre = "4", nameCategory = it
                        )
                    )
                }
                "Румыния фильмы" -> {
                    list.add(loadFilms(country = "37", nameCategory = it))
                }

            }
        }*/
    }

    suspend fun loadFilms(
        type: String = "", country: String = "",
        genre: String = "",
        nameCategory: String,
        isPremier: Boolean = false
    ): FilmsWithCategory? {
        var ret: FilmsWithCategory? = null
        kotlin.runCatching {
            if (isPremier) {
                repository.searchFilms.getPremieres(year = "2023")
            } else {
                repository.searchFilms.getFilmsWithFilter(
                    type = type,
                    countries = country,
                    genres = genre
                )
            }
        }.fold(
            onSuccess = {
                listFailure.add(true)
                println(";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; ${it.code()}")
                if (it.code() == 200) {
                    println(it)

                    ret = FilmsWithCategory(it.body()!!.items.take(20), nameCategory)

                }
            },
            onFailure = {
                listFailure.add(false)
                println(":::::::  $nameCategory:::::::::: ${it.message}")
            }

        )
        return ret


    }

    suspend fun loadTopFilms(){
        val nameTopFilms = getRandomTopCategoryName()
        val nameCategoryTopFilms = getTopCategory(nameTopFilms)

        kotlin.runCatching {
            repository.searchFilms.getTopList(type = nameCategoryTopFilms)
        }.fold(
            onSuccess = {
                listFailure.add(true)

                if (it.code() == 200) {
                    val film = topFilmToNormalFilm(it.body()!!.films).take(20)
                    val list = listOf<FilmsWithCategory>(FilmsWithCategory(film, nameTopFilms))
                    listFilms.value = list

                }
            },
            onFailure = {
                listFailure.add(false)
                println("::::::::::::::::: ${it.message}")
            }

            )


    }

   private fun topFilmToNormalFilm(list: List<FilmTopDto>): List<ItemDto> {
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


   private fun getTopCategory(name: String): String {
        return when (name
        ) {
            "Топ-250" -> return TypeTopQuery.typeTop250
            "Топ-100 Популярные" -> return TypeTopQuery.typeTop100
            "Топ ожидаемые фильмы" -> return TypeTopQuery.typeTopAwaitFilms
            else -> {
                TypeTopQuery.typeTop250
            }
        }
    }
   private fun getRandomTopCategoryName(): String {
        val result = listOf("Топ-250", "Топ-100 Популярные", "Топ ожидаемые фильмы")
        return result.random()
    }
}
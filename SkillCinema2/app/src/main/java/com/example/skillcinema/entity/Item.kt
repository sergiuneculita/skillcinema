package com.example.skillcinema.entity

interface Item {
    val countries: List<Country>
    val genres: List<Genre>
    val imdbId: String?
    val kinopoiskId: Int?
    val nameEn: Any?
    val nameOriginal: String?
    val nameRu: String?
    val posterUrl: String
    val posterUrlPreview: String
    val ratingImdb: String?
    val ratingKinopoisk: String?
    val type: String?
    val year: Int
}
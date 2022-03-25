package com.example.moviesdb01.domain.model

data class Movies (

    val page: Int,
    val results: List<MoviesResult>?,
    val totalPages: Int?,
    val totalResults: Int?
)
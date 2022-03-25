package com.example.moviesdb01.data.api

import com.example.moviesdb01.data.models.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {
    @GET("popular")
    suspend fun getMovies(@Query("api_key")apiKey: String): MoviesResponse
}
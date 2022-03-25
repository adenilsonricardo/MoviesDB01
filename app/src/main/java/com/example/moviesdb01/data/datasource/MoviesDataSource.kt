package com.example.moviesdb01.data.datasource

import com.example.moviesdb01.data.models.MoviesResponse
import kotlinx.coroutines.flow.Flow

internal interface MoviesDataSource {
    fun getMovies(): Flow<MoviesResponse>
}
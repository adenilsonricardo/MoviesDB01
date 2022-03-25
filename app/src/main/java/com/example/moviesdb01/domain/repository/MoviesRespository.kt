package com.example.moviesdb01.domain.repository

import com.example.moviesdb01.domain.model.Movies
import kotlinx.coroutines.flow.Flow

interface MoviesRespository {
    fun getMovies(): Flow<Movies>
}
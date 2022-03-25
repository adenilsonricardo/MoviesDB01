package com.example.moviesdb01.domain.usecase

import com.example.moviesdb01.domain.model.Movies
import com.example.moviesdb01.domain.repository.MoviesRespository
import kotlinx.coroutines.flow.Flow

class MoviesUseCase(
    private val repository: MoviesRespository,
){
    operator fun invoke(): Flow<Movies> {
        return repository.getMovies()
    }
}
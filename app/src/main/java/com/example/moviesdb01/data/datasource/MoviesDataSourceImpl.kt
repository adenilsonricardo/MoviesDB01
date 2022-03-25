package com.example.moviesdb01.data.datasource

import com.example.moviesdb01.data.api.MoviesApi
import com.example.moviesdb01.data.models.MoviesResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

const val API_KEY = "cf20abfa4daa8cc80b1708476db3178d"

class MoviesDataSourceImpl(private val service: MoviesApi): MoviesDataSource  {

    override fun getMovies(): Flow<MoviesResponse> {
        return flow{
            emit(service.getMovies(apiKey = API_KEY))
        }
    }

}
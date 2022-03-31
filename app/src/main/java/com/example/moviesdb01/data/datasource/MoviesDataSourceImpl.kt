package com.example.moviesdb01.data.datasource

import com.example.moviesdb01.BuildConfig
import com.example.moviesdb01.data.api.MoviesApi
import com.example.moviesdb01.data.models.MoviesResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

const val API_KEY = "Sua_Chave_da_API_aqui"

class MoviesDataSourceImpl(private val service: MoviesApi): MoviesDataSource  {

    override fun getMovies(): Flow<MoviesResponse> {
        return flow{
            emit(service.getMovies(apiKey = API_KEY))
        }
    }

}
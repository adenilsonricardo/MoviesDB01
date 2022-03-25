package com.example.moviesdb01.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.moviesdb01.data.datasource.MoviesDataSource
import com.example.moviesdb01.data.mapper.MoviesMapper
import com.example.moviesdb01.domain.model.Movies
import com.example.moviesdb01.domain.repository.MoviesRespository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class MoviesRespositoryImpl (
    private val moviesDataSource: MoviesDataSource,
    private val moviesMapper: MoviesMapper
): MoviesRespository {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun getMovies(): Flow<Movies> {
        return moviesDataSource.getMovies().map (moviesMapper::map)
    }
}
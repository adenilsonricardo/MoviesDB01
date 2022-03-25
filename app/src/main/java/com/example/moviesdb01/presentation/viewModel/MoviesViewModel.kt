package com.example.moviesdb01.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesdb01.domain.model.Movies
import com.example.moviesdb01.domain.usecase.MoviesUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class MoviesViewModel(
    private val moviesUseCase: MoviesUseCase,
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
): ViewModel() {

    private val _movies:MutableLiveData<Movies> = MutableLiveData()
    val movies: LiveData<Movies> = _movies
    private val _error:MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String> = _error

    init {
        getMovies()
    }

    private fun getMovies(){
        viewModelScope.launch {
            moviesUseCase()
                .flowOn(coroutineDispatcher)
                .catch { exception ->
                    _error.value = exception.message
                }
                .collect { moviesList ->
                    _movies.value = moviesList
                }
        }
    }
}
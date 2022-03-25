package com.example.moviesdb01.di

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.moviesdb01.data.api.MoviesApi
import com.example.moviesdb01.data.datasource.MoviesDataSource
import com.example.moviesdb01.data.datasource.MoviesDataSourceImpl
import com.example.moviesdb01.data.mapper.MoviesMapper
import com.example.moviesdb01.data.repository.MoviesRespositoryImpl
import com.example.moviesdb01.domain.repository.MoviesRespository
import com.example.moviesdb01.domain.usecase.MoviesUseCase
import com.example.moviesdb01.presentation.viewModel.MoviesViewModel
import com.example.moviesdb01.utils.RetrofitService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal class MoviesModule: FeatureModule() {
    @RequiresApi(Build.VERSION_CODES.N)
    override val dataModule = module {
        factory<MoviesApi> {RetrofitService.retrofit.create(MoviesApi::class.java)}
        factory<MoviesDataSource> { MoviesDataSourceImpl(service = get()) }
        factory<MoviesRespository> { MoviesRespositoryImpl(moviesDataSource = get(), moviesMapper = get()) }
        factory<MoviesMapper> { MoviesMapper() }
    }
    override val domainModule = module {
        factory { MoviesUseCase(repository = get()) }
    }
    override val presentationModule =
        module { viewModel { MoviesViewModel(moviesUseCase = get()) } }
}
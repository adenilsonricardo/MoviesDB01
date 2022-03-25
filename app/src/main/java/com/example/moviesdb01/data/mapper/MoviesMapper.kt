package com.example.moviesdb01.data.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.moviesdb01.data.models.MoviesResponse
import com.example.moviesdb01.data.models.ResultsResponse
import com.example.moviesdb01.domain.model.Movies
import com.example.moviesdb01.domain.model.MoviesResult
import com.example.moviesdb01.utils.Mapper

@RequiresApi(Build.VERSION_CODES.N)
class MoviesMapper: Mapper<MoviesResponse, Movies> {

    override fun map(source: MoviesResponse): Movies {
        return Movies(
            page = 0,
            results = source.results?.let { mapResults(it) },
            totalPages = 0,
            totalResults = 0,
        )
    }

    private fun mapResults(statusResult: List<ResultsResponse>): List<MoviesResult> {
        return statusResult.map{
            MoviesResult(
                adult = it.adult,
                backdropPath = it.backdropPath,
                genreIds = it.genreIds,
                id = it.id,
                originalLanguage = it.originalLanguage,
                originalTitle = it.originalTitle,
                overview = it.overview,
                popularity = it.popularity,
                posterPath = it.posterPath,
                releaseDate = it.releaseDate,
                title = it.title,
                video = it.video,
                voteAverage = it.voteAverage,
                voteCount = it.voteCount
            )
        }
    }
}
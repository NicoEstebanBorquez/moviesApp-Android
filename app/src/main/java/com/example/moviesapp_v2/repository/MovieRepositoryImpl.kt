package com.example.moviesapp_v2.repository

import com.example.moviesapp_v2.data.local.localMovieDataSource
import com.example.moviesapp_v2.data.model.MovieList
import com.example.moviesapp_v2.data.model.toMovieEntity
import com.example.moviesapp_v2.data.remote.remoteMovieDataSource

// INTERFACE IMPLEMENTATION

class MovieRepositoryImpl(
    private val dataSourceRemote: remoteMovieDataSource,
    private val dataSourceLocal: localMovieDataSource
) : MovieRepository {

    override suspend fun getUpcomingMovies(): MovieList {
        dataSourceRemote.getUpcomingMovies().results.forEach { movie ->
            dataSourceLocal.saveMovie(movie.toMovieEntity("upcoming"))
        }

        return dataSourceLocal.getUpcomingMovies()
    }

    override suspend fun getTopRatedMovies(): MovieList {
        dataSourceRemote.getTopRatedMovies().results.forEach { movie ->
            dataSourceLocal.saveMovie(movie.toMovieEntity("toprated"))
        }
        return dataSourceLocal.getTopRatedMovies()
    }

    override suspend fun getPopularMovies(): MovieList {
        dataSourceRemote.getPopularMovies().results.forEach { movie ->
            dataSourceLocal.saveMovie(movie.toMovieEntity("popular"))
        }
        return dataSourceLocal.getPopularMovies()
    }
}
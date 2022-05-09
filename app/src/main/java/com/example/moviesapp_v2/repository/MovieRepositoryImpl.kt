package com.example.moviesapp_v2.repository
import com.example.moviesapp_v2.data.model.MovieList
import com.example.moviesapp_v2.data.remote.MovieDataSource

// INTERFACE IMPLEMENTATION

class MovieRepositoryImpl(private val dataSource: MovieDataSource) : MovieRepository {

    override suspend fun getUpcomingMovies(): MovieList {
        return dataSource.getUpcomingMovies()
    }

    override suspend fun getTopRatedMovies(): MovieList {
        return dataSource.getTopRatedMovies()
    }

    override suspend fun getPopularMovies(): MovieList {
        return dataSource.getPopularMovies()
    }
}
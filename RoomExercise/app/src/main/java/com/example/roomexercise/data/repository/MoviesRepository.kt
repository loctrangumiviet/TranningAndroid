package com.example.roomexercise.data.repository

import androidx.lifecycle.LiveData
import com.example.roomexercise.data.local.dao.MovieDAO
import com.example.roomexercise.data.model.Category
import com.example.roomexercise.data.model.Movie

class MoviesRepository(private val movieDao: MovieDAO) {
    val movies: LiveData<MutableList<Movie>> = movieDao.getALlMovies()

    suspend fun insertCategory(movie: Movie) {
        movieDao.insertMovies(movie)
    }

    fun getMoviesSearch(key: String, id: Int): LiveData<MutableList<Movie>> {
        return movieDao.getListMovies(key, id)
    }

    fun getMoviesByCategoryID(id: Int): LiveData<MutableList<Movie>> {
        return movieDao.getListMovieByCategoryID(id)
    }
}
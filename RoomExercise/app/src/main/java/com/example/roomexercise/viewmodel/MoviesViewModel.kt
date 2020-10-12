package com.example.roomexercise.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomexercise.data.local.database.getDatabase
import com.example.roomexercise.data.model.Category
import com.example.roomexercise.data.model.Movie
import com.example.roomexercise.data.repository.CategoriesRepository
import com.example.roomexercise.data.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesViewModel(application: Application) : AndroidViewModel(application) {
    private val moviesRepository: MoviesRepository
    private val categoriesRepository: CategoriesRepository
    val movies : LiveData<MutableList<Movie>>
    val categories: LiveData<MutableList<Category>>

    init {
        val movieDAO = getDatabase(application).moviesDAO
        moviesRepository = MoviesRepository(movieDAO)
        movies = moviesRepository.movies
        val categoryDAO = getDatabase(application).categoriesDAO
        categoriesRepository = CategoriesRepository(categoryDAO)
        categories = categoriesRepository.categories
    }

    fun getMoviesSearch(key: String,id:Int) : LiveData<MutableList<Movie>> {
        return moviesRepository.getMoviesSearch(key,id)
    }

    fun getMoviesByCategoryID(id: Int) : LiveData<MutableList<Movie>>{
        return moviesRepository.getMoviesByCategoryID(id)
    }

    fun getCategoriesByID(id: Int): Category{
        return categoriesRepository.getCategoriesByID(id)
    }
}
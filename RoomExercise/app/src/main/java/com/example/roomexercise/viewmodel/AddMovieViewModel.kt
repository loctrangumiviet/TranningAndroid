package com.example.roomexercise.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomexercise.data.local.database.getDatabase
import com.example.roomexercise.data.model.Category
import com.example.roomexercise.data.model.Movie
import com.example.roomexercise.data.repository.CategoriesRepository
import com.example.roomexercise.data.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddMovieViewModel(application: Application) : AndroidViewModel(application) {
    private val categoriesRepository: CategoriesRepository
    private val moviesRepository: MoviesRepository
    val categories: LiveData<MutableList<Category>>

    init {
        val categoryDAO = getDatabase(application).categoriesDAO
        val movieDAO = getDatabase(application).moviesDAO
        categoriesRepository = CategoriesRepository(categoryDAO)
        moviesRepository = MoviesRepository(movieDAO)
        categories = categoriesRepository.categories
    }

    fun insertMovies(movie: Movie) = viewModelScope.launch(Dispatchers.IO) {
        moviesRepository.insertCategory(movie)
    }
}
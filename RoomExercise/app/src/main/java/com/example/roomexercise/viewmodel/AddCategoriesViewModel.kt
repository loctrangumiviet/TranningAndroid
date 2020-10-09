package com.example.roomexercise.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomexercise.data.local.database.MoviesDatabase
import com.example.roomexercise.data.local.database.getDatabase
import com.example.roomexercise.data.model.Category
import com.example.roomexercise.data.repository.CategoriesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddCategoriesViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: CategoriesRepository
    val categories: LiveData<MutableList<Category>>

    init {
        val categoryDAO = getDatabase(application).categoriesDAO
        repository = CategoriesRepository(categoryDAO)
        categories = repository.categories
    }

    fun insert(category: Category) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertCategory(category)
    }
}
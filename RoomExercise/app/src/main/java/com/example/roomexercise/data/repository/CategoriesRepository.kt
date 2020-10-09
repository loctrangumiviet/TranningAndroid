package com.example.roomexercise.data.repository

import androidx.lifecycle.LiveData
import com.example.roomexercise.data.local.dao.CategoryDAO
import com.example.roomexercise.data.model.Category

class CategoriesRepository(private val categoryDAO: CategoryDAO) {

    val categories: LiveData<MutableList<Category>> = categoryDAO.getListCategories()

    suspend fun insertCategory(category: Category){
        categoryDAO.insertCategories(category)
    }
}
package com.example.roomexercise.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomexercise.data.model.Category

@Dao
interface CategoryDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategories(category: Category)

    @Query("SELECT * FROM category")
    fun getListCategories(): LiveData<MutableList<Category>>

    @Query("SELECT * FROM category WHERE categoryID = :id")
    fun getCategoryByID(id: Int): Category
}
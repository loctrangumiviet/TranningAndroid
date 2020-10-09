package com.example.roomexercise.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomexercise.model.Category

@Dao
interface CategoryDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategories(category: Category)

    @Query("SELECT * FROM category")
    fun getListCategories(): MutableList<Category>

    @Query("SELECT * FROM category WHERE categoryID = :id")
    fun getListCategoryByID(id: Int): Category

    @Query("DELETE FROM category")
    fun clearCategories()
}
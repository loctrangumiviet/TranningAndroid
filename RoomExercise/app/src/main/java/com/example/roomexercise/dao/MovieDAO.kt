package com.example.roomexercise.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomexercise.model.Movie

@Dao
interface MovieDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(vararg movies: Movie)

    @Query("SELECT * FROM movie")
    fun getALlMovies(): MutableList<Movie>

    @Query("SELECT * FROM movie WHERE (id LIKE :key OR movieName LIKE :key)  AND category_id = :categoryID")
    fun getListMovies(key: String,categoryID: Int) : MutableList<Movie>

    @Query("SELECT * FROM movie WHERE category_id = :categoryID")
    fun getListMovieByCategoryID(categoryID: Int) : MutableList<Movie>
}
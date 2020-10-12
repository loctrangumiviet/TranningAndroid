package com.example.roomexercise.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomexercise.data.model.Movie

@Dao
interface MovieDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(vararg movies: Movie)

    @Query("SELECT * FROM movie")
    fun getALlMovies(): LiveData<MutableList<Movie>>

    @Query("SELECT * FROM movie WHERE (id LIKE :key OR movieName LIKE :key)  AND category_id = :categoryID")
    fun getListMovies(key: String,categoryID: Int) : LiveData<MutableList<Movie>>

    @Query("SELECT * FROM movie WHERE category_id = :categoryID")
    fun getListMovieByCategoryID(categoryID: Int) : LiveData<MutableList<Movie>>
}
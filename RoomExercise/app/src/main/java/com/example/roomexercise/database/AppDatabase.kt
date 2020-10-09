package com.example.roomexercise.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomexercise.dao.CategoryDAO
import com.example.roomexercise.dao.MovieDAO
import com.example.roomexercise.helper.GlobalVariables
import com.example.roomexercise.model.Category
import com.example.roomexercise.model.Movie

@Database(entities = [Category::class, Movie::class], version = 1, exportSchema = false)
abstract class MoviesDatabase : RoomDatabase(){
    abstract val categoriesDAO: CategoryDAO
    abstract val moviesDAO: MovieDAO
}

private lateinit var INSTANCE: MoviesDatabase
fun getDatabase(context: Context):MoviesDatabase{
    synchronized(MoviesDatabase::class.java){
        if (!::INSTANCE.isInitialized){
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                MoviesDatabase::class.java,
                GlobalVariables.DATABASE_NAME)
                .addMigrations()
                .fallbackToDestructiveMigration()
                .build()
        }
    }
    return INSTANCE
}
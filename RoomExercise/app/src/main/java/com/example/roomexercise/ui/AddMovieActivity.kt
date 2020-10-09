package com.example.roomexercise.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.roomexercise.R
import com.example.roomexercise.adapter.CustomDropDownAdapter
import com.example.roomexercise.database.getDatabase
import com.example.roomexercise.helper.GlobalMethod
import com.example.roomexercise.model.Category
import com.example.roomexercise.model.Movie
import kotlinx.android.synthetic.main.activity_add_movie.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddMovieActivity : AppCompatActivity() {
    private lateinit var categories: MutableList<Category>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movie)
        init()
        initListener()
    }

    private fun init() {
        GlobalScope.launch(Dispatchers.IO) {
            categories = getDatabase(this@AddMovieActivity).categoriesDAO.getListCategories()
            withContext(Dispatchers.Main) {
                CustomDropDownAdapter(this@AddMovieActivity,categories).let {
                    spCategoriesAddMoviesAtv.adapter = it
                }

            }
        }
    }

    private fun initListener() {
        btnFinish.setOnClickListener {
            finish()
        }

        btnAddMovie.setOnClickListener {
            val category = spCategoriesAddMoviesAtv.selectedItem as Category
            val moviesName = edtMoviesName.text.toString()
            if (moviesName.isNotEmpty()) {
                val movies = Movie(movieName = moviesName, categoryID = category.categoryID)
                GlobalScope.launch(Dispatchers.IO) {
                    getDatabase(this@AddMovieActivity).moviesDAO.insertMovies(movies)
                    withContext(Dispatchers.Main){
                        GlobalMethod.showToast(getString(R.string.message_complete),this@AddMovieActivity)
                        edtMoviesName.setText(getString(R.string.empty_string))
                    }
                }
            } else {
                GlobalMethod.showToast(getString(R.string.insert_fail),this)
            }
        }


        btnRemoveCategories.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                getDatabase(this@AddMovieActivity).categoriesDAO.clearCategories()
                init()
            }
        }
    }
}
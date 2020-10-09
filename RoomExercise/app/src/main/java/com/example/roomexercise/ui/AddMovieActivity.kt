package com.example.roomexercise.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.roomexercise.R
import com.example.roomexercise.adapter.CustomDropDownAdapter
import com.example.roomexercise.data.local.database.getDatabase
import com.example.roomexercise.helper.GlobalMethod
import com.example.roomexercise.data.model.Category
import com.example.roomexercise.data.model.Movie
import com.example.roomexercise.viewmodel.AddCategoriesViewModel
import com.example.roomexercise.viewmodel.AddMovieViewModel
import kotlinx.android.synthetic.main.activity_add_movie.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddMovieActivity : AppCompatActivity() {
    private lateinit var categoriesViewModel: AddCategoriesViewModel
    private lateinit var movieViewModel: AddMovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movie)
        init()
        initListener()
    }

    private fun init() {
        categoriesViewModel = ViewModelProvider(this).get(AddCategoriesViewModel::class.java)
        movieViewModel = ViewModelProvider(this).get(AddMovieViewModel::class.java)

        categoriesViewModel.categories.observe(this, Observer {categories ->
            categories?.let {
                CustomDropDownAdapter(this@AddMovieActivity,categories).let {
                spCategoriesAddMoviesAtv.adapter = it
            } }
        })
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
                movieViewModel.insertMovies(movies)
                GlobalMethod.showToast(getString(R.string.message_complete),this@AddMovieActivity)
                edtMoviesName.setText(getString(R.string.empty_string))
//                GlobalScope.launch(Dispatchers.IO) {
//                    getDatabase(this@AddMovieActivity).moviesDAO.insertMovies(movies)
//                    withContext(Dispatchers.Main){
//                        GlobalMethod.showToast(getString(R.string.message_complete),this@AddMovieActivity)
//                        edtMoviesName.setText(getString(R.string.empty_string))
//                    }
//                }
            } else {
                GlobalMethod.showToast(getString(R.string.insert_fail),this)
            }
        }

    }
}
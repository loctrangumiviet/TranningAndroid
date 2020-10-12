package com.example.roomexercise.ui

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomexercise.R
import com.example.roomexercise.adapter.CustomDropDownAdapter
import com.example.roomexercise.adapter.MoviesAdapter
import com.example.roomexercise.data.local.database.getDatabase
import com.example.roomexercise.helper.GlobalVariables
import com.example.roomexercise.data.model.Category
import com.example.roomexercise.data.model.Movie
import com.example.roomexercise.viewmodel.AddCategoriesViewModel
import com.example.roomexercise.viewmodel.AddMovieViewModel
import com.example.roomexercise.viewmodel.MoviesViewModel
import kotlinx.android.synthetic.main.activity_movies.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MoviesActivity : AppCompatActivity() {
    private lateinit var movieViewModel: MoviesViewModel
    private var categories: MutableList<Category> = arrayListOf()
    private var movies: MutableList<Movie> = arrayListOf()
    private var adapterMovies: MoviesAdapter? = null
    private var category: Category? = null
    private var key: String? = null
    private var sharedPref: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
        sharedPref = getSharedPreferences(GlobalVariables.PREF_NAME, GlobalVariables.PRIVATE_MODE)
        initAdapter()
        init()
        mListener()
    }

    private fun mListener() {
        btnSearch.setOnClickListener {
            category = spCategoriesMoviesAtv.selectedItem as Category
            key = edtKeyWordSearch.text.toString()
            if (category?.categoryID == -1 && key!!.isEmpty()) {
                movieViewModel.movies.observe(this, { movie ->
                    adapterMovies?.submitList(movie)
                })
            } else if (key!!.isEmpty()) {
                movieViewModel.getMoviesByCategoryID(category!!.categoryID)
                    .observe(this@MoviesActivity, { movie ->
                        adapterMovies?.submitList(movie)
                    })
            } else {
                movieViewModel.getMoviesSearch("%${key}%", category!!.categoryID)
                    .observe(this@MoviesActivity, { movie ->
                        adapterMovies?.submitList(movie)
                    })
            }
            sharedPref?.edit()?.apply {
                key?.let { putString(GlobalVariables.KEY_SEARCH, it) }
                category?.let { putInt(GlobalVariables.CATEGORY_ID, it.categoryID) }
                apply()
            }
        }
    }

    private fun initAdapter() {
        adapterMovies = MoviesAdapter().apply {
            submitList(movies)
        }
        with(rcvMovies) {
            layoutManager =
                LinearLayoutManager(this@MoviesActivity, LinearLayoutManager.VERTICAL, false)
            val dividerItemDecoration =
                DividerItemDecoration(this@MoviesActivity, LinearLayoutManager.VERTICAL)
            addItemDecoration(dividerItemDecoration)
            adapter = adapterMovies
        }
    }

    private fun init() {
        movieViewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)
        sharedPref?.getString(GlobalVariables.KEY_SEARCH, "").run {
            if (!this.isNullOrEmpty()) {
                edtKeyWordSearch.setText(this)
            }
        }
        val oldCategory = sharedPref?.getInt(GlobalVariables.CATEGORY_ID, -1)?.let {
            GlobalScope.launch(Dispatchers.IO) {
                movieViewModel.getCategoriesByID(it)
            }
        }
        val index = categories.indexOf(oldCategory)
        movieViewModel.categories.observe(this@MoviesActivity, { categoriesList ->
            categories = categoriesList.apply {
                add(0, Category(-1, getString(R.string.selected_item_hint)))
            }
            val customAdapter = CustomDropDownAdapter(this@MoviesActivity, categories)
            with(spCategoriesMoviesAtv) {
                adapter = customAdapter
                if (index != -1) {
                    setSelection(index)
                }
            }
        })
    }
}
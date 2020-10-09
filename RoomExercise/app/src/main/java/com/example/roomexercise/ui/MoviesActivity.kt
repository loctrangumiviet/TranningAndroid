package com.example.roomexercise.ui

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomexercise.R
import com.example.roomexercise.adapter.CustomDropDownAdapter
import com.example.roomexercise.adapter.MoviesAdapter
import com.example.roomexercise.database.getDatabase
import com.example.roomexercise.helper.GlobalVariables
import com.example.roomexercise.model.Category
import com.example.roomexercise.model.Movie
import kotlinx.android.synthetic.main.activity_movies.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MoviesActivity : AppCompatActivity() {
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
            GlobalScope.launch(Dispatchers.IO) {
                movies = if (category?.categoryID == -1 && key!!.isEmpty()) {
                    getDatabase(this@MoviesActivity).moviesDAO.getALlMovies()
                } else if (key!!.isEmpty()) {
                    getDatabase(this@MoviesActivity).moviesDAO.getListMovieByCategoryID(categoryID = category!!.categoryID)
                } else {
                    getDatabase(this@MoviesActivity).moviesDAO.getListMovies(
                        "%${key}%",
                        categoryID = category!!.categoryID
                    )
                }
                withContext(Dispatchers.Main) {
                    adapterMovies?.submitList(movies)
                }
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
            layoutManager = LinearLayoutManager(this@MoviesActivity, LinearLayoutManager.VERTICAL, false)
            val dividerItemDecoration = DividerItemDecoration(this@MoviesActivity,LinearLayoutManager.VERTICAL)
            addItemDecoration(dividerItemDecoration)
            adapter = adapterMovies
        }
    }

    private fun init() {
        sharedPref?.getString(GlobalVariables.KEY_SEARCH, "").run {
            if (!this.isNullOrEmpty()) {
                edtKeyWordSearch.setText(this)
            }
        }
        GlobalScope.launch(Dispatchers.IO) {
            val oldCategory = sharedPref?.getInt(GlobalVariables.CATEGORY_ID, -1)?.let {
                getDatabase(this@MoviesActivity).categoriesDAO.getListCategoryByID(it)
            }
            categories = getDatabase(this@MoviesActivity).categoriesDAO.getListCategories().apply {
                add(0, Category(-1, getString(R.string.selected_item_hint)))
            }
            val index = categories.indexOf(oldCategory)
            withContext(Dispatchers.Main) {
                CustomDropDownAdapter(this@MoviesActivity, categories).run {
                    spCategoriesMoviesAtv.adapter = this
                }
                if (index != -1) {
                    spCategoriesMoviesAtv.setSelection(index)
                }
            }
        }
    }
}
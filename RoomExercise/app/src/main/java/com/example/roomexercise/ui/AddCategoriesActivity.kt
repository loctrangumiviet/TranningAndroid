package com.example.roomexercise.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.roomexercise.R
import com.example.roomexercise.helper.GlobalMethod
import com.example.roomexercise.data.model.Category
import com.example.roomexercise.viewmodel.AddCategoriesViewModel
import kotlinx.android.synthetic.main.activity_add_categories.*

class AddCategoriesActivity : AppCompatActivity() {
    private lateinit var categoriesViewModel: AddCategoriesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_categories)
        init()
        initListener()
    }

    private fun init() {
        categoriesViewModel = ViewModelProvider(this).get(AddCategoriesViewModel::class.java)
    }


    @SuppressLint("ShowToast")
    private fun initListener() {
        btnAddCategory.setOnClickListener {
            val nameCategories = edtCategoryName.text.toString()
            if (nameCategories.isNotEmpty()) {
                val categories = Category(categoryName = nameCategories)
                categoriesViewModel.insert(categories)
                GlobalMethod.showToast(getString(R.string.insert_complete,categories.categoryName), this@AddCategoriesActivity)
                edtCategoryName.setText(getString(R.string.empty_string))
            } else {
                GlobalMethod.showToast(getString(R.string.insert_fail), this)
            }
        }

        btnShowAddMovieAtv.setOnClickListener {
            Intent(this, AddMovieActivity::class.java).run {
                startActivity(this)
                finish()
            }
        }
    }


}
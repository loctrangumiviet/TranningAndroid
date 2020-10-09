package com.example.roomexercise.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import com.example.roomexercise.R
import com.example.roomexercise.database.getDatabase
import com.example.roomexercise.helper.GlobalMethod
import com.example.roomexercise.model.Category
import kotlinx.android.synthetic.main.activity_add_categories.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddCategoriesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_categories)
        initListener()
    }


    @SuppressLint("ShowToast")
    private fun initListener() {
        btnAddCategory.setOnClickListener {
            val nameCategories = edtCategoryName.text.toString()
            if (nameCategories.isNotEmpty()) {
                val categories = Category(categoryName = nameCategories)
                GlobalScope.launch(Dispatchers.IO) {
                    getDatabase(this@AddCategoriesActivity).categoriesDAO.insertCategories(categories)
                    withContext(Dispatchers.Main) {
                        GlobalMethod.showToast(getString(R.string.insert_complete,categories.categoryName), this@AddCategoriesActivity)
                        edtCategoryName.setText(getString(R.string.empty_string))
                    }
                }
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
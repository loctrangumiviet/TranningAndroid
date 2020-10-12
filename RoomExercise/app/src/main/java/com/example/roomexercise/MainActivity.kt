package com.example.roomexercise

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.roomexercise.ui.AddCategoriesActivity
import com.example.roomexercise.ui.MoviesActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListener()
    }

    private fun initListener() {
        btnShowAddCategoriesAtv.setOnClickListener {
            Intent(this, AddCategoriesActivity::class.java).run {
                startActivity(this)

            }
        }

        btnShowFilterMoviesAtv.setOnClickListener {
            Intent(this, MoviesActivity::class.java).run {
                startActivity(this)

            }
        }
    }
}
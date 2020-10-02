package com.example.uiexercise.ui

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uiexercise.R
import com.example.uiexercise.adapter.DataDummy
import com.example.uiexercise.adapter.FruitMainAdapter
import com.example.uiexercise.adapter.Helper
import com.example.uiexercise.model.Fruit
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable
import java.util.*

@Suppress("CAST_NEVER_SUCCEEDS")
class MainActivity : AppCompatActivity() {
    private var fruits: MutableList<Fruit> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initAdapter()
    }

    private fun initAdapter() {
        fruits = DataDummy.dummyData(this)
        val adapterFruit = FruitMainAdapter(::getWidthDevice,::mOnClick).apply {
            submitList(fruits)
        }

        atvMain_rcvFruit.apply {
            layoutManager = GridLayoutManager(context,2)
            adapter = adapterFruit
        }
    }

    private fun mOnClick(fruit: Fruit) {
        val intent = Intent(this,DetailActivity::class.java).apply {
            putExtra("Fruit",fruit as Serializable)
        }
        startActivity(intent)
    }


    private fun getWidthDevice(): Int {
        return Helper.getWidthScreen()
    }


}
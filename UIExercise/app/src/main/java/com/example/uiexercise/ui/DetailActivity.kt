package com.example.uiexercise.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.uiexercise.R
import com.example.uiexercise.adapter.DataDummy
import com.example.uiexercise.adapter.FruitSuggestionAdapter
import com.example.uiexercise.model.Fruit
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_image_fruit.*

@Suppress("CAST_NEVER_SUCCEEDS")
class DetailActivity : AppCompatActivity() {
    private var fruitSuggestions: MutableList<Fruit> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initIntent()
        initAdapter()
        mOnclickListener()
    }

    private fun mOnclickListener() {
        atvDetail_btnBack.setOnClickListener {
            finish()
        }

        atvDetail_btnIncreased.setOnClickListener {
            updateAmount(true)
        }

        atvDetail_btnReduced.setOnClickListener {
            updateAmount(false)
        }
    }

    private fun updateAmount(isIncrease: Boolean){
        var amount = atvDetail_tvAmount.text.toString().toInt()
        if(isIncrease)
            amount++
        else
            if(amount > 1) amount--
        atvDetail_tvAmount.text = amount.toString()
    }

    private fun initAdapter() {
        fruitSuggestions = DataDummy.dummyData(this)
        val adapterFruitSuggestion= FruitSuggestionAdapter().apply {
            submitList(fruitSuggestions)
        }
        atvDetail_rcvFruitSuggestion.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = adapterFruitSuggestion
        }
    }

    @SuppressLint("SetTextI18n")
    private fun initIntent() {
        val intent = intent
        val fruit = intent.getSerializableExtra("Fruit") as Fruit
        with(fruit){
            Glide.with(this@DetailActivity).load(linkImage).into(atvDetail_imgFruit)
            atvDetail_tvTitle.text = title
            atvDetail_btnTitle.text = title
            atvDetail_tvAmount.text = "1"
            atvDetail_tvPrice.text = "${price}€"
            atvDetail_tvTotalStart.text = "3.5"
            atvDetail_tvAverageRating.text = "(${72})"
            atvDetail_description.text = description
        }
    }
}
package com.example.retrofit_koin_mvvm.data.entities

data class DataEmployee(
    val status : String,
    val data : MutableList<Employee>,
    val message : String
)
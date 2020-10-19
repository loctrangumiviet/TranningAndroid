package com.example.retrofit_koin_mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofit_koin_mvvm.R
import com.example.retrofit_koin_mvvm.ui.employees.EmployeeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.mainAtv, EmployeeFragment()).commit()
    }
}
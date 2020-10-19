package com.example.retrofit_koin_mvvm.di

import com.example.retrofit_koin_mvvm.ui.employees.EmployeeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { EmployeeViewModel(get()) }
}
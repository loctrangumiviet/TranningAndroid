package com.example.retrofit_koin_mvvm.di

import com.example.retrofit_koin_mvvm.data.repository.EmployeeRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { EmployeeRepository(get()) }
}
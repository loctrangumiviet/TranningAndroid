package com.example.retrofit_koin_mvvm.data.remote

import com.example.retrofit_koin_mvvm.data.entities.DataEmployee
import retrofit2.Response
import retrofit2.http.GET

interface EmployeeService {
    @GET("employees")
    suspend fun getEmployees(): Response<DataEmployee>
}
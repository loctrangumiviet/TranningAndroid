package com.example.retrofit_koin_mvvm.data.repository


import com.example.retrofit_koin_mvvm.data.remote.EmployeeService

class EmployeeRepository(private val employeeService: EmployeeService) {
    suspend fun getEmployees() = employeeService.getEmployees()
}
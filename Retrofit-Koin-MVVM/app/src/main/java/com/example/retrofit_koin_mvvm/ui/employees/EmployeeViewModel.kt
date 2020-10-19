package com.example.retrofit_koin_mvvm.ui.employees

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit_koin_mvvm.data.entities.DataEmployee
import com.example.retrofit_koin_mvvm.data.repository.EmployeeRepository
import kotlinx.coroutines.launch

class EmployeeViewModel(private val employeeRepository: EmployeeRepository) : ViewModel() {
    var employees : MutableLiveData<DataEmployee> = MutableLiveData()
    init {
        viewModelScope.launch {
            val response = employeeRepository.getEmployees()
            if(response.isSuccessful && response.body() != null){
                employees.value = response.body()
            }
        }
    }
}
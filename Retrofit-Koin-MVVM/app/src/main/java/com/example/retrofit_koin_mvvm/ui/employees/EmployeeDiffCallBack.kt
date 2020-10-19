package com.example.retrofit_koin_mvvm.ui.employees

import androidx.recyclerview.widget.DiffUtil
import com.example.retrofit_koin_mvvm.data.entities.Employee

class EmployeeDiffCallBack : DiffUtil.ItemCallback<Employee>() {
    override fun areItemsTheSame(oldItem: Employee, newItem: Employee): Boolean {
        return  oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Employee, newItem: Employee): Boolean {
        return  oldItem == newItem
    }
}
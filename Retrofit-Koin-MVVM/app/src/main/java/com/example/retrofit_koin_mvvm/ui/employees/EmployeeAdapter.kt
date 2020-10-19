package com.example.retrofit_koin_mvvm.ui.employees

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit_koin_mvvm.R
import com.example.retrofit_koin_mvvm.data.entities.Employee
import kotlinx.android.synthetic.main.employee_item.view.*
import java.util.concurrent.Executors

class EmployeeAdapter : ListAdapter<Employee, EmployeeAdapter.EmployeeViewHolder>(
    AsyncDifferConfig.Builder<Employee>(EmployeeDiffCallBack())
        .setBackgroundThreadExecutor(Executors.newSingleThreadExecutor())
        .build()
) {

    inner class EmployeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(employee: Employee){
            itemView.tvEmployeeName.text = employee.employee_name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        return  EmployeeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.employee_item,parent,false))
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
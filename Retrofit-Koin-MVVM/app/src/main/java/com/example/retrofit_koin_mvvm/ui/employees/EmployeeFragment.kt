package com.example.retrofit_koin_mvvm.ui.employees

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit_koin_mvvm.R
import kotlinx.android.synthetic.main.fragment_employee.*

class EmployeeFragment : Fragment() {
    private val viewModel: EmployeeViewModel by viewModel()
    private lateinit var employeeAdapter: EmployeeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_employee, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObserver()
    }

    private fun setupRecyclerView() {
        employeeAdapter = EmployeeAdapter()
        with(rcvEmployee) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = employeeAdapter
        }
    }

    private fun setupObserver() {
        viewModel.employees.observe(viewLifecycleOwner, Observer {
            employeeAdapter.submitList(it.data)
        })
    }
}
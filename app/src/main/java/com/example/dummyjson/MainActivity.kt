package com.example.dummyjson

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dummyjson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),AdapterEmp.OnItemClickListener {

    private lateinit var binding : ActivityMainBinding
    private val repository = Repository()
    private val viewModel: ViewModelEmp by viewModels {
        ViewModelFactory(repository)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapterEmp = AdapterEmp(arrayListOf(),this)

        binding.loadingTxt.visibility = View.VISIBLE
        binding.loadingTxt.text = getString(R.string.loading_empolyees_list)
        binding.jsonRecyclerView.visibility = View.GONE


        binding.jsonRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.jsonRecyclerView.adapter = adapterEmp


        viewModel.emp.observe(this) { result ->
            result.onSuccess { employees ->
                Log.e("Response :", "$employees")
                binding.loadingTxt.visibility = View.GONE
                binding.jsonRecyclerView.visibility = View.VISIBLE
                adapterEmp.updateList(employees)
            }.onFailure { error ->
                Toast.makeText(this, "Sorry Unable To Fetch Data", Toast.LENGTH_LONG).show()
                binding.loadingTxt.visibility = View.VISIBLE
                binding.loadingTxt.text = "Fail to load Employees List !!"
                binding.jsonRecyclerView.visibility = View.GONE
            }
        }
    }

    override fun onEmployeeClick(employee: EmployeeListModel) {
        val intent = Intent(this, MainActivity2::class.java)
        Log.e("EMPLOYEE_NAME", employee.name!!)
        intent.putExtra("employee_model", employee)
        startActivity(intent)


    }
}
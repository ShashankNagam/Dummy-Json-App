package com.example.dummyjson

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.dummyjson.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var bindingAct2 : ActivityMain2Binding
    private val viewModel: ViewModelEmp by viewModels {
        ViewModelFactory(Repository())
    }


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingAct2 = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(bindingAct2.root)


        val empDetailModel: EmployeeListModel? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("employee_model", EmployeeListModel::class.java)
        } else {
            intent.getParcelableExtra("employee_model")
        }

        empDetailModel?.let {
            Log.e("EMPLOYEE_NAME", it.name ?: "No Name")
            Log.e("EMPLOYEE_AGE", it.age.toString() ?: "No Age")
            Log.e("EMPLOYEE_SALARY", it.salary.toString() ?: "No Salary")
        }

        viewModel.setEmployeeDetails(empDetailModel!!)

        viewModel.employeeDetails.observe(this) { employeeDetails ->
            if (employeeDetails != null && employeeDetails.age != -1) {
                bindingAct2.apply {
                    empDetailName.text = employeeDetails.name
                    empDetailAge.text = employeeDetails.age.toString()
                    empDetailSalary.text = employeeDetails.salary.toString()
                }
            } else {
                bindingAct2.empDetailName.text = "No employee selected."
            }
        }

        bindingAct2.backButton.setOnClickListener {
            finish()
        }
    }
}
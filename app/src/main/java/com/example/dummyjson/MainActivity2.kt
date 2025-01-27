package com.example.dummyjson

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.dummyjson.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var bindingAct2 : ActivityMain2Binding


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingAct2 = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(bindingAct2.root)

        val name = intent.getStringExtra("employee_name")
        val age = intent.getIntExtra("employee_age", -1)
        val salary = intent.getIntExtra("employee_salary",-1)
        Log.e("EMP_NAME_MAIN2",name!!)
        Log.e("EMP_AGE_MAIN2", age.toString())
        Log.e("EMP_SALARY_MAIN2", salary.toString())

        if (age != -1) {
            bindingAct2.apply {
                empDetailName.text = name
                empDetailAge.text = age.toString()
                empDetailSalary.text = salary.toString()
            }
        } else {
            bindingAct2.empDetailName.text = "No employee selected."
        }

    }
}
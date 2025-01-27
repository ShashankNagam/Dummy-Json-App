package com.example.dummyjson

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelEmp::class.java)) {
            return ViewModelEmp(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
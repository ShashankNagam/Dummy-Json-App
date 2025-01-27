package com.example.dummyjson

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class ViewModelEmp(private val repository: Repository) : ViewModel() {

    val emp = liveData(Dispatchers.IO){
        try {
            val response = repository.getEmployees()
            if (response.isSuccessful) {

                Log.d("Response_JSON", "JSON Response: ${response.body()?.employees}")
                emit(Result.success(response.body()?.employees ?: emptyList()))
            } else {
                emit(Result.failure(Exception("Error: ${response.code()} ${response.message()}")))
            }

        }catch (e: Exception){
            emit(Result.failure(Exception("Network Error: ${e.localizedMessage}")))
        }
    }

}
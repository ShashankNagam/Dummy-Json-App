package com.example.dummyjson

import retrofit2.Response

class Repository {

    suspend fun getEmployees(): Response<DummyDataModel> {
        return retrofitClient.apiService.getEmployees()
    }

}
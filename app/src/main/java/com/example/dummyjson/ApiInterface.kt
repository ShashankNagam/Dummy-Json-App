package com.example.dummyjson

import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("dummy/EmployeeDetails.json")
    suspend fun getEmployees(): Response<DummyDataModel>

}
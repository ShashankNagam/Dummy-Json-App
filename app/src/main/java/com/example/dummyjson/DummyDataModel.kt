package com.example.dummyjson

data class DummyDataModel(val employees : ArrayList<EmployeeListModel>)

data class EmployeeListModel(val name : String, val age : Int, val salary : Int)
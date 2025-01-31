package com.example.dummyjson

import android.os.Parcel
import android.os.Parcelable

data class DummyDataModel(val employees : ArrayList<EmployeeListModel>)

data class EmployeeListModel(val name : String?, val age : Int, val salary : Int) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(age)
        parcel.writeInt(salary)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<EmployeeListModel> {
        override fun createFromParcel(parcel: Parcel): EmployeeListModel {
            return EmployeeListModel(parcel)
        }

        override fun newArray(size: Int): Array<EmployeeListModel?> {
            return arrayOfNulls(size)
        }
    }
}
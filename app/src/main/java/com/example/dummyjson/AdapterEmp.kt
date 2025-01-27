package com.example.dummyjson

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dummyjson.databinding.EmpitemlayoutBinding


class AdapterEmp(val myBagList : ArrayList<EmployeeListModel>,private val listener: OnItemClickListener) : RecyclerView.Adapter<AdapterEmp.viewHolder>() {

    inner class viewHolder(val empCellBinding : EmpitemlayoutBinding):RecyclerView.ViewHolder(empCellBinding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterEmp.viewHolder {
        return viewHolder(EmpitemlayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: AdapterEmp.viewHolder, position: Int) {

        val model = myBagList[position]
        holder.empCellBinding.apply {
            empName.text = model.name
            empAge.text = model.age.toString()
            empSalary.text = model.salary.toString()
        }

        holder.empCellBinding.root.setOnClickListener {
            listener.onEmployeeClick(myBagList[position])
        }

    }

    override fun getItemCount(): Int { return myBagList.size }

    fun updateList(newList: List<EmployeeListModel>) {
        myBagList.clear()
        myBagList.addAll(newList)
        notifyDataSetChanged()
    }

    interface OnItemClickListener{
        fun onEmployeeClick(employee: EmployeeListModel)
    }

}
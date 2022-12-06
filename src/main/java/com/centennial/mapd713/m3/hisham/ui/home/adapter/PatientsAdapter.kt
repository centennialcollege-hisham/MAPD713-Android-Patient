package com.centennial.mapd713.m3.hisham.ui.home.adapter

import android.system.Os.remove
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.centennial.mapd713.m3.databinding.RowPatientBinding
import com.centennial.mapd713.m3.hisham.data.model.PatientResponse

class PatientsAdapter(private val list: List<PatientResponse>) : BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): PatientResponse {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var binding = RowPatientBinding.inflate(LayoutInflater.from(parent.context))

        binding.data = getItem(position)
        return binding.root
    }


}
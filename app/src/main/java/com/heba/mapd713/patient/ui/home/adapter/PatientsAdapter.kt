package com.heba.mapd713.patient.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.heba.mapd713.patient.data.model.PatientResponse
import com.heba.mapd713.patient.databinding.RowPatientBinding

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
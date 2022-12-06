package com.centennial.mapd713.m3.hisham.ui.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.centennial.mapd713.m3.databinding.RowTestBinding
import com.centennial.mapd713.m3.hisham.data.model.TestResponse

class TestAdapter(private val list: List<TestResponse>) : BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): TestResponse {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var binding = RowTestBinding.inflate(LayoutInflater.from(parent.context))
        binding.data = getItem(position)
        return binding.root
    }


}
package com.heba.mapd713.patient.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController

import com.heba.mapd713.patient.data.model.PatientResponse
import com.heba.mapd713.patient.ui.home.adapter.PatientsAdapter
import com.heba.mapd713.patient.R
import com.heba.mapd713.patient.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    private lateinit var list: List<PatientResponse>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observer()
        initListener()

    }


    override fun onResume() {
        super.onResume()
        viewModel.getPatients()
    }

    private fun observer() {
        viewModel.loadingLiveData.observe(viewLifecycleOwner, ::handleLoading)
        viewModel.errorLiveData.observe(viewLifecycleOwner, ::handleError)
        viewModel.successPatientsLiveData.observe(viewLifecycleOwner, ::patientSuccess)
    }


    private fun patientSuccess(list: List<PatientResponse>) {
        this.list = list
        val adapter = PatientsAdapter(list)
        binding.listView.adapter = adapter
    }


    private fun handleLoading(flag: Boolean) {
        binding.progressbar.isVisible = flag

    }

    private fun handleError(exception: Exception) {
    }

    private fun initListener() {
        binding.listView.setOnItemClickListener { _, _, i, _ ->
            findNavController().navigate(
                R.id.patient_details_fragment, bundleOf(
                    "patient" to list[i]
                )
            )
        }
    }

}









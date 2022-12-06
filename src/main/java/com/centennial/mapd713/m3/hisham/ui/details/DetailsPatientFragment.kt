package com.centennial.mapd713.m3.hisham.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.centennial.mapd713.m3.databinding.FragmentPatientDetailsBinding
import com.centennial.mapd713.m3.hisham.data.model.BaseEmptyWrapper
import com.centennial.mapd713.m3.hisham.data.model.PatientResponse
import com.centennial.mapd713.m3.hisham.ui.home.HomeViewModel
import com.centennial.mapd713.m3.hisham.ui.home.adapter.PatientsAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailsPatientFragment : Fragment() {

    private lateinit var binding: FragmentPatientDetailsBinding
    private val viewModel: PatientDetailsViewModel by viewModels()


    private lateinit var patient: PatientResponse

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentPatientDetailsBinding.inflate(layoutInflater)
        return binding.root
    }


    private fun getArgument() {
        patient = arguments?.getParcelable<PatientResponse>("patient") as PatientResponse
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArgument()
        viewModel.getPatient(patient.id!!)
        observer()
        initListener()
        binding.imageViewDelete.setOnClickListener({
            viewModel.deletePatient(patient.id!!)
        })

    }


    private fun observer() {
        viewModel.loadingLiveData.observe(viewLifecycleOwner, ::handleLoading)
        viewModel.errorLiveData.observe(viewLifecycleOwner, ::handleError)
        viewModel.successPatientLiveData.observe(viewLifecycleOwner, ::patientSuccess)
        viewModel.successDeletePatientLiveData.observe(viewLifecycleOwner, ::deletePatient)
    }

    private fun deletePatient(baseEmptyWrapper: BaseEmptyWrapper?) {
        Toast.makeText(context, "Patient Deleted", Toast.LENGTH_SHORT).show()
        activity?.onBackPressed()

    }


    private fun patientSuccess(patient: PatientResponse) {
        binding.data = patient
        this.patient = patient
        val adapter = TestAdapter(patient.tests!!)
        binding.listView.adapter = adapter
    }


    private fun handleLoading(flag: Boolean) {
        binding.progressbar.isVisible = flag

    }

    private fun handleError(exception: Exception) {
    }

    private fun initListener() {
        binding.listView.setOnItemClickListener { _, _, i, _ ->
//            findNavController().navigate(
//                R.id., bundleOf(
//                    "Place" to list[i]
//                )
//            )
        }
    }

}









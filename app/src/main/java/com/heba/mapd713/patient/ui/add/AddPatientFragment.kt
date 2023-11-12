package com.heba.mapd713.patient.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.heba.mapd713.patient.data.model.PatientResponse
import com.heba.mapd713.patient.databinding.FragmentPatientDetailsBinding
import com.heba.mapd713.patient.ui.details.PatientDetailsViewModel
import com.heba.mapd713.patient.ui.details.TestAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AddPatientFragment : Fragment() {

    private lateinit var binding: FragmentPatientDetailsBinding
    private val viewModel: PatientDetailsViewModel by viewModels()

    private lateinit var list: List<PatientResponse>

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

    }


    private fun observer() {
        viewModel.loadingLiveData.observe(viewLifecycleOwner, ::handleLoading)
        viewModel.errorLiveData.observe(viewLifecycleOwner, ::handleError)
        viewModel.successPatientLiveData.observe(viewLifecycleOwner, ::patientSuccess)
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









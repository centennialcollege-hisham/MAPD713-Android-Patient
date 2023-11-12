package com.heba.mapd713.patient.ui.home

import androidx.lifecycle.*
import com.heba.mapd713.patient.data.model.PatientResponse
import com.heba.mapd713.patient.data.repository.PatientRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: PatientRepository,
) : ViewModel(), LifecycleObserver {


    private val _loadingHomeLiveData = MutableLiveData<Boolean>()
    val loadingLiveData: LiveData<Boolean> = _loadingHomeLiveData

    private val _errorSHomeLiveData = MutableLiveData<Exception>()
    val errorLiveData: LiveData<Exception> = _errorSHomeLiveData

    private val _successPatientsLiveData = MutableLiveData<List<PatientResponse>>()
    val successPatientsLiveData: LiveData<List<PatientResponse>> = _successPatientsLiveData

    public fun getPatients() {
        viewModelScope.launch(Dispatchers.IO) {
            _loadingHomeLiveData.postValue(true)
            try {
                _successPatientsLiveData.postValue(repository.getPatients())
            } catch (e: Exception) {
                _errorSHomeLiveData.postValue(e)
            }
            _loadingHomeLiveData.postValue(false)
        }
    }


}
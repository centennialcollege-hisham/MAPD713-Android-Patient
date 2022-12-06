package com.centennial.mapd713.m3.hisham.ui.details

import androidx.lifecycle.*
import com.centennial.mapd713.m3.hisham.data.model.BaseEmptyWrapper
import com.centennial.mapd713.m3.hisham.data.model.PatientResponse
import com.centennial.mapd713.m3.hisham.data.repository.PatientRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PatientDetailsViewModel @Inject constructor(
    private val repository: PatientRepository,
) : ViewModel(), LifecycleObserver {


    private val _loadingHomeLiveData = MutableLiveData<Boolean>()
    val loadingLiveData: LiveData<Boolean> = _loadingHomeLiveData

    private val _errorSHomeLiveData = MutableLiveData<Exception>()
    val errorLiveData: LiveData<Exception> = _errorSHomeLiveData

    private val _successPatientLiveData = MutableLiveData<PatientResponse>()
    val successPatientLiveData: LiveData<PatientResponse> = _successPatientLiveData


  private val _successDeletePatientLiveData = MutableLiveData<BaseEmptyWrapper>()
    val successDeletePatientLiveData: LiveData<BaseEmptyWrapper> = _successDeletePatientLiveData

    fun getPatient(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _loadingHomeLiveData.postValue(true)
            try {
                _successPatientLiveData.postValue(repository.getPatient(id))
            } catch (e: Exception) {
                _errorSHomeLiveData.postValue(e)
            }
            _loadingHomeLiveData.postValue(false)
        }
    }


    fun deletePatient(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _loadingHomeLiveData.postValue(true)
            try {
                _successDeletePatientLiveData.postValue(repository.deletePatient(id))
            } catch (e: Exception) {
                _errorSHomeLiveData.postValue(e)
            }
            _loadingHomeLiveData.postValue(false)
        }
    }

}
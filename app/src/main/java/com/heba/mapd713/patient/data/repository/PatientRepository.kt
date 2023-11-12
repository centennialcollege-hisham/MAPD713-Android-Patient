package com.heba.mapd713.patient.data.repository

import com.heba.mapd713.patient.data.datasourse.RemoteDataSource
import javax.inject.Inject

class PatientRepository @Inject
constructor(private val datasource: RemoteDataSource) {


    suspend fun getPatients() = datasource.getPatients().data
    suspend fun getPatient(id: String) = datasource.getPatient(id).data
    suspend fun updatePatient(id: String) = datasource.updatePatient(id)
    suspend fun deletePatient(id: String) = datasource.deletePatient(id)


    suspend fun getTests(id: String) = datasource.getTests(id).data
    suspend fun getTest(id: String, idTest: String) = datasource.getTest(id, idTest).data
    suspend fun addTest(id: String) = datasource.addTest(id).data
    suspend fun updateTest(id: String, idTest: String) = datasource.updateTest(id, idTest)


}
package com.heba.mapd713.patient.data.datasourse

import com.heba.mapd713.patient.data.model.BaseEmptyWrapper
import com.heba.mapd713.patient.data.model.BaseWrapper
import com.heba.mapd713.patient.data.model.TestResponse
import com.heba.mapd713.patient.data.model.PatientResponse
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface RemoteDataSource {


    // Patient Route
    @GET("patients")
    suspend fun getPatients(): BaseWrapper<List<PatientResponse>>

    @GET("patients/{id}")
    suspend fun getPatient(@Path("id") id: String): BaseWrapper<PatientResponse>

    @PUT("patients/{id}")
    suspend fun updatePatient(@Path("id") id: String): BaseEmptyWrapper

    @DELETE("patients/{id}")
    suspend fun deletePatient(@Path("id") id: String): BaseEmptyWrapper

    @POST("patients")
    suspend fun addPatient(): BaseWrapper<PatientResponse>


    // Tests Route
    @DELETE("patients/{id}/tests")
    suspend fun getTests(@Path("id") id: String): BaseWrapper<List<TestResponse>>

    @GET("patients/{id}/tests/{idTest}")
    suspend fun getTest(@Path("id") id: String, @Path("idTest") idTest: String): BaseWrapper<TestResponse>

    @POST("patients/{id}/tests")
    suspend fun addTest(@Path("id") id: String): BaseWrapper<TestResponse>

    @PUT("patients/{id}/tests/{idTest}")
    suspend fun updateTest(@Path("id") id: String, @Path("idTest") idTest: String): BaseEmptyWrapper

}
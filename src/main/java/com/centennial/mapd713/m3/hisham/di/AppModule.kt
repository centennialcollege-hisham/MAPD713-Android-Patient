package com.centennial.mapd713.m3.hisham.di

import com.centennial.mapd713.m3.hisham.data.datasourse.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {


    @Provides
    fun provideCategoriesDataSources( retrofit: Retrofit): RemoteDataSource {
        return retrofit.create(RemoteDataSource::class.java)
    }
}
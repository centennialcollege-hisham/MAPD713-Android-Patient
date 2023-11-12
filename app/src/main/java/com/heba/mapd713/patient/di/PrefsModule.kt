package com.heba.mapd713.patient.di

import android.app.Application
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.heba.mapd713.patient.common.prefs.Prefs
import com.heba.mapd713.patient.common.prefs.PrefsImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PrefsModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Application): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    @Provides
    @Singleton
    fun providePrefs(sharedPreferences: SharedPreferences): Prefs {
        return PrefsImpl(sharedPreferences)
    }
}

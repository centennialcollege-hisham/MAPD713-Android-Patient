package com.centennial.mapd713.m3.hisham.di

import android.app.Application
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.centennial.mapd713.m3.hisham.common.prefs.Prefs
import com.centennial.mapd713.m3.hisham.common.prefs.PrefsImpl
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

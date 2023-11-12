package com.heba.mapd713.patient.common.prefs

import android.content.SharedPreferences
import androidx.core.content.edit

class PrefsImpl(
    private val sharedPreferences: SharedPreferences,
) : Prefs {


    override var key: String
        get() = sharedPreferences.getString(PrefKey.KEY.name, "1") ?: "0"
        set(value) {
            sharedPreferences.edit { putString(PrefKey.KEY.name, value) }
        }

    private enum class PrefKey {

        KEY

    }
}

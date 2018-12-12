package com.app.tigr.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.app.tigr.common.Constants.Companion.SETTINGS_FILE_NAME
import com.app.tigr.common.Settings
import com.app.tigr.impl.AppPreferences
import javax.inject.Inject

/**
 * Execute save and receive the app preferences
 */
class TigrAppPreferences @Inject constructor(context: Context) : AppPreferences {
    private var preferences: SharedPreferences = context.getSharedPreferences(SETTINGS_FILE_NAME, 0)

    override fun get(settName: Settings.Name): String? {
        return preferences.getString(settName.name, Settings.EMPTY)
    }

    override fun set(settings: Settings.Name, value: String) {
        preferences.edit().putString(settings.name, value).apply()
    }
}
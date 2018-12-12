package com.app.tigr.impl

import com.app.tigr.common.Settings

interface AppPreferences {
    fun get(settName: Settings.Name): String?
    fun set(settings: Settings.Name, value: String)
}
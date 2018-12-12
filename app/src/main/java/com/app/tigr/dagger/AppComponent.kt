package com.app.tigr.dagger

import android.content.Context
import com.app.tigr.impl.AppPreferences
import dagger.Component

@Component(modules = [ContextModule::class, AppModule::class])
interface AppComponent {
    fun getContext(): Context
    fun getPreferences(): AppPreferences
}
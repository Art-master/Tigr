package com.app.tigr.dagger

import android.content.Context
import com.app.tigr.data.repository.TigrAppPreferences
import com.app.tigr.impl.AppPreferences
import dagger.Module
import dagger.Provides

@Module
class AppPreferencesModule {

    @Provides
    fun provideAppPreferences(context: Context): AppPreferences {
        return TigrAppPreferences(context)
    }
}
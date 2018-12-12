package com.app.tigr.dagger

import com.app.tigr.data.repository.TigrAppPreferences
import com.app.tigr.impl.AppPreferences
import dagger.Binds
import dagger.Module

@Module
interface AppModule {

    @Binds
    fun preferences(preferences: TigrAppPreferences): AppPreferences
}
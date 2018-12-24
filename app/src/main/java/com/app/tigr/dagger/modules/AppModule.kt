package com.app.tigr.dagger.modules

import com.app.tigr.data.repository.TigrAppPreferences
import com.app.tigr.impl.AppPreferences
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
interface AppModule {

    @Binds
    @Singleton
    fun preferences(preferences: TigrAppPreferences): AppPreferences
}
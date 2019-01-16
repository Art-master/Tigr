package com.app.tigr.dagger.modules

import android.content.Context
import com.app.tigr.data.repository.ChatDatabase
import com.app.tigr.data.repository.TigrAppPreferences
import com.app.tigr.impl.AppDatabase
import com.app.tigr.impl.AppPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
class AppModule {

    @Provides
    @Singleton
    fun preferences(context: Context): AppPreferences {
        return TigrAppPreferences(context)
    }

    @Singleton
    @Provides
    fun getAppDatabase(context: Context): AppDatabase {
        return ChatDatabase.getAppDataBase(context)!!
    }
}
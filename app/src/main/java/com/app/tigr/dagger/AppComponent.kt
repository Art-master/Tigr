package com.app.tigr.dagger

import android.content.Context
import com.app.tigr.dagger.modules.AppModule
import com.app.tigr.dagger.modules.ContextModule
import com.app.tigr.data.network.ApiProvider
import com.app.tigr.impl.AppNetwork
import com.app.tigr.impl.AppPreferences
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class, AppModule::class])
interface AppComponent {
    fun getContext(): Context
    fun getPreferences(): AppPreferences
    fun getNetworkConnection(): AppNetwork
    fun getApi(): ApiProvider
}
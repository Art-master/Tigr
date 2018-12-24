package com.app.tigr.dagger.modules

import com.app.tigr.data.network.ApiProvider
import com.app.tigr.data.network.RetrofitBuilder
import com.app.tigr.impl.AppNetwork
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    fun provideNetworkConnection(): AppNetwork{
        return RetrofitBuilder()
    }

    @Provides
    fun provideApi(): ApiProvider{
        return ApiProvider()
    }

}
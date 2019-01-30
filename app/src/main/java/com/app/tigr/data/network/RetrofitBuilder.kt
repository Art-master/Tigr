package com.app.tigr.data.network

import com.app.tigr.BuildConfig
import com.app.tigr.common.Constants
import com.app.tigr.impl.AppNetwork
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import io.reactivex.schedulers.Schedulers
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit


class RetrofitBuilder: AppNetwork {

    private var connection: Retrofit

    private val LOG_TAG = "NetworkLog"

    private val readTimeout = 30L to TimeUnit.SECONDS
    private val connectTimeout = 30L to TimeUnit.SECONDS

    init {
        connection = Retrofit.Builder()
                .baseUrl(Constants.Network.BASE_URL)
                .client(buildHttpClient())
                .addCallAdapterFactory(getRxAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    private fun buildHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
                .readTimeout(readTimeout.first, readTimeout.second)
                .connectTimeout(connectTimeout.first, connectTimeout.second)
                .addInterceptor(Interceptors.OfflineCacheInterceptor())
                //.addNetworkInterceptor(Interceptors.NetworkCacheInterceptor())
                .cache(Interceptors.provideCache())

        if (BuildConfig.DEBUG_MODE) {
            builder.addInterceptor(Interceptors.loggingInterceptor(LOG_TAG))
        }

        return builder.build()
    }

    private fun getRxAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())
    }

    override fun connect(): VkApi? {
        return connection.create(VkApi::class.java)
    }
}
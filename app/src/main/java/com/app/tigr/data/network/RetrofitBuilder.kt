package com.app.tigr.data.network

import com.app.tigr.BuildConfig
import com.app.tigr.common.Constants
import com.app.tigr.impl.AppNetwork
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.util.Log
import io.reactivex.schedulers.Schedulers
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory


class RetrofitBuilder: AppNetwork {
    private lateinit var connection: Retrofit

    private var loggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Log.d("OkHttp", message) })

    private lateinit var httpClient: OkHttpClient


    init {
        if(BuildConfig.DEBUG){
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
        httpClient = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

        connection = Retrofit.Builder()
        .baseUrl(Constants.Network.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    override fun connect(): VkApi? {
        return connection.create(VkApi::class.java)
    }
}
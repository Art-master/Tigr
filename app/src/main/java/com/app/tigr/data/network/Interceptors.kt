package com.app.tigr.data.network

import android.util.Log

import com.app.tigr.App
import com.app.tigr.common.TUtils

import java.io.File
import java.io.IOException
import java.util.concurrent.TimeUnit

import okhttp3.Cache
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor

object Interceptors {
    private const val MAX_AGE = 120
    private const val MAX_STALE: Long = 86400
    private const val MAX_FILE_SIZE = (10 * 1024 * 1024).toLong() //10 MB

    class OfflineCacheInterceptor : Interceptor {

        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            var request = chain.request()

            if (!isNetAvailable()) {
                request = request.newBuilder()
                        .header("Cache-Control", buildCashControl().toString())
                        .build()
            }
            return chain.proceed(request)
        }

        private fun buildCashControl(): CacheControl? {
            return CacheControl.Builder()
                    .maxStale(1, TimeUnit.DAYS)
                    .build()
        }
    }

    class NetworkCacheInterceptor : Interceptor {

        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val originalRequest = chain.request()
            val cacheHeaderValue = getCashHeader()
            val request = originalRequest.newBuilder().build()
            val response = chain.proceed(request)
            return response.newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    .header("Cache-Control", cacheHeaderValue)
                    .build()
        }

        private fun getCashHeader(): String {
            return if (isNetAvailable())
                "public, max-age=$MAX_AGE"
            else
                "public, only-if-cached, max-stale=$MAX_STALE"
        }
    }

    fun loggingInterceptor(tag: String): HttpLoggingInterceptor {
        return HttpLoggingInterceptor(getLogger(tag))
                .setLevel(HttpLoggingInterceptor.Level.HEADERS)
    }

    private fun getLogger(tag: String) = HttpLoggingInterceptor.Logger { message -> Log.d(tag, message) }

    fun provideCache(): Cache? {
        var cache: Cache? = null
        try {
            cache = Cache(createFile(), MAX_FILE_SIZE)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return cache
    }

    private fun createFile() = File(getCashDir(), "http-cache")

    private fun getCashDir() = App.appComponent.getContext().cacheDir

    private fun isNetAvailable() = TUtils.isNetworkAvailable()
}

package com.app.tigr.data.network

import com.app.tigr.domain.message.MsgResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface VkApi{
    @GET("method/messages.getConversations")
    fun getConversations(@Query("offset") offset: Int,
                         @Query("count") count: Int,
                         @Query("filter") filter: String,
                         @Query("extended") extended: Int,
                         @Query("lang") lang: Int,
                         @Query("test_mode") testMode: Int,
                         @Query("access_token") token: String,
                         @Query("v") versionApi: String): Single<MsgResponse>
}
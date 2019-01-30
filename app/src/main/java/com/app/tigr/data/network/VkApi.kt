package com.app.tigr.data.network

import com.app.tigr.domain.response.*
import io.reactivex.Single
import retrofit2.http.*

interface VkApi{
    @GET("method/messages.getConversations")
    fun getConversations(@Query("offset") offset: Int,
                         @Query("count") count: Int,
                         @Query("filter") filter: String,
                         @Query("extended") extended: Int,
                         @Query("lang") lang: Int,
                         @Query("test_mode") testMode: Int,
                         @Query("access_token") token: String,
                         @Query("v") versionApi: String): Single<ConversationsRsp>

    @GET("method/messages.getHistory")
    fun getDialog(@Query("offset") offset: Int,
                  @Query("count") count: Int,
                  @Query("user_id") userId: Int,
                  @Query("peer_id") peerId: Int,
                         //@Query("start_message_id") startMessageId: Int,
                  @Query("rev") rev: Int,
                  @Query("extended") extended: Int,
                         //@Query("group_id") groupId: Int,
                  @Query("lang") lang: Int,
                  @Query("test_mode") testMode: Int,
                  @Query("access_token") token: String,
                  @Query("v") versionApi: String): Single<DialogRsp>

    @GET("method/messages.send")
    fun sendMessage(@Query("user_id") userId: Int,
                    @Query("random_id") randomId: Int,
                    @Query("peer_id") peerId: Int,
/*                    @Query("domain") domain: String,
                    @Query("chat_id") chatId: Int,
                    @Query("user_ids") userIds: String,*/
                    @Query("message") message: String,
/*                    @Query("lat") lat: Float,
                    @Query("long") long: Float,
                    @Query("attachment") attachment: String,
                    @Query("reply_to") replyTo: Int,
                    @Query("forward_messages") forwardMessages: String,
                    @Query("sticker_id") stickerId: Int,
                    @Query("group_id") group_id: Int,
                    @Query("keyboard") keyboard: String,
                    @Query("payload") payload: Int,
                    @Query("dont_parse_links") dontParseLinks: Int,*/
                    @Query("lang") lang: Int,
                    @Query("test_mode") testMode: Int,
                    @Query("access_token") token: String,
                    @Query("v") versionApi: String): Single<MsgSendRsp>

    @GET("method/messages.getLongPollServer")
    fun getLongPoolServer(@Query("need_pts") needPts: Int,
                          @Query("group_id") groupId: Int,
                          @Query("lp_version") lpVersion: Int,
                          @Query("lang") lang: Int,
                          @Query("test_mode") testMode: Int,
                          @Query("access_token") token: String,
                          @Query("v") versionApi: String): Single<LongPollServerRsp>

    @GET
    fun initLongPoolServer(@Url url: String): Single<InitLongPollServerRsp>
}
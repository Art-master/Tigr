package com.app.tigr.domain.send

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Message(

        /** User ID to which the text is sent */
        @field:SerializedName("user_id")
        val userId: Int? = null,

        /** The specified random_id is used to verify the uniqueness of the text. */
        @field:SerializedName("random_id")
        val randomId: Int = Random().nextInt(Int.MAX_VALUE),

        /** Destination identifier (Users:id/ chat: 2000000000 + id/ group: -id) */
        @field:SerializedName("peer_id")
        val peerId: Int? = null,

        /** short address of the user (for example, illarionov) */
        @field:SerializedName("domain")
        val domain: String? = null,

        /** ID of the conversation to which the text will be related (max value 100 000 000) */
        @field:SerializedName("chat_id")
        val chatId: Int? = null,

        /** IDs of text recipients (if necessary, send a text to several users at once).
         *  Only available for community access key. (max ids is 100) */
        @field:SerializedName("user_ids")
        val userIds: List<Int?> = emptyList(),

        /** text of message */
        @field:SerializedName("text")
        var text: String = "",

        @field:SerializedName("latitude")
        val latitude: Float? = null,

        @field:SerializedName("longitude")
        val longitude: Float? = null,

        @field:SerializedName("attachments")
        val attachments: String? = null,

        @field:SerializedName("reply_to")
        val replyTo: Int? = null,

        /** Identifiers for forwarding messages, separated by commas */
        @field:SerializedName("forward_messages")
        val forwardMessages: String? = null,

        @field:SerializedName("sticker_id")
        val stickerId: Int? = null,

        @field:SerializedName("group_id")
        val groupId: Int? = null,

        /** Object describing the keyboard for the bot */
        @field:SerializedName("keyboard")
        val keyboard: String? = null, //Keyboard

        /** max = 1000 */
        @field:SerializedName("payload")
        val payload: Int? = null,

        /** 1 — не создавать сниппет ссылки из сообщения */
        @field:SerializedName("dont_parse_links")
        val dontParseLinks: Int? = null
): Parcelable
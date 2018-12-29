package com.app.tigr.domain.send

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Message(
        /** User ID to which the message is sent */
        val userId: Int? = null,

        /** The specified random_id is used to verify the uniqueness of the message. */
        val randomId: Int? = Random().nextInt(Int.MAX_VALUE),

        /** Destination identifier (Users:id/ chat: 2000000000 + id/ group: -id) */
        val peerId: Int? = null,

        /** short address of the user (for example, illarionov) */
        val domain: String? = null,

        /** ID of the conversation to which the message will be related (max value 100 000 000) */
        val chatId: Int? = null,

        /** IDs of message recipients (if necessary, send a message to several users at once).
         *  Only available for community access key. (max ids is 100) */
        val userIds: List<Int?> = emptyList(),

        /** text of message */
        var message: String? = null,

        val latitude: Float? = null,
        val longitude: Float? = null,

        val attachments: String? = null,

        val replyTo: Int? = null,

        /** Identifiers for forwarding messages, separated by commas */
        val forwardMessages: String? = null,

        val stickerId: Int? = null,
        val groupId: Int? = null,

        /** Object describing the keyboard for the bot */
        val keyboard: String? = null, //Keyboard

        /** max = 1000 */
        val payload: Int? = null,

        /** 1 — не создавать сниппет ссылки из сообщения */
        val dontParseLinks: Int? = null
): Parcelable
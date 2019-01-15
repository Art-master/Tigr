package com.app.tigr.domain.response.message

import android.os.Parcelable
import com.app.tigr.domain.response.common.CanWrite
import com.app.tigr.domain.response.common.Peer
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/** The object describes a conversation with a user, community or group chat */
@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class Conversation(

        /** information about the interlocutor */
        @field:SerializedName("peer")
        val peer: Peer? = null,

        /** ID of the last read incoming message */
        @field:SerializedName("in_read")
        val inRead: Int? = null,

        /** ID of the last read outgoing message */
        @field:SerializedName("out_read")
        val outRead: Int? = null,

        /** number of unread messages */
        @field:SerializedName("unread_count")
        val unreadCount: Int? = null,

        /** true, if the dialog is marked as important */
        @field:SerializedName("important")
        val important: Boolean? = null,

        /** true, if the dialog is marked as unanswered */
        @field:SerializedName("unanswered")
        val unanswered: Boolean? = null,

        /** push notification settings */
        @field:SerializedName("push_settings")
        val pushSettings: PushSettings? = null,

        /** whether the user can write to the dialogue */
        @field:SerializedName("can_write")
        val canWrite: CanWrite? = null,

        @field:SerializedName("chat_settings ")
        val chatSettings: ChatSettings? = null

) : Parcelable
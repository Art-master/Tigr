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
        val peer: Peer = Peer(),

        /** ID of the last read incoming text */
        @field:SerializedName("in_read")
        val inRead: Int = 0,

        /** ID of the last read outgoing text */
        @field:SerializedName("out_read")
        val outRead: Int = 0,

        /** number of unread messages */
        @field:SerializedName("unread_count")
        val unreadCount: Int = 0,

        /** true, if the dialog is marked as important */
        @field:SerializedName("important")
        val important: Boolean = false,

        /** true, if the dialog is marked as unanswered */
        @field:SerializedName("unanswered")
        val unanswered: Boolean = false,

        /** push notification settings */
        @field:SerializedName("push_settings")
        val pushSettings: PushSettings = PushSettings(),

        /** whether the user can write to the dialogue */
        @field:SerializedName("can_write")
        val canWrite: CanWrite = CanWrite(),

        @field:SerializedName("chat_settings ")
        val chatSettings: ChatSettings = ChatSettings()

) : Parcelable
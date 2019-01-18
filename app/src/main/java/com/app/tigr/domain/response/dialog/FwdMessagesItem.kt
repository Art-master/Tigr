package com.app.tigr.domain.response.dialog

import android.os.Parcelable
import com.app.tigr.domain.response.message.Attachment
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class FwdMessagesItem(

        @field:SerializedName("date")
        val date: Int = 0,

        @field:SerializedName("update_time")
        val updateTime: Int = 0,

        @field:SerializedName("from_id")
        val fromId: Int = 0,

        @field:SerializedName("attachments")
        val attachments: List<Attachment> = emptyList(),

        @field:SerializedName("fwd_messages")
        val fwdMessages: List<FwdMessagesItem> = emptyList(),

        @field:SerializedName("text")
        val text: String = "",

        @field:SerializedName("id")
        val id: Int = 0,

        @field:SerializedName("conversation_message_id")
        val conversationMessageId: Int = 0,

        @field:SerializedName("peer_id")
        val peerId: Int = 0
) : Parcelable
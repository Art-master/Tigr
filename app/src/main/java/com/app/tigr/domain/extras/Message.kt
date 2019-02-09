package com.app.tigr.domain.extras

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Message(

        @SerializedName(value = "message_id")
        val messageId: Int = 0,
        val flags: Int = 0,
        val mask: Int = 0,

        @SerializedName(value = "peer_id")
        val peerId: Int = 0,

        val timestamp: Int = 0,

        val text: String = "",

        val attachments: Map<String, String> = emptyMap()

) : Parcelable
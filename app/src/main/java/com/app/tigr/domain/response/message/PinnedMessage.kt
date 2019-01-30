package com.app.tigr.domain.response.message

import android.os.Parcelable
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class PinnedMessage(

        @field:SerializedName("id")
        val id: Int = 0,

        @field:SerializedName("date")
        val date: Int = 0,

        @field:SerializedName("from_id")
        val fromId: Int = 0,

        @field:SerializedName("text")
        val text: String = "",

        @field:SerializedName("attachments")
        val attachments: String = "",

        /** location information */
        @field:SerializedName("geo")
        val geo: Geo = Geo(),

        @field:SerializedName("fwd_messages")
        val fwdMessages: List<LastMessage> = emptyList()

) : Parcelable
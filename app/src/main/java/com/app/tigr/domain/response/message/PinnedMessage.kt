package com.app.tigr.domain.response.message

import android.os.Parcelable
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class PinnedMessage(

        @field:SerializedName("id")
        val id: Int? = null,

        @field:SerializedName("date")
        val date: Int? = null,

        @field:SerializedName("from_id")
        val fromId: Int? = null,

        @field:SerializedName("text")
        val text: String? = null,

        @field:SerializedName("attachments")
        val attachments: String? = null,

        /** location information */
        @field:SerializedName("geo")
        val geo: Geo? = null,

        @field:SerializedName("fwd_messages")
        val fwdMessages: List<LastMessage?>? = null

) : Parcelable
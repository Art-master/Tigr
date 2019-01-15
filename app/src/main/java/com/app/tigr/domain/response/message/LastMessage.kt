package com.app.tigr.domain.response.message

import android.os.Parcelable
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class LastMessage(

        @field:SerializedName("id")
        val id: Int? = null,

        @field:SerializedName("date")
        val date: Int? = null,

        @field:SerializedName("peer_id")
        val peerId: Int? = null,

        @field:SerializedName("from_id")
        val fromId: Int? = null,

        @field:SerializedName("text")
        val text: String? = null,

        @field:SerializedName("random_id")
        val randomId: Int? = null,

        /** arbitrary parameter for working with transition sources */
        @field:SerializedName("ref")
        val ref: String? = null,

        /** arbitrary parameter for working with transition sources */
        @field:SerializedName("ref_source")
        val ref_source: String? = null,

        @field:SerializedName("attachments")
        val attachments: List<Attachment?>? = null,

        @field:SerializedName("important")
        val important: Boolean? = null,

        @field:SerializedName("geo")
        val geo: Geo? = null,

        @field:SerializedName("payload")
        val payload: String? = null

        /** array of forwarded messages (if any). The maximum number of elements is 100.
         *  The maximum depth of nesting for sent messages is 45, the total maximum number in
         *  the chain, taking into account nesting, is 500. */
/*        @field:SerializedName("fwd_messages")
        val fwdMessages: List<LastMessage?>? = null,

        @field:SerializedName("reply_message")
        val reply_message: LastMessage? = null,

        @field:SerializedName("reply_message")
        val action: Action? = null*/

) : Parcelable
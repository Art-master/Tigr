package com.app.tigr.domain.response.message

import android.os.Parcelable
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * @see <a href=" https://vk.com/dev/objects/message">LastMessage in Vk API</a>
 */
@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class LastMessage(

        @field:SerializedName("id")
        val id: Int = 0,

        @field:SerializedName("date")
        val date: Int = 0,

        @field:SerializedName("peer_id")
        val peerId: Int = 0,

        @field:SerializedName("from_id")
        val fromId: Int = 0,

        @field:SerializedName("text")
        val text: String = "",

        @field:SerializedName("random_id")
        val randomId: Int = 0,

        /** arbitrary parameter for working with transition sources */
        @field:SerializedName("ref")
        val ref: String = "",

        /** arbitrary parameter for working with transition sources */
        @field:SerializedName("ref_source")
        val ref_source: String = "",

        @field:SerializedName("attachments")
        val attachments: List<Attachment> = emptyList(),

        @field:SerializedName("important")
        val important: Boolean = false,

        @field:SerializedName("geo")
        val geo: Geo = Geo(),

        @field:SerializedName("payload")
        val payload: String = ""

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
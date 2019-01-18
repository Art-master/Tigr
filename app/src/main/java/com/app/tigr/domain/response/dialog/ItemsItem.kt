package com.app.tigr.domain.response.dialog

import android.os.Parcelable
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class ItemsItem(

        @field:SerializedName("date")
        val date: Int = 0,

        @field:SerializedName("important")
        val important: Boolean = false,

        @field:SerializedName("from_id")
        val fromId: Int = 0,

        @field:SerializedName("attachments")
        val attachments: List<AttachmentsItem> = emptyList(),

        @field:SerializedName("is_hidden")
	val isHidden: Boolean? = null,

        @field:SerializedName("fwd_messages")
        val fwdMessages: List<FwdMessagesItem> = emptyList(),

        @field:SerializedName("id")
        val id: Int = 0,

        @field:SerializedName("text")
        val text: String = "",

        @field:SerializedName("random_id")
        val randomId: Int = 0,

        @field:SerializedName("out")
        val out: Int = 0,

        @field:SerializedName("peer_id")
        val peerId: Int = 0,

        @field:SerializedName("conversation_message_id")
        val conversationMessageId: Int = 0,

        @field:SerializedName("update_time")
        val updateTime: Int = 0
) : Parcelable {
	enum class Type(str:String){
		PHOTO("photo"),
		VIDEO("video"),
		AUDIO("audio"),
		DOC("doc"),
		LINK("link"),
		MARKET("market"),
		MARKET_ALBUM("market_album"),
		WALL("wall"),
		WALL_REPLY("wall_reply"),
		STICKER("sticker"),
		GIFT("gift")
	}
}
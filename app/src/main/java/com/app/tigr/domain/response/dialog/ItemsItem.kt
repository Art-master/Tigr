package com.app.tigr.domain.response.dialog

import android.os.Parcelable
import com.app.tigr.domain.response.common.ProfilesItem
import com.app.tigr.domain.response.message.Attachment
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class ItemsItem(

		@field:SerializedName("date")
		var date: Int = 0,

		@field:SerializedName("important")
        val important: Boolean = false,

		@field:SerializedName("from_id")
		var fromId: Int = 0,

		@field:SerializedName("attachments")
		val attachments: List<Attachment> = emptyList(),

		@field:SerializedName("is_hidden")
	val isHidden: Boolean? = null,

		@field:SerializedName("fwd_messages")
        val fwdMessages: List<FwdMessagesItem> = emptyList(),

		@field:SerializedName("id")
        val id: Int = 0,

		@field:SerializedName("text")
		var text: String = "",

		@field:SerializedName("random_id")
		var randomId: Int = 0,

		@field:SerializedName("out")
        val out: Int = 0,

		@field:SerializedName("peer_id")
		var peerId: Int = 0,

		@field:SerializedName("conversation_message_id")
        val conversationMessageId: Int = 0,

		@field:SerializedName("update_time")
		val updateTime: Int = 0,

		//doubled
		var profiles: List<ProfilesItem> = emptyList(),
		var conversations: List<ConversationsItem> = emptyList()
) : Parcelable
package com.app.tigr.domain.response.dialog

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class FwdMessagesItem(

	@field:SerializedName("date")
	val date: Int? = null,

	@field:SerializedName("update_time")
	val updateTime: Int? = null,

	@field:SerializedName("from_id")
	val fromId: Int? = null,

	@field:SerializedName("attachments")
	val attachments: List<Any?>? = null,

	@field:SerializedName("fwd_messages")
	val fwdMessages: List<FwdMessagesItem?>? = null,

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("conversation_message_id")
	val conversationMessageId: Int? = null,

	@field:SerializedName("peer_id")
	val peerId: Int? = null
)
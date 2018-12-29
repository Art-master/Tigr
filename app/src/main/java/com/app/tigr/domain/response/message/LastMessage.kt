package com.app.tigr.domain.response.message

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class LastMessage(

	@field:SerializedName("date")
	val date: Int? = null,

	@field:SerializedName("important")
	val important: Boolean? = null,

	@field:SerializedName("from_id")
	val fromId: Int? = null,

	@field:SerializedName("attachments")
	val attachments: List<Any?>? = null,

	@field:SerializedName("is_hidden")
	val isHidden: Boolean? = null,

	@field:SerializedName("fwd_messages")
	val fwdMessages: List<Any?>? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("random_id")
	val randomId: Int? = null,

	@field:SerializedName("out")
	val out: Int? = null,

	@field:SerializedName("peer_id")
	val peerId: Int? = null,

	@field:SerializedName("conversation_message_id")
	val conversationMessageId: Int? = null,

	@field:SerializedName("keyboard")
	val keyboard: Keyboard? = null
)
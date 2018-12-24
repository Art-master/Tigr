package com.app.tigr.domain.message

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Conversation(

	@field:SerializedName("last_message_id")
	val lastMessageId: Int? = null,

	@field:SerializedName("in_read")
	val inRead: Int? = null,

	@field:SerializedName("can_write")
	val canWrite: CanWrite? = null,

	@field:SerializedName("peer")
	val peer: Peer? = null,

	@field:SerializedName("out_read")
	val outRead: Int? = null,

	@field:SerializedName("current_keyboard")
	val currentKeyboard: CurrentKeyboard? = null,

	@field:SerializedName("unread_count")
	val unreadCount: Int? = null
)
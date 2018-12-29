package com.app.tigr.domain.response.dialog

import com.app.tigr.domain.response.common.CanWrite
import com.app.tigr.domain.response.common.Peer
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class ConversationsItem(

        @field:SerializedName("last_message_id")
	val lastMessageId: Int? = null,

        @field:SerializedName("in_read")
	val inRead: Int? = null,

        @field:SerializedName("can_write")
	val canWrite: CanWrite? = null,

        @field:SerializedName("peer")
	val peer: Peer? = null,

        @field:SerializedName("out_read")
	val outRead: Int? = null
)
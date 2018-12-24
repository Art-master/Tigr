package com.app.tigr.domain.message

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class ItemsItem(

	@field:SerializedName("last_message")
	val lastMessage: LastMessage? = null,

	@field:SerializedName("conversation")
	val conversation: Conversation? = null
)
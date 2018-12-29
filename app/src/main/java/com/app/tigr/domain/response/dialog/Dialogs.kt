package com.app.tigr.domain.response.dialog

import com.app.tigr.domain.response.common.ProfilesItem
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Dialogs(

        @field:SerializedName("count")
	val count: Int? = null,

        @field:SerializedName("profiles")
	val profiles: List<ProfilesItem?>? = null,

        @field:SerializedName("items")
	val items: List<ItemsItem?>? = null,

        @field:SerializedName("conversations")
	val conversations: List<ConversationsItem?>? = null
)
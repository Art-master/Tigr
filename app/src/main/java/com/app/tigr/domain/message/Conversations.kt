package com.app.tigr.domain.message

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Conversations(

	@field:SerializedName("unread_count")
	val unreadCount: Int? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("profiles")
	val profiles: List<ProfilesItem?>? = null,

	@field:SerializedName("groups")
	val groups: List<GroupsItem?>? = null,

	@field:SerializedName("items")
	val items: List<ItemsItem?>? = null
)
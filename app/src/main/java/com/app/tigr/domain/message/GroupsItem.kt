package com.app.tigr.domain.message

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class GroupsItem(

	@field:SerializedName("is_admin")
	val isAdmin: Int? = null,

	@field:SerializedName("is_member")
	val isMember: Int? = null,

	@field:SerializedName("photo_50")
	val photo50: String? = null,

	@field:SerializedName("screen_name")
	val screenName: String? = null,

	@field:SerializedName("is_advertiser")
	val isAdvertiser: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("photo_100")
	val photo100: String? = null,

	@field:SerializedName("photo_200")
	val photo200: String? = null,

	@field:SerializedName("is_closed")
	val isClosed: Int? = null
)
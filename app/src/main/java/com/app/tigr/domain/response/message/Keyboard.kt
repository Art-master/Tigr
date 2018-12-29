package com.app.tigr.domain.response.message

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Keyboard(

	@field:SerializedName("buttons")
	val buttons: List<List<ButtonsItemItem?>?>? = null,

	@field:SerializedName("one_time")
	val oneTime: Boolean? = null,

	@field:SerializedName("author_id")
	val authorId: Int? = null
)
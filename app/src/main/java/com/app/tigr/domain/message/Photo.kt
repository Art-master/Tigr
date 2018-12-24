package com.app.tigr.domain.message

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Photo(

	@field:SerializedName("date")
	val date: Int? = null,

	@field:SerializedName("sizes")
	val sizes: List<SizesItem?>? = null,

	@field:SerializedName("owner_id")
	val ownerId: Int? = null,

	@field:SerializedName("album_id")
	val albumId: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("text")
	val text: String? = null
)
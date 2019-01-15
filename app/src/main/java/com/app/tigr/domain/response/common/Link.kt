package com.app.tigr.domain.response.common

import com.app.tigr.domain.response.attachments.Photo
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Link(

        @field:SerializedName("is_favorite")
	val isFavorite: Boolean? = null,

        @field:SerializedName("caption")
	val caption: String? = null,

        @field:SerializedName("description")
	val description: String? = null,

        @field:SerializedName("photo")
	val photo: Photo? = null,

        @field:SerializedName("title")
	val title: String? = null,

        @field:SerializedName("url")
	val url: String? = null
)
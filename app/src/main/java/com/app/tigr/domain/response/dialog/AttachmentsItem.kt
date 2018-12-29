package com.app.tigr.domain.response.dialog

import com.app.tigr.domain.response.common.Photo
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class AttachmentsItem(

        @field:SerializedName("photo")
	val photo: Photo? = null,

        @field:SerializedName("type")
	val type: String? = null
)
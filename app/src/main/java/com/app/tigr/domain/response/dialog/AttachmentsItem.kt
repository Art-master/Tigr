package com.app.tigr.domain.response.dialog

import android.os.Parcelable
import com.app.tigr.domain.response.attachments.Photo
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class AttachmentsItem(

        @field:SerializedName("photo")
	val photo: Photo? = null,

        @field:SerializedName("type")
	val type: String? = null
) : Parcelable
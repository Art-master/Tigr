package com.app.tigr.domain.response.attachments.sticker

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class ImageSticker(

        @field:SerializedName("url")
        val url: String? = null,

        @field:SerializedName("width")
        val width: Int? = null,

        @field:SerializedName("height")
        val height: Int? = null

) : Parcelable

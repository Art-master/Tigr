package com.app.tigr.domain.response.attachments.doc

import android.os.Parcelable
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class PhotoPreview(

        @field:SerializedName("src")
        val src: String? = null,

        @field:SerializedName("width")
        val width: Int? = null,

        @field:SerializedName("height")
        val height: Int? = null,

        @field:SerializedName("type")
        val type: String? = null

) : Parcelable
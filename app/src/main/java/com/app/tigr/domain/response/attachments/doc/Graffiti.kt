package com.app.tigr.domain.response.attachments.doc

import android.os.Parcelable
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class Graffiti(

        /** URL graffiti */
        @field:SerializedName("src")
        val src: String? = null,

        /** px image width */
        @field:SerializedName("width")
        val width: Int? = null,

        /** px image height */
        @field:SerializedName("height")
        val height: Int? = null

) : Parcelable
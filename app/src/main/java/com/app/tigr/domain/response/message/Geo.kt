package com.app.tigr.domain.response.message

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import javax.annotation.Generated

/** location information */
@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class Geo(

        /** type of place */
        @field:SerializedName("type")
        val type: String? = null,

        @field:SerializedName("coordinates")
        val coordinates: String? = null,

        @field:SerializedName("place")
        val place: Place? = null

) : Parcelable

package com.app.tigr.domain.response.message

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import javax.annotation.Generated

/** description of place */
@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class Place(

        @field:SerializedName("id")
        val id: Int? = null,

        @field:SerializedName("title")
        val title: String? = null,

        @field:SerializedName("latitude")
        val latitude: Float? = null,

        @field:SerializedName("longitude")
        val longitude: Float? = null,

        /** date of creation */
        @field:SerializedName("created")
        val created: Int? = null,

        @field:SerializedName("icon")
        val urlIcon: String? = null,

        @field:SerializedName("country")
        val country: String? = null,

        @field:SerializedName("city")
        val city: String? = null
) : Parcelable

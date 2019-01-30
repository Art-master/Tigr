package com.app.tigr.domain.response.message

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import javax.annotation.Generated

/** description of place
 *
 * @see <a href=" https://vk.com/dev/objects/message">LastMessage in Vk API</a>
 */

@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class Place(

        @field:SerializedName("id")
        val id: Int = 0,

        @field:SerializedName("title")
        val title: String = "",

        @field:SerializedName("latitude")
        val latitude: Float = 0F,

        @field:SerializedName("longitude")
        val longitude: Float = 0F,

        /** date of creation */
        @field:SerializedName("created")
        val created: Int = 0,

        @field:SerializedName("icon")
        val urlIcon: String = "",

        @field:SerializedName("country")
        val country: String = "",

        @field:SerializedName("city")
        val city: String = ""
) : Parcelable

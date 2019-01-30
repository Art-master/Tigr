package com.app.tigr.domain.response.message

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import javax.annotation.Generated

/** location information
 * @see <a href=" https://vk.com/dev/objects/message">Geo in Vk API</a>
 */
@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class Geo(

        /** type of place */
        @field:SerializedName("type")
        val type: String = "",

        @field:SerializedName("coordinates")
        val coordinates: String = "",

        @field:SerializedName("place")
        val place: Place = Place()

) : Parcelable

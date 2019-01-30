package com.app.tigr.domain.response.message

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class Photo(

        /** URL of image 50x50px */
        @field:SerializedName("photo_50")
        val photo50: String = "",

        /** URL of image 100x100px */
        @field:SerializedName("photo_100")
        val photo100: String = "",

        /** URL of image 200x200px */
        @field:SerializedName("photo_200")
        val photo200: String = ""
) : Parcelable
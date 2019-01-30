package com.app.tigr.domain.response.common

import android.os.Parcelable
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 *
 */
@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class ProfilesItem(

        @field:SerializedName("can_access_closed")
        val canAccessClosed: Boolean = false,

        @field:SerializedName("photo_50")
        val photo50: String = "",

        @field:SerializedName("screen_name")
        val screenName: String = "",

        @field:SerializedName("sex")
        val sex: Int = 0,

        @field:SerializedName("last_name")
        val lastName: String = "",

        @field:SerializedName("online")
        val online: Int = 0,

        @field:SerializedName("id")
        val id: Int = 0,

        @field:SerializedName("photo_100")
        val photo100: String = "",

        @field:SerializedName("first_name")
        val firstName: String = "",

        @field:SerializedName("is_closed")
        val isClosed: Boolean = false
) : Parcelable
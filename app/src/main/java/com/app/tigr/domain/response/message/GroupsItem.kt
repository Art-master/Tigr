package com.app.tigr.domain.response.message

import android.os.Parcelable
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class GroupsItem(

        @field:SerializedName("is_admin")
        val isAdmin: Int = 0,

        @field:SerializedName("is_member")
        val isMember: Int = 0,

        @field:SerializedName("photo_50")
        val photo50: String = "",

        @field:SerializedName("screen_name")
        val screenName: String = "",

        @field:SerializedName("is_advertiser")
        val isAdvertiser: Int = 0,

        @field:SerializedName("name")
        val name: String = "",

        @field:SerializedName("id")
        val id: Int = 0,

        @field:SerializedName("type")
        val type: String = "",

        @field:SerializedName("photo_100")
        val photo100: String = "",

        @field:SerializedName("photo_200")
        val photo200: String = "",

        @field:SerializedName("is_closed")
        val isClosed: Int = 0
) : Parcelable
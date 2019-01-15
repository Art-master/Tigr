package com.app.tigr.domain.response.message

import android.os.Parcelable
import com.app.tigr.domain.response.common.ProfilesItem
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/** list of user conversations */
@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class Conversations(

        /** number of unread conversations */
        @field:SerializedName("unread_count")
        val unreadCount: Int? = null,

        /** number of results */
        @field:SerializedName("count")
        val count: Int? = null,

        /** array of user objects */
        @field:SerializedName("profiles")
        val profiles: List<ProfilesItem?>? = null,

        /** array of user groups */
        @field:SerializedName("groups")
        val groups: List<GroupsItem?>? = null,

        /** conversations */
        @field:SerializedName("items")
        val items: List<ItemsItem?>? = null
) : Parcelable
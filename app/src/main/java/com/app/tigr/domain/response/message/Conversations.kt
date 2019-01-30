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
        val unreadCount: Int = 0,

        /** number of results */
        @field:SerializedName("count")
        val count: Int = 0,

        /** array of user objects */
        @field:SerializedName("profiles")
        val profiles: List<ProfilesItem> = emptyList(),

        /** array of user groups */
        @field:SerializedName("groups")
        val groups: List<GroupsItem> = emptyList(),

        /** conversations */
        @field:SerializedName("items")
        val items: List<ItemsItem> = emptyList()
) : Parcelable
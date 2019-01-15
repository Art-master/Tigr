package com.app.tigr.domain.response.dialog

import android.os.Parcelable
import com.app.tigr.domain.response.common.ProfilesItem
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class Dialogs(

        /** number of results */
        @field:SerializedName("count")
        val count: Int? = null,

        /** conversations */
        @field:SerializedName("items")
        val items: List<ItemsItem?>? = null,

        /** array of user objects */
        @field:SerializedName("profiles")
        val profiles: List<ProfilesItem?>? = null,

        @field:SerializedName("conversations")
        val conversations: List<ConversationsItem?>? = null
) : Parcelable
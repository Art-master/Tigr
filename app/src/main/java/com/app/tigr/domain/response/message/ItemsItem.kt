package com.app.tigr.domain.response.message

import android.os.Parcelable
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/** */
@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class ItemsItem(

        @field:SerializedName("last_message")
        val lastMessage: LastMessage = LastMessage(),

        @field:SerializedName("conversation")
        val conversation: Conversation = Conversation()
) : Parcelable
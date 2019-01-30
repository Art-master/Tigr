package com.app.tigr.domain.response.message

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class ChatSettings(

        @field:SerializedName("members_count")
        val membersCount: Int = 0,

        @field:SerializedName("title")
        val title: String = "",

        @field:SerializedName("pinned_message")
        val pinnedMessage: PinnedMessage = PinnedMessage(),

        /** status of user:
         * in — is chatting;
         * kicked — excluded from chat;
         * isAvatar — isAvatar чат */
        @field:SerializedName("state")
        val state: String = "",

        /** image cover chat */
        @field:SerializedName("photo")
        val photo: Photo = Photo(),

        /** IDs of the last users what wrote to chat */
        @field:SerializedName("active_ids")
        val activeIds: List<Int> = emptyList(),

        /** whether the conversation is a community channel */
        @field:SerializedName("is_group_channel")
        val isGroupChannel: Boolean = false
) : Parcelable

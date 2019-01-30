package com.app.tigr.domain.params

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DialogParam(
        @field:SerializedName("offset")
        val offset: Int = 0,

        @field:SerializedName("count")
        val count: Int = 0,

        @field:SerializedName("user_id")
        val userId: Int = 0,

        @field:SerializedName("peer_id")
        val peerId: Int = 0,

        @field:SerializedName("start_message_id")
        val startMessageId: Int? = null,

        @field:SerializedName("rev")
        val rev: Int = 0,

        @field:SerializedName("extended")
        val extended: Int = 0,

        @field:SerializedName("group_id")
        val groupId: Int? = null
) : Parcelable
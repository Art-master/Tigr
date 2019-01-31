package com.app.tigr.domain.params

import android.os.Parcelable
import com.app.tigr.common.Constants
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LongPollServerPrm(

        /** 1 - return the pts field required for the method to work */
        @field:SerializedName("need_pts")
        val needPts: Int = 1, // 1 -  yes , 0 - no

        /** community identifier (for community messages with user access key) */
        @field:SerializedName("group_id")
        val groupId: String = "",

        /** version to connect to Long Poll */
        @field:SerializedName("lp_version")
        val lpVersion: Int = Constants.Network.LONG_POLL_VERSION
) : Parcelable
package com.app.tigr.domain.params

import android.os.Parcelable
import com.app.tigr.common.Constants
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class InitLongPollServerPrm(
        /** session secret key */
        @field:SerializedName("key")
        var key: String = "",

        /** server address */
        @field:SerializedName("server")
        var server: String = "",

        /** the number of the last event from which you want to receive data */
        @field:SerializedName("ts")
        var ts: Int = 0,

        /** waiting time (sec.)
         * Recommended: 25
         * Max: 90
         */
        @field:SerializedName("wait")
        val wait: Int = 25,

        /** additional answer options. Sum of option codes from the [Mode] */
        @field:SerializedName("mode")
        val mode: Int = 0,

        /** version to connect to Long Poll */
        @field:SerializedName("version")
        val version: Int = Constants.Network.LONG_POLL_VERSION
) : Parcelable {

    enum class Mode(val value: Int) {
        ATTACHMENTS(2),
        EXTENDED_EVENTS(8),
        PTS(32),
        EXTENDED_EVENTS_EXTRA(64),
        RANDOM_ID(128),
        ALL(ATTACHMENTS.value + EXTENDED_EVENTS.value + PTS.value + EXTENDED_EVENTS_EXTRA.value + RANDOM_ID.value)
    }
}
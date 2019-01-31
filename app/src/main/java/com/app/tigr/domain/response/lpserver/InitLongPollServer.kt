package com.app.tigr.domain.response.lpserver

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import javax.annotation.Generated

@Parcelize
@Generated("com.robohorse.robopojogenerator")
data class InitLongPollServer(

        /** last event number */
        @field:SerializedName("ts")
        val ts: Int = 0,

        /** necessary for the messages.getLongPollHistory method to work */
        @field:SerializedName("pts")
        val pts: Int = 0,

        /** an array whose elements contain the representation of new events */
        @field:SerializedName("updates")
        val updates: List<List<String>> = emptyList(),

        /** necessary for the messages.getLongPollHistory method to work */
        @field:SerializedName("failed")
        val failed: String = ""
) : Parcelable
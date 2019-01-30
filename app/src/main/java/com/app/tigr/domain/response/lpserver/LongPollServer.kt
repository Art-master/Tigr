package com.app.tigr.domain.response.lpserver

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import javax.annotation.Generated

@Parcelize
@Generated("com.robohorse.robopojogenerator")
data class LongPollServer(

        /** session secret key */
        @field:SerializedName("key")
        val key: String = "",

        /** server address */
        @field:SerializedName("server")
        val server: String = "",

        /** the number of the last event from which you want to receive data */
        @field:SerializedName("ts")
        val ts: Int = 0
) : Parcelable
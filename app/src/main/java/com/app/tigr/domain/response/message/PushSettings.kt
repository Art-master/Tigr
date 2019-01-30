package com.app.tigr.domain.response.message

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import javax.annotation.Generated

/** push notification settings */
@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class PushSettings(

        /** timestamp before which alerts are disabled */
        @field:SerializedName("disabled_until")
        val disabledUntil: Int = 0,

        @field:SerializedName("disabled_forever")
        val disabledForever: Boolean = false,

        @field:SerializedName("no_sound")
        val noSound: Boolean = false

) : Parcelable

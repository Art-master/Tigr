package com.app.tigr.domain.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MsgSendRsp(
        @field:SerializedName("response")
        val response: Int? = null
) : Parcelable

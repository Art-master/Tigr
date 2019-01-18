package com.app.tigr.domain.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseMsgSend(
        val response: Int = 0
) : Parcelable

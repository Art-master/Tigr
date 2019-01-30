package com.app.tigr.domain.response

import android.os.Parcelable
import com.app.tigr.domain.response.lpserver.LongPollServer
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import javax.annotation.Generated

@Parcelize
@Generated("com.robohorse.robopojogenerator")
data class LongPollServerRsp(

        @field:SerializedName("response")
        val response: LongPollServer = LongPollServer()

) : Parcelable

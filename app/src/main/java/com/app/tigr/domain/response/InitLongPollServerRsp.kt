package com.app.tigr.domain.response

import android.os.Parcelable
import com.app.tigr.domain.response.lpserver.InitLongPollServer
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import javax.annotation.Generated

@Parcelize
@Generated("com.robohorse.robopojogenerator")
data class InitLongPollServerRsp(

        @field:SerializedName("response")
        val response: InitLongPollServer = InitLongPollServer()
) : Parcelable

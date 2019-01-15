package com.app.tigr.domain.response.attachments.link

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class Button(

        @field:SerializedName("title")
        val title: String? = null,

        @field:SerializedName("action")
        val action: Action? = null
) : Parcelable

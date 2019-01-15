package com.app.tigr.domain.response.attachments.link

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class Action(

        /** type of action.
         *
         *  Possible values:
         *      open_url - open the address from the url field; */
        @field:SerializedName("type")
        val type: String? = null,

        @field:SerializedName("url")
        val url: String? = null
) : Parcelable

package com.app.tigr.domain.response.attachments.link

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class Currency(

        @field:SerializedName("id")
        val id: Int? = null,

        @field:SerializedName("name")
        val name: String? = null

) : Parcelable

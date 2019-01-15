package com.app.tigr.domain.response.attachments.link

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class Price(

        @field:SerializedName("amount")
        val amount: Int? = null,

        @field:SerializedName("currency")
        val currency: Currency? = null,

        @field:SerializedName("text")
        val text: String? = null

) : Parcelable

package com.app.tigr.domain.response.attachments

import android.os.Parcelable
import com.app.tigr.domain.response.attachments.sticker.ImageSticker
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class Sticker(

        /** set identifier */
        @field:SerializedName("product_id")
        val productId: Int = 0,

        @field:SerializedName("sticker_id")
        val stickerId: Int = 0,

        @field:SerializedName("images")
        val images: List<ImageSticker> = emptyList(),

        @field:SerializedName("images_with_background")
        val imagesWithBackground: List<ImageSticker> = emptyList()

) : Parcelable


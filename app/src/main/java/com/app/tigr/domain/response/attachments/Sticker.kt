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
        val productId: Int? = null,

        @field:SerializedName("sticker_id")
        val stickerId: Int? = null,

        @field:SerializedName("images")
        val images: List<ImageSticker?>? = null,

        @field:SerializedName("images_with_background")
        val imagesWithBackground: List<ImageSticker?>? = null

) : Parcelable


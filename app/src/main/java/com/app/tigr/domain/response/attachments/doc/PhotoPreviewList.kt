package com.app.tigr.domain.response.attachments.doc

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import javax.annotation.Generated


@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class PhotoPreviewList(

        @field:SerializedName("sizes")
        val sizes: List<PhotoPreview>? = null

) : Parcelable

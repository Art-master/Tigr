package com.app.tigr.domain.response.attachments.doc

import android.os.Parcelable
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class Preview(

        @field:SerializedName("photo")
        val photo: PhotoPreviewList? = null,

        @field:SerializedName("graffiti")
        val graffiti: Graffiti? = null,

        @field:SerializedName("audio_message")
        val audioMessage: AudioMessage? = null

) : Parcelable
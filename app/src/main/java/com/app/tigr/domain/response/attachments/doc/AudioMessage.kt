package com.app.tigr.domain.response.attachments.doc

import android.os.Parcelable
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class AudioMessage(

        /** clip audio in seconds */
        @field:SerializedName("duration")
        val duration: Int? = null,

        @field:SerializedName("waveform")
        val waveform: List<Int?>? = null,

        @field:SerializedName("link_ogg")
        val linkOgg: String? = null,

        @field:SerializedName("link_mp3")
        val linkMp3: String? = null

) : Parcelable
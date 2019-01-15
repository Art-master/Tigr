package com.app.tigr.domain.response.attachments

import android.os.Parcelable
import com.app.tigr.domain.response.attachments.doc.Preview
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class Document(

        @field:SerializedName("id")
        val id: Int? = null,

        /** doc owner ID */
        @field:SerializedName("owner_id")
        val ownerId: Int? = null,

        @field:SerializedName("title")
        val title: String? = null,

        /** document size in bytes */
        @field:SerializedName("size")
        val size: Int? = null,

        /** document extension */
        @field:SerializedName("ext")
        val ext: String? = null,

        /** document URL */
        @field:SerializedName("url")
        val url: String? = null,

        /** date in Unixtime */
        @field:SerializedName("date")
        val date: Int? = null,

        /** type doc as [Type] */
        @field:SerializedName("type")
        val type: Int? = null,

        @field:SerializedName("preview")
        val preview: Preview? = null,

        @field:SerializedName("access_key")
        val accessKey: String? = null

) : Parcelable {
    enum class Type constructor(id: Int) {
        TEXT(1),
        ARCHIVE(2),
        GIF(3),
        IMAGE(4),
        AUDIO(5),
        VIDEO(6),
        E_BOOK(7),
        UNKNOWN(8)
    }
}
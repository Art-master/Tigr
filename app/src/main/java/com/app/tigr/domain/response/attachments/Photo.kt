package com.app.tigr.domain.response.attachments

import android.os.Parcelable
import com.app.tigr.domain.response.common.SizesItem
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class Photo(

        @field:SerializedName("id")
        val id: Int = 0,

        /** ID of the album in which the photo is located */
        @field:SerializedName("album_id")
        val albumId: Int = 0,

        /** photo owner ID */
        @field:SerializedName("owner_id")
        val ownerId: Int = 0,

        /** ID of the user who uploaded the photo (if the photo is posted in the community).
         *  For photos posted on behalf of the community, user_id = 100.
         *  */
        @field:SerializedName("user_id")
        val userId: Int = 0,

        /** description photo */
        @field:SerializedName("text")
        val text: String = "",

        /** date added in Unixtime  */
        @field:SerializedName("date")
        val date: Int = 0,

        /** an array with copies of the image in different sizes */
        @field:SerializedName("sizes")
        val sizes: List<SizesItem> = emptyList(),

        /** description photo */
        @field:SerializedName("width")
        val width: Int = 0,

        @field:SerializedName("height")
        val height: Int = 0,

        /** access key to content */
        @field:SerializedName("access_key")
        val accessKey: String = ""

) : Parcelable
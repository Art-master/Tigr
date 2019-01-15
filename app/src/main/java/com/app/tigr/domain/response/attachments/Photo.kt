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
        val id: Int? = null,

        /** ID of the album in which the photo is located */
        @field:SerializedName("album_id")
        val albumId: Int? = null,

        /** photo owner ID */
        @field:SerializedName("owner_id")
        val ownerId: Int? = null,

        /** ID of the user who uploaded the photo (if the photo is posted in the community).
         *  For photos posted on behalf of the community, user_id = 100.
         *  */
        @field:SerializedName("user_id")
        val userId: Int? = null,

        /** description photo */
        @field:SerializedName("text")
        val text: String? = null,

        /** date added in Unixtime  */
        @field:SerializedName("date")
        val date: Int? = null,

        /** an array with copies of the image in different sizes */
        @field:SerializedName("sizes")
        val sizes: List<SizesItem?>? = null,

        /** description photo */
        @field:SerializedName("width")
        val width: Int? = null,

        @field:SerializedName("height")
        val height: String? = null,

        /** access key to content */
        @field:SerializedName("access_key")
        val accessKey: String? = null

) : Parcelable
package com.app.tigr.domain.response.attachments

import android.os.Parcelable
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class Video(

        @field:SerializedName("id")
        val id: Int? = null,

        /** video owner ID */
        @field:SerializedName("owner_id")
        val ownerId: Int? = null,

        @field:SerializedName("title")
        val title: String? = null,

        @field:SerializedName("description")
        val description: String? = null,

        /** clip duration in seconds */
        @field:SerializedName("duration")
        val duration: Int? = null,

        /** 130 x 98 px Movie Cover Image URL */
        @field:SerializedName("photo_130")
        val photo130: String? = null,

        /** 320 x 240 px Movie Cover Image URL */
        @field:SerializedName("photo_320")
        val photo320: String? = null,

        /** 640 x 480 px Movie Cover Image URL (if exist) */
        @field:SerializedName("photo_640")
        val photo640: String? = null,

        /** 800 x 450 px Movie Cover Image URL (if exist) */
        @field:SerializedName("photo_800")
        val photo800: String? = null,

        /** 1280 px (across the width) Movie Cover Image URL (if exist) */
        @field:SerializedName("photo_1280")
        val photo1280: String? = null,

        /** Image URL of the first frame of the movie with a size of 130x98 px */
        @field:SerializedName("first_frame_130")
        val firstFrame130: String? = null,

        /** Image URL of the first frame of the movie with a size of 320x240 px */
        @field:SerializedName("first_frame_320")
        val firstFrame320: String? = null,

        /** Image URL of the first frame of the movie with a size of 640x480 px (if exist)*/
        @field:SerializedName("first_frame_640")
        val firstFrame640: String? = null,

        /** Image URL of the first frame of the movie with a size of 800x450 px (if exist)*/
        @field:SerializedName("first_frame_800")
        val firstFrame800: String? = null,

        /** Image URL of the first frame of the movie with a size of 1280 px (if exist)*/
        @field:SerializedName("first_frame_1280")
        val firstFrame1280: String? = null,

        /** date in Unixtime */
        @field:SerializedName("date")
        val date: Int? = null,

        /** adding date in Unixtime */
        @field:SerializedName("adding_date")
        val adding_date: Int? = null,

        /** number of video views */
        @field:SerializedName("views")
        val views: Int? = null,

        /** number of comments*/
        @field:SerializedName("comments")
        val comments: Int? = null,

        /** The URL of the page with the player that can be used to play the movie in the browser.
         *  Flash and html5 are supported, the player is always scaled to fit the window */
        @field:SerializedName("player")
        val player: String? = null,

        /** platform name (for videos added from external sites)*/
        @field:SerializedName("platform")
        val platform: String? = null,

        /** the field is returned if the user can edit the video, always contains 1 */
        @field:SerializedName("can_edit")
        val canEdit: Int? = null,

        /** 1, if the user can add video to him */
        @field:SerializedName("can_add")
        val canAdd: Int? = null,

        /** the field is returned if the video is private, always contains 1 */
        @field:SerializedName("is_private")
        val isPrivate: Int? = null,

        /** access key to content */
        @field:SerializedName("access_key")
        val accessKey: String? = null,

        /** the field is returned if the video is in processing; it always contains 1 */
        @field:SerializedName("processing")
        val processing: Int? = null,

        /** the field is returned if the video is a live broadcast, always contains 1.
         *  Note that in this case the [duration] field contains the value 0 */
        @field:SerializedName("live")
        val live: Int? = null,

        /** (for live = 1). The field indicates that the broadcast will begin soon */
        @field:SerializedName("upcoming")
        val upcoming: Int? = null,

        /** true if the object is bookmarked by the current user */
        @field:SerializedName("is_favorite")
        val is_favorite: Boolean? = null

) : Parcelable
package com.app.tigr.domain.response.common

import android.os.Parcelable
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Copies of the image in different sizes
 */
@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class SizesItem(

        @field:SerializedName("width")
        val width: Int? = null,

        /** Designation of the size and proportions of the copy
         * Possible values of [type] field:
         *
         * s - proportional copy of the image with a maximum side of 75px;
         * m - proportional copy of the image with a maximum side of 130px;
         * x - proportional copy of the image with a maximum side 604px;
         * o - if the width / height ratio of the original image is less than or equal to 3: 2,
         * then a proportional copy with a maximum width of 130px. If the ratio "width / height" is greater
         * than 3: 2, then a copy of the cropped image with a maximum width of 130px and an aspect ratio of 3: 2.
         *
         * p - if the width / height ratio of the original image is less than or equal to 3: 2,
         * then a proportional copy with a maximum width of 200px. If the ratio of "width / height"
         * is more than 3: 2, then a copy of the image cropped left and right with a maximum width
         * of 200px and an aspect ratio of 3: 2.
         *
         * q - if the ratio "width / height" of the original image is less than or equal to 3: 2,
         * then a proportional copy with a maximum width of 320px. If the ratio of "width / height"
         * is more than 3: 2, then a copy of the image cropped left and right with a maximum width of
         * 320px and an aspect ratio of 3: 2.
         *
         * r - if the ratio "width / height" of the original image is less than or equal to 3: 2, then
         * a proportional copy with a maximum width of 510px. If the ratio "width / height" is more
         * than 3: 2, then a copy of the image cropped to the left and right with a maximum width
         * of 510px and an aspect ratio of 3: 2
         *
         * y - proportional copy of the image with a maximum side of 807px;
         * z - proportional copy of the image with a maximum size of 1080x1024;
         * w - proportional copy of the image with a maximum size of 2560x2048px.
         */
        @field:SerializedName("type")
        val type: String? = null,

        @field:SerializedName("url")
        val url: String? = null,

        @field:SerializedName("height")
        val height: Int? = null

) : Parcelable
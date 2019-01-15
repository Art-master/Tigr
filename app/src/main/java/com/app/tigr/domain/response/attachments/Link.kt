package com.app.tigr.domain.response.attachments

import android.os.Parcelable
import com.app.tigr.domain.response.attachments.link.Button
import com.app.tigr.domain.response.attachments.link.Product
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class Link(

        @field:SerializedName("url")
        val url: String? = null,

        @field:SerializedName("title")
        val title: String? = null,

        @field:SerializedName("caption")
        val caption: String? = null,

        @field:SerializedName("description")
        val description: String? = null,

        @field:SerializedName("photo")
        val photo: Photo? = null,

        /** The field is returned for references to stores, for example, Aliexpress */
        @field:SerializedName("product")
        val product: Product? = null,

        @field:SerializedName("button")
        val button: Button? = null,

        /** Wiki page ID with content for previewing the page content.
         *  Returned in the format "owner_id_page_id" */
        @field:SerializedName("preview_page")
        val previewPage: String? = null,

        /** URL of the page with content to preview the page content */
        @field:SerializedName("preview_url")
        val previewUrl: String? = null,

        /** access key to content */
        @field:SerializedName("access_key")
        val accessKey: String? = null

) : Parcelable
package com.app.tigr.domain.response.message

import android.os.Parcelable
import com.app.tigr.domain.response.attachments.*
import com.app.tigr.domain.response.attachments.Photo
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import javax.annotation.Generated

/** information about media attachments in private messages */
@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class Attachment(

        @field:SerializedName("type")
        val type: String = "",

        @field:SerializedName("photo")
        val photo: Photo = Photo(),

        @field:SerializedName("video")
        val video: Video? = null,

        @field:SerializedName("audio")
        val audio: Audio = Audio(),

        @field:SerializedName("doc")
        val doc: Document? = null,

        @field:SerializedName("link")
        val link: Link? = null,

/*        @field:SerializedName("market")
        val market: Market? = null,

        @field:SerializedName("market_album")
        val marketAlbum: MarketAlbum? = null,*/

/*        @field:SerializedName("wall")
        val wall: Wall? = null,*/

/*        @field:SerializedName("wall_reply")
        val wallReply: wallReply? = null,*/

        @field:SerializedName("sticker")
        val sticker: Sticker = Sticker()

/*        @field:SerializedName("gift")
        val gift: Gift? = null*/

) : Parcelable {
    enum class Type(val value: String) {
        PHOTO("photo"),
        VIDEO("video"),
        AUDIO("audio"),
        DOC("doc"),
        LINK("link"),
        MARKET("market"),
        MARKET_ALBUM("market_album"),
        WALL("wall"),
        WALL_REPLY("wall_reply"),
        STICKER("sticker"),
        GIFT("gift")
    }
}

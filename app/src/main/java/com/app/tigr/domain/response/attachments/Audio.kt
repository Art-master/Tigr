package com.app.tigr.domain.response.attachments

import android.os.Parcelable
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class Audio(

        @field:SerializedName("id")
        val id: Int? = null,

        /** audio owner ID */
        @field:SerializedName("owner_id")
        val ownerId: Int? = null,

        @field:SerializedName("artist")
        val artist: String? = null,

        @field:SerializedName("title")
        val title: String? = null,

        /** clip audio in seconds */
        @field:SerializedName("duration")
        val duration: Int? = null,

        /** links to mp3 */
        @field:SerializedName("url")
        val url: String? = null,

        /** audio text identifier (if available) */
        @field:SerializedName("lyrics_id")
        val lyricsId: Int? = null,

        /** ID of the album in which the audio recording is located (if assigned) */
        @field:SerializedName("album_id")
        val albumId: Int? = null,

        /** ID of the genre from [Genre] */
        @field:SerializedName("genre_id")
        val genreId: Int? = null,

        @field:SerializedName("date")
        val dateAdd: Int? = null,

        /** 1, if the option "Do not display when searching."
         *  If the option is disabled, the field is not returned. */
        @field:SerializedName("no_search")
        val noSearch: Int? = null,

        /** 1 if audio in high quality*/
        @field:SerializedName("is_hq")
        val isHq: Int? = null

) : Parcelable {
    enum class Genre constructor(id: Int) {
        ROCK(1),
        POP(2),
        RAP_AND_HIPHOP(3),
        EASY_LISTENING(4),
        HOUSE_AND_DANCE(5),
        INSTRUMENTAL(6),
        METAL(7),
        ALTERNATIVE(21),
        DUBSTEP(8),
        JAZZ_AND_BLUES(1001),
        DRUM_AND_BASS(10),
        TRANCE(11),
        CHANSON(12),
        ETHNIC(13),
        ACOUSTIC_AND_VOCAL(14),
        REGGAE(15),
        CLASSICAL(16),
        INDIE_POP(17),
        SPEECH(19),
        ELECTROPOP_AND_DISCO(22),
        OTHER(18)
    }
}
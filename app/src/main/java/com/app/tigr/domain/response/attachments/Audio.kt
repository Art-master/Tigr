package com.app.tigr.domain.response.attachments

import android.os.Parcelable
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class Audio(

        @field:SerializedName("id")
        val id: Int = 0,

        /** audio owner ID */
        @field:SerializedName("owner_id")
        val ownerId: Int = 0,

        @field:SerializedName("artist")
        val artist: String = "",

        @field:SerializedName("title")
        val title: String = "",

        /** clip audio in seconds */
        @field:SerializedName("duration")
        val duration: Int = 0,

        /** links to mp3 */
        @field:SerializedName("url")
        val url: String = "",

        /** audio text identifier (if available) */
        @field:SerializedName("lyrics_id")
        val lyricsId: Int = 0,

        /** ID of the album in which the audio recording is located (if assigned) */
        @field:SerializedName("album_id")
        val albumId: Int = 0,

        /** ID of the genre from [Genre] */
        @field:SerializedName("genre_id")
        val genreId: Int = 0,

        @field:SerializedName("date")
        val dateAdd: Int = 0,

        /** 1, if the option "Do not display when searching."
         *  If the option is disabled, the field is not returned. */
        @field:SerializedName("no_search")
        val noSearch: Int = 0,

        /** 1 if audio in high quality*/
        @field:SerializedName("is_hq")
        val isHq: Boolean = false,

        /** unique object id*/
        val uniqueId: String = Random().nextInt().toString()

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
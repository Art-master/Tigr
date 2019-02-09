package com.app.tigr.domain.response.lpserver

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue
import javax.annotation.Generated

@Parcelize
@Generated("com.robohorse.robopojogenerator")
data class InitLongPollServer(

        /** last event number */
        @field:SerializedName("ts")
        val ts: Int = 0,

        /** necessary for the messages.getLongPollHistory method to work */
        @field:SerializedName("pts")
        val pts: Int = 0,

        /** an array whose elements contain the representation of new events */
        @field:SerializedName("updates")
        val updates: List<List<@RawValue Any>> = emptyList(),

        /** necessary for the messages.getLongPollHistory method to work */
        @field:SerializedName("failed")
        val failed: String = ""
) : Parcelable {
    enum class Code(val num: Int) {
        CHANGE_FLAGS_MSG(1),
        SET_FLAGS_MSG(2),
        RESET_FLAGS_MSG(3),
        NEW_MSG(4),
        EDIT_MSG(5),
        READ_ALL_INPUT_MSG(6),
        READ_ALL_OUTPUT_MSG(7),
        FRIEND_ONLINE(8),
        FRIEND_OFFLINE(9),
        RESET_FLAGS_DIALOG(10),
        REPLACE_FLAGS_DIALOG(11),
        SET_FLAGS_DIALOG(12),
        DELETE_ALL_MSG_IN_DIALOG(13),
        RECOVER_MSG_IN_DIALOG(14),
        ONE_OF_PARAM_DIALOG_CHANGED(51),
        CHANGED_INFO_CHAT(52),
        USER_TYPE_MSG(61),
        USER_TYPE_CHAT(62),
        USER_HAS_CALL(70),
        COUNTER_IS(80),
        NOTIFICATIONS_SET_CHANGED(114)
    }
}
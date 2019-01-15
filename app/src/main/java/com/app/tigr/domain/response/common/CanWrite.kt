package com.app.tigr.domain.response.common

import android.os.Parcelable
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * An information about whether the user can write to the dialogue.
 */
@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class CanWrite(

        /** true, if user can write into dialogue */
        @field:SerializedName("allowed")
        val allowed: Boolean? = null,

        /** if field [allowed] is false, then one of [Error] */
        @field:SerializedName("reason")
        val reason: Int? = null

) : Parcelable {
    enum class Error constructor(code: Int) {
        USER_BLOCKED_OR_DELETE(18),
        USER_IN_BLACK_LIST(900),
        USER_FORBIDDEN_MSG_FROM_GROUPS(901),
        USER_FORBIDDEN_MSG(902),
        IN_THE_GROUP_OFF_SMG(915),
        IN_THE_GROUP_BLOCKED_SMG(916),
        NOT_ACCESS_TO_CHAT(917),
        NOT_ACCESS_TO_EMAIL(918),
        NOT_ACCESS_TO_GROUP(203)
    }
}

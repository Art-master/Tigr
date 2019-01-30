package com.app.tigr.domain.params

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ConversationsParam(
        @field:SerializedName("offset")
        val offset: Int = 0,

        @field:SerializedName("count")
        val count: Int = MAX_COUNT,

        @field:SerializedName("filter")
        val filter: String = Filter.ALL.value,

        @field:SerializedName("extended")
        val extended: Int = 0,

        @field:SerializedName("fields")
        val fields: String = ""

) : Parcelable {
    companion object {
        const val MAX_COUNT = 200
    }

    enum class Filter(val value: String) {
        ALL("all")
    }
}
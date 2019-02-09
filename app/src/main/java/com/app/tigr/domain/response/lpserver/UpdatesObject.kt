package com.app.tigr.domain.response.lpserver

import android.os.Parcelable
import com.google.gson.internal.LinkedTreeMap
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UpdatesObject(

        val value: String = "",

        val updates: Map<String, String> = emptyMap()
) : Parcelable
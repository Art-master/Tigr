package com.app.tigr.domain.response.message

import android.os.Parcelable
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class ButtonsItemItem(

	@field:SerializedName("color")
	val color: String? = null,

	@field:SerializedName("action")
	val action: Action? = null
) : Parcelable
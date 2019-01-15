package com.app.tigr.domain.response.message

import android.os.Parcelable
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class Keyboard(

	@field:SerializedName("buttons")
	val buttons: List<List<ButtonsItemItem?>?>? = null,

	@field:SerializedName("one_time")
	val oneTime: Boolean? = null,

	@field:SerializedName("author_id")
	val authorId: Int? = null
) : Parcelable
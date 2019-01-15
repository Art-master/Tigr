package com.app.tigr.domain.response

import android.os.Parcelable
import com.app.tigr.domain.response.dialog.Dialogs
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class ResponseDialog(

	@field:SerializedName("response")
	val response: Dialogs? = null
) : Parcelable
package com.app.tigr.domain.response.common

import android.os.Parcelable
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class Peer(

	@field:SerializedName("local_id")
	val localId: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("type")
	val type: String? = null
) : Parcelable {
	companion object {
		const val USER = "user"
		const val CHAT = "chat"
		const val GROUP = "group"
		const val EMAIL = "email"
	}
}
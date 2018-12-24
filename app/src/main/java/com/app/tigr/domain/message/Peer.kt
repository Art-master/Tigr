package com.app.tigr.domain.message

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Peer(

	@field:SerializedName("local_id")
	val localId: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("type")
	val type: String? = null
){
	companion object {
		const val USER = "user"
		const val CHAT = "chat"
		const val GROUP = "group"
		const val EMAIL = "email"
	}
}
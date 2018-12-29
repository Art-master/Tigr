package com.app.tigr.domain.response

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class MsgUsersResponse(
        @field:SerializedName("peer_id")
        val peerId: Int? = null,

        @field:SerializedName("message_id")
        val messageId: Int? = null,

        @field:SerializedName("error")
        val error: Int? = null
)
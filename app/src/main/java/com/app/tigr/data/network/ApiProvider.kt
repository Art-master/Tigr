package com.app.tigr.data.network

import com.app.tigr.App
import com.app.tigr.common.Constants
import com.app.tigr.domain.message.MsgResponse
import io.reactivex.Single
import retrofit2.Call

class ApiProvider {

    enum class Method constructor(name: String){
        CONVERSATIONS("messages.getConversations")
    }

    enum class Parameter constructor(name: String){
        CONVERSATIONS("messages.getConversations")
    }

    var appNetwork: VkApi? = App.appComponent.getNetworkConnection().connect()

    fun getMessages(token: String): Single<MsgResponse> {
       return appNetwork!!.getConversations(0,20,"all",1, 0,1, token, Constants.Network.VERSION_API)

    }

}
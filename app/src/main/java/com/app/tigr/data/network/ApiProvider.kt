package com.app.tigr.data.network

import com.app.tigr.App
import com.app.tigr.common.Constants
import com.app.tigr.common.Settings
import com.app.tigr.domain.send.Message
import com.app.tigr.domain.response.ResponseDialog
import com.app.tigr.domain.response.MsgResponse
import com.app.tigr.domain.response.ResponseMsgSend
import io.reactivex.Single

class ApiProvider {

    var appNetwork: VkApi? = App.appComponent.getNetworkConnection().connect()

    private val userToken = App.appComponent.getPreferences().get(Settings.Name.USER_TOKEN)

    private val appLanguage = Constants.APP_LANGUAGE

    fun getMessages(token: String): Single<MsgResponse> {
       return appNetwork!!.getConversations(
               0,20,"all",1, 0,1,
               token, Constants.Network.VERSION_API)
    }

    fun getDialog(startPosition: Int, loadSize: Int, userId: Int, peerId: Int): Single<ResponseDialog> {
        return appNetwork!!.getDialog(startPosition,loadSize, userId, peerId, 0,
                1, 0,1,
                userToken!!, Constants.Network.VERSION_API)
    }

    fun sendMessage(message: Message): Single<ResponseMsgSend> {
        return appNetwork!!.sendMessage(
                message.userId!!,
                message.randomId!!,
                message.peerId!!,
/*                message.domain ?: "",
                message.chatId ?: 0,
                message.userIds.toString(),*/
                message.message!!,
/*                message.latitude ?: 0F,
                message.longitude ?: 0F,
                message.attachments ?: "",
                message.replyTo ?: 0,
                message.forwardMessages ?: "",
                message.stickerId ?: 0,
                message.groupId ?: 0,
                "",//message.keyboard.to!!,
                message.payload ?: 0,
                message.dontParseLinks ?: 0,*/
                appLanguage,
                Constants.Network.TEST_MODE,
                userToken!!,
                Constants.Network.VERSION_API
        )
    }

}
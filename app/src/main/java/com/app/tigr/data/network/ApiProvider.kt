package com.app.tigr.data.network

import com.app.tigr.App
import com.app.tigr.common.Constants
import com.app.tigr.common.Settings
import com.app.tigr.domain.send.Message
import com.app.tigr.domain.response.ResponseDialog
import com.app.tigr.domain.response.ConversationsResponse
import com.app.tigr.domain.response.ResponseMsgSend
import io.reactivex.Single

class ApiProvider {

    var appNetwork: VkApi? = App.appComponent.getNetworkConnection().connect()

    private val userToken = App.appComponent.getPreferences().get(Settings.Name.USER_TOKEN)

    private val appLanguage = Constants.APP_LANGUAGE

    fun getMessages(token: String): Single<ConversationsResponse> {
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
/*                text.domain ?: "",
                text.chatId ?: 0,
                text.userIds.toString(),*/
                message.text!!,
/*                text.latitude ?: 0F,
                text.longitude ?: 0F,
                text.attachments ?: "",
                text.replyTo ?: 0,
                text.forwardMessages ?: "",
                text.stickerId ?: 0,
                text.groupId ?: 0,
                "",//text.keyboard.to!!,
                text.payload ?: 0,
                text.dontParseLinks ?: 0,*/
                appLanguage,
                Constants.Network.TEST_MODE,
                userToken!!,
                Constants.Network.VERSION_API
        )
    }

}
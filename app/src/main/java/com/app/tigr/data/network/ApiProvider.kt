package com.app.tigr.data.network

import com.app.tigr.App
import com.app.tigr.common.Constants
import com.app.tigr.common.Settings
import com.app.tigr.domain.params.MessageParam
import com.app.tigr.domain.params.ConversationsParam
import com.app.tigr.domain.params.InitLongPollServerPrm
import com.app.tigr.domain.params.LongPollServerPrm
import com.app.tigr.domain.response.*
import com.app.tigr.domain.response.lpserver.InitLongPollServer
import io.reactivex.Single

class ApiProvider {

    var appNetwork: VkApi = App.appComponent.getNetworkConnection().connect()!!

    private val userToken = App.appComponent.getPreferences().get(Settings.Name.USER_TOKEN)!!

    private val appLanguage = Constants.APP_LANGUAGE
    private val testMode = Constants.Network.TEST_MODE
    private val versionApi = Constants.Network.VERSION_API

    fun getMessages(params: ConversationsParam): Single<ConversationsRsp> {
        return appNetwork.getConversations(
                offset = params.offset,
                count = params.count,
                filter = params.filter,
                extended = params.extended,
                lang = appLanguage,
                testMode = testMode,
                token = userToken,
                versionApi = versionApi)
    }

    fun getDialog(startPosition: Int, loadSize: Int, userId: Int, peerId: Int): Single<DialogRsp> {
        return appNetwork.getDialog(
                offset = startPosition,
                count = loadSize,
                userId = userId,
                peerId = peerId,
                rev = 0,
                extended = 1,
                lang = appLanguage,
                testMode = testMode,
                token = userToken,
                versionApi = versionApi)
    }

    fun sendMessage(message: MessageParam): Single<MsgSendRsp> {
        return appNetwork.sendMessage(
                userId = message.userId!!,
                randomId = message.randomId,
                peerId = message.peerId!!,
/*                text.domain ?: "",
                text.chatId ?: 0,
                text.userIds.toString(),*/
                message = message.text,
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
                lang = appLanguage,
                testMode = testMode,
                token = userToken,
                versionApi = versionApi)
    }

    fun getLongPoolServer(data: LongPollServerPrm): Single<LongPollServerRsp> {
        return appNetwork.getLongPoolServer(
                needPts = data.needPts,
                groupId = data.groupId,
                lpVersion = data.lpVersion,
                lang = appLanguage,
                testMode = testMode,
                token = userToken,
                versionApi = versionApi)
    }

    fun initLongPoolServer(data: InitLongPollServerPrm): Single<InitLongPollServer> {
        val request = data.run {
            "https://$server?act=a_check&key=$key&ts=$ts&wait=$wait&mode=$mode&version=$version"
        }
        return appNetwork.initLongPoolServer(request)
    }
}
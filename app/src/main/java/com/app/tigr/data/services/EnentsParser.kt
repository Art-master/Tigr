package com.app.tigr.data.services

import android.content.Context
import android.content.Intent
import com.app.tigr.common.Constants.*
import com.app.tigr.data.notification.MessageNotification
import com.app.tigr.domain.extras.Message
import com.app.tigr.domain.response.lpserver.InitLongPollServer.Code.*
import kotlinx.android.parcel.RawValue

class EnentsParser(val context: Context, val data: List<List<@RawValue Any>>) {

    enum class Pos(val num: Int) {
        CODE_EVENT(0)
    }

    private var eventKey = ""

    init {
        parsingEvents(data)
    }

    private fun parsingEvents(data: List<List<@RawValue Any>>) {
        var parseData = Message()
        for (element in data) {
            eventKey = ""
            when (element[Pos.CODE_EVENT.num]) {
                CHANGE_FLAGS_MSG.num -> {
                }
                SET_FLAGS_MSG.num -> {
                }
                RESET_FLAGS_MSG.num -> {
                }
                NEW_MSG.num.toDouble() -> {
                    eventKey = Keys.EVENT_NEW_MESSAGE.value
                    parseData = parseNewMessage(element)
                    buildNotifications(parseData)
                }
                EDIT_MSG.num -> {
                }
                READ_ALL_INPUT_MSG.num -> {
                }
                READ_ALL_OUTPUT_MSG.num -> {
                }
                FRIEND_ONLINE.num -> {
                }
                FRIEND_OFFLINE.num -> {
                }
                RESET_FLAGS_DIALOG.num -> {
                }
                REPLACE_FLAGS_DIALOG.num -> {
                }
                SET_FLAGS_DIALOG.num -> {
                }
                DELETE_ALL_MSG_IN_DIALOG.num -> {
                }
                RECOVER_MSG_IN_DIALOG.num -> {
                }
                ONE_OF_PARAM_DIALOG_CHANGED.num -> {
                }
                CHANGED_INFO_CHAT.num -> {
                }
                USER_TYPE_MSG.num -> {
                }
                USER_TYPE_CHAT.num -> {
                }
                USER_HAS_CALL.num -> {
                }
                COUNTER_IS.num -> {
                }
                NOTIFICATIONS_SET_CHANGED.num -> {
                }
                else -> {
                }
            }
            if (eventKey.isNotEmpty()) {
                val intent = prepareIntent(parseData)
                context.sendBroadcast(intent)
            }
        }
    }

    private fun prepareIntent(data: Message): Intent {
        val intent = Intent(Actions.NEW_MESSAGE.value)
        intent.putExtra(eventKey, data)
        return intent
    }

    private fun parseNewMessage(data: List<@RawValue Any>): Message {
        return Message(
                messageId = getInt(data[1]),
                flags = getInt(data[2]),
                peerId = getInt(data[3]),
                timestamp = getInt(data[4]),
                text = getString(data[5]),
                attachments = getMap(data[6])
        )
    }

    private fun getInt(data: Any) = if (data is Number) (data as Double).toInt() else 0

    private fun getString(data: Any) = if (data is String) data else ""

    private fun getMap(data: Any) = if (data is Map<*, *>) data as Map<String, String> else emptyMap()

    private fun buildNotifications(msg: Message) {
        MessageNotification(context)
                .setImageUrl("https://pp.userapi.com/c846323/v846323375/62896/BH_kmnRii0w.jpg?ava=1")
                .setUserName("")
                .setMsgText(msg.text)
                .build()
    }
}
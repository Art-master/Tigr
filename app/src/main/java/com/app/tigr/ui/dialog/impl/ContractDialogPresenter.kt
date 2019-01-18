package com.app.tigr.ui.dialog.impl

import android.content.Intent
import com.app.tigr.domain.response.ResponseMsgSend
import com.app.tigr.domain.send.Message

interface ContractDialogPresenter {
    fun viewIsReady(intent: Intent)
    fun viewIsPaused()
    fun viewIsResumed()
    fun messageIsSending(message: Message)
    fun messageIsSent(request: ResponseMsgSend)
}
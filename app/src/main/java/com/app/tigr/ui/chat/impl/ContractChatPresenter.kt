package com.app.tigr.ui.chat.impl

import com.app.tigr.domain.extras.Message

interface ContractChatPresenter {
    fun dataChanged(msg: Message)
    fun viewIsReady()
    fun viewIsPaused()
    fun viewIsResumed()
}
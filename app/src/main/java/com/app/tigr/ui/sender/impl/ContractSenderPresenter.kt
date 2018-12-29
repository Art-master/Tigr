package com.app.tigr.ui.sender.impl

import com.app.tigr.domain.send.Message

interface ContractSenderPresenter {
    fun viewIsReady()
    fun viewIsPaused()
    fun viewIsResumed()
    fun dataMaybeSend(data: Message)
}
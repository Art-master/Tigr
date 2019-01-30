package com.app.tigr.ui.chat.impl

interface ContractChatPresenter {
    fun dataChanged()
    fun viewIsReady()
    fun viewIsPaused()
    fun viewIsResumed()
}
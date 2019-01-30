package com.app.tigr.ui.chat.impl

import com.arellomobile.mvp.MvpView
import com.app.tigr.ui.chat.ChatAdapter

interface ContractChatView : MvpView {
    fun showChat(adapter: ChatAdapter)
}
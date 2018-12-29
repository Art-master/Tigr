package com.app.tigr.ui.chat.impl

import com.app.tigr.domain.response.message.Conversations
import com.arellomobile.mvp.MvpView

interface ContractChatView : MvpView {
    fun showChat(data: Conversations?)
}
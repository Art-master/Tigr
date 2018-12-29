package com.app.tigr.ui.sender.impl

import com.arellomobile.mvp.MvpView

interface ContractSenderView: MvpView {
    fun addDataIntoDialog(msgId: Int)
}
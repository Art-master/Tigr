package com.app.tigr.ui.dialog.impl

import android.content.Intent
import com.app.tigr.domain.params.MessageParam

interface ContractDialogPresenter {
    fun viewIsReady(intent: Intent)
    fun viewIsPaused()
    fun viewIsResumed()
    fun viewIsDestroyed()
    fun messageIsSending(message: MessageParam)
}
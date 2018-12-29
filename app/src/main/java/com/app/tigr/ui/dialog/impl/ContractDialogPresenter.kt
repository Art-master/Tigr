package com.app.tigr.ui.dialog.impl

import android.content.Intent

interface ContractDialogPresenter {
    fun viewIsReady(intent: Intent)
    fun viewIsPaused()
    fun viewIsResumed()
    fun dataMaybeUpdate(id: Int)
}
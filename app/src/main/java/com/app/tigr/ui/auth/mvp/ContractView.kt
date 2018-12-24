package com.app.tigr.ui.auth.mvp

import com.arellomobile.mvp.MvpView

interface ContractView : MvpView {
    fun logIn()
    fun logOut()
}
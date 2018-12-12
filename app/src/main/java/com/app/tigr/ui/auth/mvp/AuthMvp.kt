package com.app.tigr.ui.auth.mvp

import com.arellomobile.mvp.MvpView

interface AuthMvp : MvpView {
    fun logIn()
    fun logOut()
}
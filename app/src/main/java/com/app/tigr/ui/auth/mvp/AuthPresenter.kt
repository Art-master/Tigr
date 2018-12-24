package com.app.tigr.ui.auth.mvp

import android.content.Context
import com.app.tigr.App
import com.app.tigr.common.Settings
import com.app.tigr.impl.AppPreferences
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

@InjectViewState
class AuthPresenter : MvpPresenter<ContractView>() {
    lateinit var context: Context
    lateinit var preferences: AppPreferences

    fun viewIsReady() {
        val component = App.appComponent
        context = component.getContext()
        preferences = component.getPreferences()
        loginUser()
    }

    private fun loginUser() {
        if (isEmptyToken()) {
            viewState.logIn()
        } else {
            viewState.logOut()
        }
    }

    private fun isEmptyToken() = getSavedToken() == Settings.EMPTY

    fun saveToken(token: String) = preferences.set(Settings.Name.USER_TOKEN, token)

    private fun getSavedToken() = preferences.get(Settings.Name.USER_TOKEN)!!

}
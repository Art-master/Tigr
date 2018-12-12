package com.app.tigr.ui.auth.mvp

import android.content.Context
import com.app.tigr.App
import com.app.tigr.common.Settings
import com.app.tigr.impl.AppPreferences
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.vk.sdk.VKCallback
import com.vk.sdk.VKSdk
import com.vk.sdk.api.VKError

@InjectViewState
class AuthPresenter : MvpPresenter<AuthMvp>() {
    lateinit var context: Context
    lateinit var preferences: AppPreferences

    fun viewIsReady() {
        val component = App.appComponent
        context = component.getContext()
        preferences = component.getPreferences()

        VKSdk.wakeUpSession(context, object : VKCallback<VKSdk.LoginState> {
            override fun onResult(res: VKSdk.LoginState?) {
                when (res) {
                    VKSdk.LoginState.LoggedIn -> loginUser()
                    VKSdk.LoginState.LoggedOut -> viewState.logOut()
                    VKSdk.LoginState.Pending -> viewState
                    VKSdk.LoginState.Unknown -> viewState
                }
            }

            override fun onError(error: VKError?) {}
        })
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

    fun getSavedToken() = preferences.get(Settings.Name.USER_TOKEN)!!

}
package com.app.tigr

import android.content.Intent
import android.os.Bundle
import com.app.tigr.ui.auth.mvp.AuthPresenter
import com.app.tigr.ui.auth.mvp.AuthMvp
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.vk.sdk.VKAccessToken
import com.vk.sdk.VKCallback
import com.vk.sdk.VKSdk
import com.vk.sdk.VKScope
import com.vk.sdk.api.VKError
import dagger.android.AndroidInjection

class StartActivity : AuthMvp, MvpAppCompatActivity() {

    @InjectPresenter
    lateinit var presenter: AuthPresenter

    /** Scope is set of required permissions for application */
    private val scopes = arrayOf(
            VKScope.FRIENDS, VKScope.WALL, VKScope.PHOTOS, VKScope.NOHTTPS, VKScope.MESSAGES, VKScope.DOCS)

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.attachView(this)
        presenter.viewIsReady()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val callback = object : VKCallback<VKAccessToken> {
            override fun onResult(res: VKAccessToken?) {
                presenter.saveToken(res!!.accessToken)
            }

            override fun onError(error: VKError?) {
            }
        }

        if (!VKSdk.onActivityResult(requestCode, resultCode, data, callback)) {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    override fun logIn() {
        VKSdk.login(this, scopes.toString())
    }

    override fun logOut() {
        VKSdk.logout()
    }
}



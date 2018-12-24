package com.app.tigr

import android.content.Intent
import android.os.Bundle
import com.app.tigr.ui.auth.mvp.AuthPresenter
import com.app.tigr.ui.auth.mvp.ContractView
import com.app.tigr.ui.chat.mvp.ChatActivity
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.vk.sdk.VKAccessToken
import com.vk.sdk.VKCallback
import com.vk.sdk.VKSdk
import com.vk.sdk.VKScope
import com.vk.sdk.api.VKError
import dagger.android.AndroidInjection



class MainActivity : ContractView, MvpAppCompatActivity() {

    @InjectPresenter
    lateinit var presenter: AuthPresenter

    /** Scope is set of required permissions for application */
    private val scopes = arrayOf(
            VKScope.NOTIFY,//+1
            VKScope.FRIENDS,//+2
            VKScope.PHOTOS,//+4
            VKScope.AUDIO,//+8
            VKScope.VIDEO,//+16
            //Stories +64
            VKScope.PAGES,//+128
            //+256
            //+512
            VKScope.STATUS,//+1024
            VKScope.NOTES,//+2048
            VKScope.MESSAGES,//+4096
            VKScope.WALL, //+8192
            VKScope.ADS,//+32768
            //VKScope.OFFLINE,//+65536
            VKScope.DOCS,//+131072
            VKScope.GROUPS,//+262144
            VKScope.NOTIFICATIONS,//+524288
            VKScope.STATS//+1048576
            )

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(!presenter.isInRestoreState(this)){
            presenter.attachView(this)
            presenter.viewIsReady()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val callback = object : VKCallback<VKAccessToken> {
            override fun onResult(res: VKAccessToken?) {
                presenter.saveToken(res!!.accessToken)
                logOut()
            }

            override fun onError(error: VKError?) {
            }
        }

        if (!VKSdk.onActivityResult(requestCode, resultCode, data, callback)) {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    override fun logIn() {
        VKSdk.login(this, scopes.joinToString())
    }

    override fun logOut() {
        VKSdk.logout()
        val intent = Intent(applicationContext, ChatActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        startActivity(intent)
        finish()
    }
}


